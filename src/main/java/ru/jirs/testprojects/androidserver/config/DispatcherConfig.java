package ru.jirs.testprojects.androidserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by irs on 13.08.16.
 */
@Configuration
@EnableWebMvc
@ComponentScan("ru.jirs.testprojects.androidserver")
public class DispatcherConfig extends WebMvcConfigurerAdapter{

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        String[] definitions;
        Properties viewProperties = getViewProperties();
        definitions = new String[] {
                "/WEB-INF/view/templates/" + viewProperties.getProperty("view.mainTemplate") + "/xml_tiles/main.xml",
                "/WEB-INF/view/templates/" + viewProperties.getProperty("view.mainTemplate") + "/xml_tiles/views.xml",
            };
        tilesConfigurer.setDefinitions(definitions);
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }


    @Bean
    public UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setViewClass(TilesView.class);
        viewResolver.setOrder(1);
        return viewResolver;
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
//        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
//        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
//    }


    private Properties getViewProperties() {
        try {
            Properties properties = new Properties();
            InputStream is = getClass().getClassLoader().getResourceAsStream("view.properties");
            properties.load(is);
            return properties;
        } catch (IOException e) {
            throw  new IllegalArgumentException("Not found 'view.properties' in the classpath" , e);
        }
    }
}
