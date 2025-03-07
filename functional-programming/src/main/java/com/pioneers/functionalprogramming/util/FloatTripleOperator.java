package com.pioneers.functionalprogramming.util;

import lombok.NonNull;

@FunctionalInterface
public interface FloatTripleOperator {

    float apply(float a, float b, float c);

    default FloatTripleOperator andThen(@NonNull FloatTripleOperator after) {
        return (float a, float b, float c) -> after.apply(apply(a, b, c), b, c);
    }
}
