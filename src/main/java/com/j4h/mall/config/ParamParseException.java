package com.j4h.mall.config;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ParamParseException {
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public BaseRespVo resolveException(NumberFormatException e) {
        BaseRespVo<Object> result = new BaseRespVo<>();
        result.setErrmsg("参数值不对");
        result.setErrno(402);
        return result;
    }
}