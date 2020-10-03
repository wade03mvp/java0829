package com.web.study.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
// uri: /rest/bmi/john/170.0/60.5, /rest/bmi/mary/162.5/55.2
// output: John bmi: 20.16...

@Path("bmi")
public class BMIService {

    @Path("name/(h)/(w)")
    @GET
    @Produces("text/plain")
    public String calcBMI(@PathParam("name") String name, @PathParam("h") double h, @PathParam("w") double w) {
        double bmi = w / Math.pow(h / 100, 2);
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        return String.format("%s bmi: %.2f", name, bmi);
    }
}
