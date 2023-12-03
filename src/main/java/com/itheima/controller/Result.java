package com.itheima.controller;

/**
 * 创建协议类，将所有操作成败信息都封装成状态码，同时提供操作失败信息描述   以便和前端进行交互配合
 */
public class Result {
    private Object data;
    private Integer code;
    private String msg;

    public Result() {
    }

    public Result(Integer code,Object data ) {
        this.data = data;
        this.code = code;
    }

    public Result(Integer code,Object data , String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
