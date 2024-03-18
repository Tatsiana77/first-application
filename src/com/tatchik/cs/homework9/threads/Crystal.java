package com.tatchik.cs.homework9.threads;

public class Crystal {
    public enum Type {
        RED, WHITE
    }

    private Type type;

    public Crystal(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
