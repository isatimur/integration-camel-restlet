package ru.blogspot.isatimur.services.controller;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by tisachenko on 25.08.15.
 */
@Path("hello_world")
public class HelloWorldService {

    @Path("{name}")
    @GET
    public Response hello(@PathParam(value = "name") String name) {
        return Response.status(Response.Status.OK).entity("Hello " + name + "!").build();
    }

}
