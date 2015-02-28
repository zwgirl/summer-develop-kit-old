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
 * An operation which accepts a single input argument and returns no result.
 * Unlike most other functional interfaces, {@code Consumer} is expected to
 * operate via side-effects.
 *
 * @param <T> The type of input objects to {@code accept}
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Consumer<T> {

    /**
     * Accept an input value.
     *
     * @param t the input object
     */
    public void accept(T t);
}
