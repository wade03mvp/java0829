package com.web.study.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("hello")
public class HelloService {
    
    @Path("john")
    @GET
    @Produces("text/plain") // 產出文件格式
    public String hello() {
        return "Hello Rest";
    }
}
