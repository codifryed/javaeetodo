package com.programmingtolife;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Path("todo")
public class TodoController {

    @Inject
    private TodoDAO todoDAO;

    @Context
    private UriInfo uriInfo;

    @Context
    private SecurityContext securityContext;

    private static AtomicInteger currentMaxId = new AtomicInteger(1);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getAllTodos(){
        return todoDAO.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Todo getTodoFrom(@PathParam("id") int id) {
        return todoDAO.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Todo addTodo(final Todo todo){
        todo.setId(currentMaxId.getAndIncrement());
        todo.setUrl(URI.create(uriInfo.getRequestUri().toString() + "/" + todo.getId()));
        return todoDAO.insert(todo);
    }

    @DELETE
    public void deleteAllTodos(){
        todoDAO.findAll().forEach(todo -> todoDAO.remove(todo));
    }
}
