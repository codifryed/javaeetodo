package com.programmingtolife;

import java.util.List;

public interface TodoDAO {

    List<Todo> findAll();

    Todo findById(long id);

    boolean remove(Todo todo);

    Todo insert(Todo todo);

}
