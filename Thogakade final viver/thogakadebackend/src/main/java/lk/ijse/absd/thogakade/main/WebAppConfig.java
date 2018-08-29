package lk.ijse.absd.thogakade.main;

import lk.ijse.absd.thogakade.repository.CustomerRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by sandunDilhan on 8/21/2018.
 */
@Configuration
@EnableWebMvc
@ComponentScan("lk.ijse.absd.thogakade")
@EnableJpaRepositories(basePackageClasses = {CustomerRepository.class})
public class WebAppConfig implements WebMvcConfigurer{

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
