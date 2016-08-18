package ru.jirs.testprojects.androidserver;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ru.jirs.testprojects.androidserver.config.DispatcherConfig;
import ru.jirs.testprojects.androidserver.config.WebConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by irs on 13.08.16.
 */
public class AplicationInitializer implements WebApplicationInitializer{

    private final static String DISPATCHER = "dispatcher";

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        ctx.register(WebConfig.class);
        servletContext.addListener(new ContextLoaderListener(ctx));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(DispatcherConfig.class);

        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER, new DispatcherServlet(dispatcherContext));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
