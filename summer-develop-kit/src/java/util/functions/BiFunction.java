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
 * Apply a function to the input arguments, yielding an appropriate result. This
 * is the two-arity specialization of {@link Function}. A function may
 * variously provide a mapping between types, object instances or keys and
 * values or any other form of transformation upon the input.
 *
 * @param <T> the type of the first argument to the {@code apply} operation.
 * @param <U> the type of the second argument to the {@code apply} operation.
 * @param <R> the type of results returned by the {@code apply} operation.
 *
 * @see Function
 * @since 1.8
 */
@FunctionalInterface
public interface BiFunction<T, U, R> {

    /**
     * Compute the result of applying the function to the input arguments
     *
     * @param t an input object
     * @param u an input object
     * @return the function result
     */
    R apply(T t, U u);
}
