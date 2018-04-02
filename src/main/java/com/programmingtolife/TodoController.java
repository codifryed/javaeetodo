package com.programmingtolife;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("todo")
public class TodoController {

    @Inject
    private TodoDAO todoDAO;

//    private Set<Todo> todoSet;

//    public TodoController() {
//        todoSet = new HashSet<>();
////        todoSet.add(new Todo("todo",false,1,1));
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getAllTodos(){
        return todoDAO.findAll();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Todo getTodoFrom(@PathParam("id") int id) {
        return todoDAO.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Todo addTodo(Todo todo){
        return todoDAO.insert(todo);
    }

    @DELETE
    public void deleteAllTodos(){
        todoDAO.findAll().forEach(todo -> todoDAO.remove(todo));
    }
}
