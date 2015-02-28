/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * An operation which accepts two input arguments and returns no result. This is
 * the two-arity specialization of {@link Consumer}. Unlike most other
 * functional interfaces, {@code BiConsumer} is expected to operate via
 * side-effects.
 *
 * @param <T> the type of the first argument to the {@code accept} operation.
 * @param <U> the type of the second argument to the {@code accept} operation.
 *
 * @see Consumer
 * @since 1.8
 */
@FunctionalInterface
public interface BiConsumer<T, U> {

    /**
     * Performs operations upon the provided objects which may modify those
     * objects and/or external state.
     *
     * @param t an input object
     * @param u an input object
     */
    void accept(T t, U u);
}
