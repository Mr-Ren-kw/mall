package com.j4h.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 16:00
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 配置的图片映射
     */
    private static final String imgPath = "file:" + Constant.UPLOAD_PATH + Constant.IMG_FILE_NAME + "/";
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 将所有访问/wx/storage/fetch/**的请求映射到文件上传的路径下 C:\Users\wanghao/upload/img（图片的保存路径）
        System.out.println(imgPath);
        registry.addResourceHandler("/wx/storage/fetch/**").addResourceLocations(imgPath);
        // super.addResourceHandlers(registry);
    }
}
