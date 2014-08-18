package ua.pp.fland.web.bookkeeping.spring.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: Maksim_Bondarenko
 * Date: 8/8/14
 * Time: 5:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@ComponentScan(basePackages = {"ua.pp.fland.web.bookkeeping.web.controllers",
        "ua.pp.fland.web.bookkeeping.spring.configs"})
public class AppConfig {
}
