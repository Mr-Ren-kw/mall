package com.j4h.mall.converter;

import org.springframework.core.convert.converter.Converter;

public class String2DoubleConverter implements Converter<String,Double> {
    @Override
    public Double convert(String s) {
        return Double.parseDouble(s);
    }
}
