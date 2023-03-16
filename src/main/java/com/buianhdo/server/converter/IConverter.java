package com.buianhdo.server.converter;

import java.util.Optional;

public interface IConverter<E,I, O> {
    public E toEntity(I Input);
    public E toEntity(I Input,  Optional<E> Entity);
    public O toOutput(E Entity);
}
