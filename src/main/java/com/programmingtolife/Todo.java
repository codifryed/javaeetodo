package com.programmingtolife;

import java.util.Objects;

public class Todo {

    private String item;
    private boolean completed;
    private Integer order;
    private int id;

    public Todo() {
    }

    public Todo(String item) {
        this.item = item;
    }

    public Todo(String item, boolean completed, Integer order, int id) {
        this.item = item;
        this.completed = completed;
        this.order = order;
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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
                "item='" + item + '\'' +
                ", completed=" + completed +
                ", order=" + order +
                '}';
    }


}
