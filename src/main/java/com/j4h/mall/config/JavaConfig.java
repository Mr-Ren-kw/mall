package com.j4h.mall.config;

import com.j4h.mall.converter.String2DateConverter;
import com.j4h.mall.converter.String2DoubleConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.support.ConfigurableConversionService;

import javax.annotation.PostConstruct;

@Configuration
public class JavaConfig {
    @Autowired
    ConfigurableConversionService conversionService;

    @PostConstruct
    public void addConverterToService() {
        conversionService.addConverter(new String2DateConverter());
        conversionService.addConverter(new String2DoubleConverter());
    }

    @Bean
    @Primary
    public ConfigurableConversionService configurableConversionService() {
        return conversionService;
    }
}
