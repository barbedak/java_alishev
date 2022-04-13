package ru.kurochkin.springcourse.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletIntitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class}; //указываем класс-конфигурацию
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"}; //любой url (/) должен перенаправляться на сервлет
    }
}
