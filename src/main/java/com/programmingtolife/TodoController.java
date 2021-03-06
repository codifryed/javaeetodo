package com.programmingtolife;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Path("todo")
@RequestScoped
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
    public Response getTodoFrom(@PathParam("id") int id) {
        Todo todo = todoDAO.findById(id);
        if (todo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(todo).build();
        }
    }

    @DELETE
    public void deleteAllTodos(){
        todoDAO.findAll().forEach(todo -> todoDAO.remove(todo));
    }

    @DELETE
    @Path("{id}")
    public Response deleteTodoFrom(@PathParam("id") int id) {
        Todo todo = todoDAO.findById(id);
        if (todo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            todoDAO.remove(todo);
            return Response.ok().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTodo(Todo todo){
        if (todo == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            todo.setId(currentMaxId.getAndIncrement());
            String url = uriInfo.getRequestUri().toString() + "/" + todo.getId();
            url = url.replace("http","https");
            todo.setUrl(URI.create(url));
            return Response.ok(todoDAO.insert(todo)).build();
        }
    }

    @PATCH
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTodo(@PathParam("id") int id, Todo todo) {

        if (todo == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        todo.setId(id);
        Todo updatedTodo = todoDAO.update(todo);

        if (updatedTodo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(updatedTodo).build();
    }
}
