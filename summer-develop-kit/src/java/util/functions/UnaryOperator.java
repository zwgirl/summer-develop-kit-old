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
 * An operation upon a single operand yielding a result. The operand and the
 * result are of the same type. This is a specialization of {@code Function} for
 * the case where the operand and result are of the same type.
 *
 * @param <T> the type of operand to {@code apply} and of the result
 *
 * @see Function
 * @since 1.8
 */
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {
}
