/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package java.util.functions;


/**
 * Apply a function to the input argument, yielding an appropriate result.  A
 * function may variously provide a mapping between types, object instances or
 * keys and values or any other form of transformation upon the input.
 *
 * @param <T> the type of the input to the {@code apply} operation.
 * @param <R> the type of the result of the {@code apply} operation.
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Function<T, R> {

    /**
     * Compute the result of applying the function to the input argument
     *
     * @param t the input object
     * @return the function result
     */
    public R apply(T t);
}
