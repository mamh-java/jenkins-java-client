package com.mage.jenkins.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class UrlUtils {

    /**
     * The default size to use for string buffers.
     */
    private static final int DEFAULT_BUFFER_SIZE = 64;

    /**
     * Utility Class.
     */
    private UrlUtils() {
        //do nothing
    }

    /**
     * Parses the provided job name for folders to get the full path for the job.
     *
     * @param jobName the fullName of the job.
     * @return the path of the job including folders if present.
     */
    public static String toFullJobPath(final String jobName) {
        final String[] parts = jobName.split("/");
        if (parts.length == 1) return parts[0];
        final StringBuilder sb = new StringBuilder(DEFAULT_BUFFER_SIZE);

        for (int i = 0; i < parts.length; i++) {
            sb.append(parts[i]);
            if (i != parts.length - 1) sb.append("/job/");
        }
        return sb.toString();
    }


    /**
     * Join two paths together taking into account leading/trailing slashes.
     *
     * @param path1 the first path
     * @param path2 the second path
     * @return the joins path
     */
    public static String join(final String path1, final String path2) {
        if (path1.isEmpty() && path2.isEmpty()) return "";
        if (path1.isEmpty() && !path2.isEmpty()) return path2;
        if (path2.isEmpty() && !path1.isEmpty()) return path1;
        final StringBuilder sb = new StringBuilder(DEFAULT_BUFFER_SIZE);
        sb.append(path1);
        if (sb.charAt(sb.length() - 1) == '/') sb.setLength(sb.length() - 1);
        if (path2.charAt(0) != '/') sb.append('/');
        sb.append(path2);
        return sb.toString();
    }


    /**
     * Create a JSON URI from the supplied parameters.
     *
     * @param uri     the server URI
     * @param context the server context if any
     * @param path    the specific API path
     * @return new full URI instance
     */
    public static URI toJsonApiUri(final URI uri, final String context, final String path) {
        String p = path;
        if (!p.matches("(?i)https?://.*")) p = join(context, p);

        if (!p.contains("?")) {
            p = join(p, "api/json");
        } else {
            final String[] components = p.split("\\?", 2);
            p = join(components[0], "api/json") + "?" + components[1];
        }
        return uri.resolve("/").resolve(p.replace(" ", "%20"));
    }


    /**
     * Create a URI from the supplied parameters.
     *
     * @param uri     the server URI
     * @param context the server context if any
     * @param path    the specific API path
     * @return new full URI instance
     */
    public static URI toNoApiUri(final URI uri, final String context, final String path) {
        final String p = path.matches("(?i)https?://.*") ? path : join(context, path);
        return uri.resolve("/").resolve(p);
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param root 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String joinParam(String root, List<NameValuePair> list) {
        try {
            URI uri = new URIBuilder(root).addParameters(list).build();
            return uri.toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return root;
    }

    public static String joinParam(String root, String name, List<String> values) {
        List<NameValuePair> list = values.stream().map(p ->
                new BasicNameValuePair(name, p)).collect(Collectors.toList());
        return joinParam(root, list);
    }

    public static String joinParam(String root, Map<String, String> values) {
        List<NameValuePair> list = values.entrySet().stream().map(p ->
                new BasicNameValuePair(p.getKey(), p.getValue())).collect(Collectors.toList());
        return joinParam(root, list);
    }

    /**
     * Join two paths together taking into account leading/trailing slashes.
     *
     * @param path1 the first path
     * @param path2 the second path
     * @return the joins path
     */
    public static String joinPath(final String path1, final String path2) {
        if (path1.isEmpty() && path2.isEmpty()) return "";
        if (path1.isEmpty()) return path2;
        if (path2.isEmpty()) return path1;

        final StringBuilder sb = new StringBuilder(DEFAULT_BUFFER_SIZE);
        sb.append(path1);
        if (sb.charAt(sb.length() - 1) == '/') sb.setLength(sb.length() - 1);
        if (path2.charAt(0) != '/') sb.append('/');
        sb.append(path2);
        return sb.toString();
    }


    public static URI joinPath(final URI uri, final String context, final String path) {
        URIBuilder uriBuilder = new URIBuilder(uri);
        uriBuilder = addPath(uriBuilder, context);
        try {
            return uriBuilder.build().normalize().resolve("/").resolve(path);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String p = path;
        if (!p.matches("(?i)https?://.*")) {
            p = joinPath(context, p);
        }
        return uri.resolve("/").resolve(p.replace(" ", "%20"));
    }

    private static URIBuilder addPath(URIBuilder uriBuilder, String subPath) {
        if (subPath == null || subPath.isEmpty() || "/".equals(subPath)) {
            return uriBuilder;
        }
        return uriBuilder.setPath(appendSegmentToPath(uriBuilder.getPath(), subPath));
    }

    private static String appendSegmentToPath(String path, String segment) {
        if (path == null || path.isEmpty()) {
            path = "/";
        }

        if (path.charAt(path.length() - 1) == '/' || segment.startsWith("/")) {
            return path + segment;
        }

        return path + "/" + segment;
    }

}
