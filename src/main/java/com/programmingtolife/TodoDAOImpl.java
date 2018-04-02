package com.programmingtolife;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class TodoDAOImpl implements TodoDAO {

    private Set<Todo> todoSet;

    @PostConstruct
    public void init() {
        todoSet = new HashSet<>();
    }


    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(todoSet);
    }

    @Override
    public Todo findById(long id) {
        return todoSet.stream().filter(todo -> todo.getId() == id).findFirst().get();
    }

    @Override
    public boolean remove(Todo todo) {
        return false;
    }

    @Override
    public Todo insert(Todo todo) {
        todo.setId(todoSet.size() + 1);
        return todoSet.add(todo) ? todo : null;
    }


}
