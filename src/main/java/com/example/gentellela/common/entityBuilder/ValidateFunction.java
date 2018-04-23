package com.example.gentellela.common.entityBuilder;

@FunctionalInterface
public interface ValidateFunction<T> {
    void validate(T t);
}
