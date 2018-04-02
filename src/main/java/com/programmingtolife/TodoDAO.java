package com.programmingtolife;

import java.util.List;

public interface TodoDAO {

    List<Todo> findAll();

    Todo findById(int id);

    boolean remove(Todo todo);

    Todo insert(Todo todo);

}
