package com.nasa.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class RobotController {

	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getUser() {
		return "{\"result\":\"Hello World\"}";
	}

    @GET
    @Path("/xml")
    @Produces({ "application/xml" })
    public String getHelloWorldXML() {
        return "<xml><result> Hello World</result></xml>";
    }
	
	/*
	@GET
	@Path("/vip")
	public Response getUserVIP() {
		return Response.status(200).entity("getUserVIP is called").build();
	}

	@GET
	@Path("{name}")
	public Response getUserByName(@PathParam("name") String name) {
		return Response.status(200).entity("getUserByName is called, name : " + name).build();
	}

	@GET
	@Path("{id : \\d+}")
	public Response getUserById(@PathParam("id") String id) {
		return Response.status(200).entity("getUserById is called, id : " + id).build();
	}

	@GET
	@Path("/username/{username : [a-zA-Z][a-zA-Z_0-9]}")
	public Response getUserByUserName(@PathParam("username") String username) {
		return Response.status(200).entity("getUserByUserName is called, username : " + username).build();
	}

	@GET
	@Path("/books/{isbn : \\d+}")
	public Response getUserBookByISBN(@PathParam("isbn") String isbn) {
		return Response.status(200).entity("getUserBookByISBN is called, isbn : " + isbn).build();
	}
	*/

}
