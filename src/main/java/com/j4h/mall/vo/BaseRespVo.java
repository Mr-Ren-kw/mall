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

    public static BaseRespVo fail(Integer errorNo, String errorMsg) {
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrno(errorNo);
        baseRespVo.setErrmsg(errorMsg);
        return baseRespVo;
    }

    public static BaseRespVo fail() {
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrno(-1);
        baseRespVo.setErrmsg("错误");
        return baseRespVo;
    }

    public static BaseRespVo updatedDataFailed() {
        return fail(505, "更新数据失败");
    }
    public static BaseRespVo createDataFailed() {
        return fail(510, "创建数据失败");
    }

    public static BaseRespVo badArgument() {
        return fail(401, "参数不对");
    }
}
