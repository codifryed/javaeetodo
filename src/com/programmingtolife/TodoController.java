package com.programmingtolife;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/todo")
public class TodoController {

    private Map<Integer, Todo> todoMap;
    

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getList(){
        return new ArrayList<Todo>();
    }

}
