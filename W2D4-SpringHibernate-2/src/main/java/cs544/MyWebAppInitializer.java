package cs544;

import jakarta.servlet.FilterRegistration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(Config.class);
        container.addListener(new ContextLoaderListener(rootContext));
        FilterRegistration.Dynamic openInView = container.addFilter("OpenInView", new OpenEntityManagerInViewFilter());
        openInView.addMappingForUrlPatterns(null, true, "/*");
    }
}