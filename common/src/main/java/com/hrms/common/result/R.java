package com.hrms.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 统一响应类
 * @param <T>
 */
@Data
@AllArgsConstructor
public class R<T> {

    /**
     * 操作是否成功
     */
    private boolean success;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 成功响应
     *
     * @param data 返回数据
     * @param <T>  数据类型
     * @return R
     */
    @SafeVarargs
    public static <T> R<T> ok(T... data) {
        return new R<>(true, "请求成功", data.length > 0? data[0] : null);
    }

    /**
     * 成功响应
     *
     * @param msg 返回信息
     * @param data 返回数据
     * @param <T>  数据类型
     * @return R
     */
    @SafeVarargs
    public static <T> R<T> ok(String msg, T... data) {
        return new R<>(true, msg, data.length > 0 ? data[0] : null);
    }

    /**
     * 失败响应
     *
     * @param msg 返回信息
     * @param <T>  数据类型
     * @return R
     */
    public static <T> R<T> fail(String... msg){
        return new R<>(false, msg.length > 0 ? msg[0] : "操作失败", null);
    }

    /**
     * 已创建响应
     *
     * @param msg 返回信息
     * @param <T>  数据类型
     * @return R
     */
    public static <T> R<T> created(String... msg){
        return new R<>(true, msg.length > 0 ? msg[0] : "创建成功", null);
    }

    @SafeVarargs
    public static <T> R<T> created(T...data){
        return new R<>(true, "创建成功", data.length > 0? data[0] : null);
    }

    /**
     * 已创建响应
     *
     * @param msg 返回信息
     * @param data 返回数据
     * @param <T>  数据类型
     * @return R
     */
    @SafeVarargs
    public static <T> R<T> created(String msg, T...data){
        return new R<>(true, msg, data.length > 0? data[0] : null);
    }

    /**
     * 已更新响应
     *
     * @param msg 返回信息
     * @param <T>  数据类型
     * @return R
     */
    public static <T> R<T> updated(String... msg){
        return new R<>(true, msg.length > 0 ? msg[0] : "更新成功", null);
    }

    @SafeVarargs
    public static <T> R<T> updated(T...data){
        return new R<>(true, "更新成功", data.length > 0? data[0] : null);
    }

    /**
     * 已更新响应
     *
     * @param msg 返回信息
     * @param data 返回数据
     * @param <T>  数据类型
     * @return R
     */
    @SafeVarargs
    public static <T> R<T> updated(String msg, T...data){
        return new R<>(true, msg, data.length > 0? data[0] : null);
    }

    /**
     * 已删除响应
     *
     * @param msg 返回信息
     * @param <T>  数据类型
     * @return R
     */
    public static <T> R<T> deleted(String... msg){
        return new R<>(true, msg.length > 0 ? msg[0] : "删除成功", null);
    }

    /**
     * 系统异常响应
     *
     * @param <T>  数据类型
     * @return R
     */
    public static <T> R<T> error() {
        return new R<>(false, "系统异常", null);
}
}
