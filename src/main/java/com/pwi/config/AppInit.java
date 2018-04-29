package com.pwi.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 * The purpose of this class is to initialize the application.
 */
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer{

    /**
     * This function get the root configuration for application
     * @return Class<?>
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ AppConfig.class, DBConfig.class};
    }

    /**
     * Get the servlet context
     * @return
     */

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    /**
     * get the servlet mappings and return as String
     * @return String[] array of servlet mappings.
     */

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
