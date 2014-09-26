package ua.pp.fland.web.bookkeeping.spring.configs.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: Maksim_Bondarenko
 * Date: 8/8/14
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "ua.pp.fland.web.bookkeeping.web.controllers")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
