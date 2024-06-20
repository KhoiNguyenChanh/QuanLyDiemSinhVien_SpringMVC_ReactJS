/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author chanh
 */
//de bien class nay thanh ro dau
@Configuration
//kich hoat cac config mac dinh, dung gi sai nay
@EnableWebMvc
@EnableTransactionManagement
//cho scan cac annotation
@ComponentScan(basePackages = {
    "com.nck.controllers",
    "com.nck.repositories",
    "com.nck.services"

})
public class WebAppContextConfig implements WebMvcConfigurer{

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    //sau khi t?o tiles, chuongr trình tu di tim tiles, ko có dùng resolver trong day nua
//    resolver lay du lieu trong pages, phai bao bean neu ko no se ko biet
//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver(){
//        InternalResourceViewResolver r = new InternalResourceViewResolver();
//        //2 nv: chi dinh "vi tri thu muc" va chi dinh "loai"
//        r.setViewClass(JstlView.class);
//        //vi tri thu muc (tien to)
//        r.setPrefix("/WEB-INF/pages/");
//        //vi tri duoi? (hau to)
//        r.setSuffix(".jsp");
//        return r;
//    }
    
}
