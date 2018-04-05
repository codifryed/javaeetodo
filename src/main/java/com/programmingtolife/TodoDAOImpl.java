package com.programmingtolife;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;

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
    public Todo findById(int id) {
        return lookupTodoFrom(id).get();
    }

    private Optional<Todo> lookupTodoFrom(int id) {
        return todoSet.stream().filter(todo -> todo.getId() == id).findFirst();
    }

    @Override
    public boolean remove(Todo todo) {
        return todoSet.remove(todo);
    }

    @Override
    public Todo insert(Todo todo) {
        return todoSet.add(todo) ? todo : null;
    }

    @Override
    public Todo update(Todo newTodo) {
        Optional<Todo> originalTodo = lookupTodoFrom(newTodo.getId());
        Todo updatedTodo = null;
        if (!originalTodo.isPresent()) {
            return updatedTodo;
        }

        todoSet.remove(originalTodo.get());

        updatedTodo = originalTodo.get().update(newTodo);

        todoSet.add(updatedTodo);

        return updatedTodo;
    }


}
