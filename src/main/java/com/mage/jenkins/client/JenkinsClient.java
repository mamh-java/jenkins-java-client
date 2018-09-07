package com.mage.jenkins.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.mage.jenkins.model.BaseModel;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class JenkinsClient extends AbstractJenkinsClient implements JenkinsConnection {

    public JenkinsClient(URI uri) {
        this(uri, HttpClientBuilder.create());
    }

    /**
     * Create an unauthenticated Gerrit HTTP client
     *
     * @param uri    Location of the Gerrit server (ex. http://localhost:8080)
     * @param client Configured CloseableHttpClient to be used
     */
    public JenkinsClient(URI uri, CloseableHttpClient client) {
        this.context = uri.getPath();
        if (!context.endsWith("/")) {
            context += "/";
        }
        this.uri = uri;
        this.client = client;
        this.mapper = getDefaultMapper();
    }

    public JenkinsClient(URI uri, HttpClientBuilder builder) {
        this(uri, builder.build());
    }

    public JenkinsClient(String url, String username, String password) throws URISyntaxException {
        this(new URI(url), username, password);
    }

    public JenkinsClient(URI uri, String username, String password) {
        this(uri, HttpClientBuilder.create(), username, password);
    }

    public JenkinsClient(URI uri, HttpClientBuilder builder, String username, String password) {
        this(uri, addAuth(builder, uri, username, password));
        if (StringUtils.isNotBlank(username)) {
            httpContext = new BasicHttpContext();
            httpContext.setAttribute("preemptive-auth", new BasicScheme());
        }
    }

    /**
     * 获取一个list
     *
     * @param path       Endpoints,也就是url地址
     * @param elementCls list中元素类型的
     * @param listCls    返回的list的类型，一般可以是ArrayList
     * @param <E>
     * @param <C>
     * @return
     * @throws IOException
     */
    @Override
    public <E extends BaseModel, C extends List>
    List<E> get(String path, Class<E> elementCls, Class<C> listCls) {
        try {
            JavaType javaType = mapper.getTypeFactory().
                    constructParametricType(listCls, elementCls);
            byte[] raw = getRaw(path);
            if (raw != null) {
                return mapper.readValue(getRaw(path), javaType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取为一个map对象
     *
     * @param path
     * @param eCls
     * @param mapCls
     * @param keyCls
     * @param <E>
     * @param <K>
     * @param <M>
     * @return
     * @throws IOException
     */
    @Override
    public <E extends BaseModel, K, M extends Map<K, E>>
    Map<K, E> get(String path, Class<E> eCls, Class<M> mapCls, Class<K> keyCls) {
        try {
            JavaType javaType = mapper.getTypeFactory().
                    constructParametricType(mapCls, keyCls, eCls);
            byte[] raw = getRaw(path);
            if (raw != null) {
                return mapper.readValue(raw, javaType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取为一个单个的对象
     *
     * @param path Endpoints,也就是url地址
     * @param cls
     * @param <E>
     * @return
     * @throws IOException
     */
    @Override
    public <E extends BaseModel>
    E get(String path, Class<E> cls) {
        try {
            byte[] raw = getRaw(path);
            if (raw != null) {
                return mapper.readValue(raw, cls);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public String getString(String path) {
        try {
            byte[] raw = getRaw(path);
            if (raw != null) {
                return mapper.readValue(raw, String.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getList(String path) {
        try {
            JavaType javaType = mapper.getTypeFactory().
                    constructParametricType(List.class, String.class);
            byte[] raw = getRaw(path);
            if (raw != null) {
                return mapper.readValue(raw, javaType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public byte[] getRaw(String path) {
        HttpResponse response = null;
        try {
            response = request(path, HttpGet.METHOD_NAME, null);
            byte[] bytes = getResponseBytes(response);
            return bytes;
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return null;
    }

    @Override
    public void post(String path, Map<String, String> params) {
        if (params != null) {
            String value;
            try {
                value = mapper.writeValueAsString(params);
                HttpResponse response = request(path, HttpPost.METHOD_NAME, value);
            } catch (JsonProcessingException e) {
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                HttpResponse response = request(path, HttpPost.METHOD_NAME, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Closes underlying resources. Any I/O errors whilst closing are logged
     * with debug log level Closed instances should no longer be used Closing an
     * already closed instance has no side effects
     */
    @Override
    public void close() {
        try {
            client.close();
        } catch (IOException ex) {
            LOGGER.debug("I/O exception closing client", ex);
        }
    }
}
