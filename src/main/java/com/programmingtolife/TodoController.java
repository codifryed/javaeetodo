package com.programmingtolife;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
import java.util.stream.Collectors;

@Path("todo")
public class TodoController {

    private Set<Todo> todoSet;

    public TodoController() {
        todoSet = new HashSet<>();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getList(){
        return todoSet.stream().collect(Collectors.toList());
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Todo getTodoFromId(@PathParam("id") int id) {
        return todoSet.stream().filter(todo -> todo.getId() == id).findFirst().get();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Todo addItem(Todo todo){
        todo.setId(todoSet.size() + 1);
        todoSet.add(todo);
        return todo;
    }
}
