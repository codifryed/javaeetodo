package com.programmingtolife;

import java.util.Objects;

public class Todo {

    private String item;
    private boolean completed;
    private Integer order;

    public Todo() {
    }

    public Todo(String item) {
        this.item = item;
    }

    public Todo(String item, boolean completed, Integer order) {
        this.item = item;
        this.completed = completed;
        this.order = order;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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

    private <T> T nonNull(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(item, todo.item);
    }

    @Override
    public int hashCode() {

        return item.hashCode();
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
