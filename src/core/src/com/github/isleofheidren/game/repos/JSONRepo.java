package com.github.isleofheidren.game.repos;

public interface JSONRepo<T> {
    public T get(String id);
}
