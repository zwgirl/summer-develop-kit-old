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
 * A supplier of objects. The result objects are either created during the
 * invocation of {@link #get} or by some prior action.
 *
 * @param <T> The type of objects returned by {@code get}
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Returns an object.
     *
     * @return an object
     */
    public T get();
}
