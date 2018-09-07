package com.mage.jenkins.client;


import com.mage.jenkins.model.BaseModel;

import java.io.Closeable;
import java.util.List;
import java.util.Map;

public interface JenkinsConnection extends Closeable {

    /**
     * 获取为一个list对象，里面存放的元素类型是E
     *
     * @param path       Endpoints,也就是url地址
     * @param elementCls list中元素类型的
     * @param listCls    返回的list的类型，一般可以是ArrayList
     * @param <E>        元素类型
     * @param <C>        集合类型
     * @return
     */
    <E extends BaseModel, C extends List>
    List<E> get(String path, Class<E> elementCls, Class<C> listCls)  ;

    /**
     * 获取为一个map对象，map的key类似是K，value类型是E
     *
     * @param path
     * @param elementCls
     * @param mapCls
     * @param keyCls
     * @param <E>
     * @param <K>
     * @param <M>
     * @return
     */
    <E extends BaseModel, K, M extends Map<K, E>>
    Map<K, E> get(String path, Class<E> elementCls, Class<M> mapCls, Class<K> keyCls)  ;

    /**
     * 获取为一个单个的对象,类型是E
     *
     * @param path Endpoints,也就是url地址
     * @param cls
     * @param <E>
     * @return
     */
    <E extends BaseModel>
    E get(String path, Class<E> cls);


    List<String> getList(String path)  ;

    byte[] getRaw(String path) ;


    /**
     * 获取单个字符串值的
     *
     * @param path
     * @return
     */
    String getString(String path)  ;

    void post(String path, Map<String, String> params);
}
