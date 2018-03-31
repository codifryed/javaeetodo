package com.programmingtolife;

public class Todo {

    private String title;
    private boolean completed;
    private Integer order;
    private int id;

    public Todo() {
    }

    public Todo(String title) {
        this.title = title;
    }

    public Todo(String title, boolean completed, Integer order, int id) {
        this.title = title;
        this.completed = completed;
        this.order = order;
        this.id = id;
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

    private <T> T nonNull(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id != todo.id ? false : true;
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
