package com.j4h.mall.vo;

public class BaseRespVo<T> {
    T data;
    String errmsg;
    int errno;


    public static <T> BaseRespVo<T> ok(T data) {
        BaseRespVo<T> tBaseRespVo = new BaseRespVo<>();
        tBaseRespVo.setData(data);
        tBaseRespVo.setErrmsg("ok");
        tBaseRespVo.setErrno(0);
        return tBaseRespVo;
    }

    public static <T> BaseRespVo<T> error(T data) {
        BaseRespVo<T> tBaseRespVo = new BaseRespVo<>();
        tBaseRespVo.setData(data);
        tBaseRespVo.setErrmsg("error");
        tBaseRespVo.setErrno(5000);
        return tBaseRespVo;
    }

    public BaseRespVo() {
    }

    public BaseRespVo(T data, String errmsg, int errno) {
        this.data = data;
        this.errmsg = errmsg;
        this.errno = errno;
    }

    @Override
    public String toString() {
        return "BaseRespVo{" +
                "data=" + data +
                ", errmsg='" + errmsg + '\'' +
                ", errno=" + errno +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }
}
