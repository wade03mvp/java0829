package com.web.study.rest;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new LinkedHashSet<>();
        classes.add(HelloService.class); // 建立新物件
        classes.add(BMIService.class);
        //classes.add(CountSingleTonService.class);
        return classes; 
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> set = new LinkedHashSet<>();
        set.add(new CountSingleTonService());
        return set;
    }
  
}
