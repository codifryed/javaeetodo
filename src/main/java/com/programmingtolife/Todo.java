package com.programmingtolife;

import java.net.URI;

public class Todo {

    private int id;
    private String title;
    private boolean completed;
    private Integer order;
    private URI url;

    public Todo() {
    }

    public Todo(String title) {
        this.title = title;
    }

    public Todo(int id, String title, boolean completed, Integer order, URI url) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.order = order;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    public boolean isCompleted() {
        return nonNull(completed, false);

    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Integer getOrder() {
        return nonNull(order, 0);
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Todo update(Todo newTodo) {
        return new Todo(id,
                nonNull(newTodo.title, title),
                nonNull(newTodo.completed, completed),
                nonNull(newTodo.order, order),
                nonNull(newTodo.url, url)
                );
    }

    private <T> T nonNull(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id;
    }

    @Override
    public int hashCode() {

        return id;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", completed=" + completed +
                ", order=" + order +
                '}';
    }

}
