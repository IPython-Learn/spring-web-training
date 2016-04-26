package com.innominds.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * This class equals to /WEB-INF/web.xml
 *
 *
 */
public class WebDotXMLConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { ApplicationContextXMLConfig.class, SecurityConfig.class }; // equals to applicationContext.xml , springSecurity.xml
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { DispatcherServletXMLConfig.class }; // equals to dispatcher-servlet.xml
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected void customizeRegistration(Dynamic registration) {
        super.customizeRegistration(registration);
        registration.setLoadOnStartup(1);
    }

    // @Override
    // public DispatcherServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
    // final DispatcherServlet ds = new DispatcherServlet(servletAppContext);
    // ds.setThrowExceptionIfNoHandlerFound(true);
    // return ds;
    // }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        final FilterRegistration.Dynamic securityFilterChain = servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy(
                "springSecurityFilterChain"));
        securityFilterChain.addMappingForUrlPatterns(
                EnumSet.of(DispatcherType.ERROR, DispatcherType.ASYNC, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.REQUEST), true,
                new String[] { "/*" });

    }

}
