package cs544;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterRegistration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import java.util.EnumSet;

public class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        // Create the Spring 'root' application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(Config.class);

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        // Register the OpenEntityManagerInViewFilter
        FilterRegistration.Dynamic filter = container.addFilter("openEntityManagerInViewFilter", OpenEntityManagerInViewFilter.class);
        filter.setInitParameter("entityManagerFactoryBeanName", "entityManagerFactory");
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), true, "/*");

        // Create the Spring MVC application context
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(Config.class);

        // Create and register the DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
        container.addServlet("mvc", dispatcherServlet).addMapping("/");
    }
}
