package ru.jirs.testprojects.androidserver.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by irs on 13.08.16.
 */
@Configuration
@EnableWebMvc
@ComponentScan("ru.jirs.testprojects.androidserver")
public class WebConfig extends WebMvcConfigurerAdapter{

}
