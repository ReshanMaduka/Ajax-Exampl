package com.howtodoinjava.demo.spring.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Reshan on 14/08/2018.
 */
@Configuration
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
            @Override
            protected Class<?>[] getRootConfigClasses() {
                return new Class[]{WebRootConfig.class,WebSecurityConfig.class};
            }

            @Override
            protected Class<?>[] getServletConfigClasses() {
                return new Class[]{WebAppConfig.class};
            }

            @Override
            protected String[] getServletMappings() {
                return new String[]{"/"};
    }
}
