/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author chanh
 */
//dau nao, noi nhan request xu ly moi thu
public class DispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer{
//cai dong ben duoi thuong nam trong web.xml :1
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
            HibernateConfigs.class,
            TilesConfig.class,
            SpringSecurityConfig.class,
            JwtSecurityConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //chi cho dispathcer co ro dau
        return new Class[]{
            WebAppContextConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
    
}
