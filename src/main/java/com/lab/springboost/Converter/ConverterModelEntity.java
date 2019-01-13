package com.lab.springboost.Converter;

public interface ConverterModelEntity<M, E> {
    E toEntity(M model);
    M toModel(E entity);
}
