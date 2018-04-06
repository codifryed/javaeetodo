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
        Optional<Todo> todo = lookupTodoFrom(id);
        if (todo.isPresent()) {
            return todo.get();
        } else {
            return null;
        }
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
        if (!originalTodo.isPresent()) {
            return null;
        }

        todoSet.remove(originalTodo.get());

        Todo updatedTodo = originalTodo.get().update(newTodo);

        todoSet.add(updatedTodo);

        return updatedTodo;
    }


}
