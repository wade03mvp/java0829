package com.web.study.rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("hello")
public class HelloService {
    // uri: /rest/hello/john
    // url: http://localhost:8080/JavaWeb0829/rest/hello/john
    @Path("john")
    @GET
    @Produces("text/plain") // 產出文件格式
    public String hello() {
        return "Hello John";
    }
    
    // uri: /rest/hello/mary, /rest/hello/john ...
    @Path("(name)")
    public String hello(@PathParam("name") String name) {
        return "Hello " + name;
    }
    
    // uri: /rest/hello/10/20
    @Path("(x)/(y)")
    @GET
    @Produces("text/plain")
    public String add(@PathParam("x") Integer x, @PathParam("y")Integer y) {
        return "Sum: " + (x + y);
    }
    
    // uri: /rest/mango/customers
    @Path("/customers")
    @GET
    @Produces("application/json")
    public List readAllCustomer(@Context HttpServletRequest req) {
        EntityManagerFactory emf = (EntityManagerFactory)req.getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Customer.findAll").getResultList();
    }
}
