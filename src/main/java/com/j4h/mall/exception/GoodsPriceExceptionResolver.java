package com.j4h.mall.exception;

import com.j4h.mall.vo.BaseRespVo;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@ResponseBody
public class GoodsPriceExceptionResolver {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseRespVo handlerDoubleStringException(HttpMessageNotReadableException e) {
        return new BaseRespVo(null, "参数值不对", 402);
    }
}
