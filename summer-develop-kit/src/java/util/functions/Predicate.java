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
 * Determines if the input object matches some criteria.
 *
 * @param <T> the type of argument to {@code test}
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Predicate<T> {

    /**
     * Returns {@code true} if the input object matches some criteria.
     *
     * @param t the input object
     * @return {@code true} if the input object matches some criteria, otherwise
     * {@code false}
     */
    public boolean test(T t);

    /**
     * Returns a predicate which evaluates to {@code true} only if this
     * predicate and the provided predicate both evaluate to {@code true}. If
     * this predicate returns {@code false} then the remaining predicate is not
     * evaluated.
     *
     * @param p a predicate which will be logically-ANDed with this predicate.
     * @return a new predicate which returns {@code true} only if both
     * predicates return {@code true}.
     */
    public default Predicate<T> and(Predicate<? super T> p) {
        return (t) -> test(t) && p.test(t);
    }

//    /**
//     * Returns a predicate which negates the result of this predicate.
//     *
//     * @return a new predicate who's result is always the opposite of this
//     * predicate.
//     */
//    public default Predicate<T> negate() {
//        return (t) -> !test(t);
//    }
//
//    /**
//     * Returns a predicate which evaluates to {@code true} if either this
//     * predicate or the provided predicate evaluates to {@code true}. If this
//     * predicate returns {@code true} then the remaining predicate is not
//     * evaluated.
//     *
//     * @param p a predicate which will be logically-ORed with this predicate.
//     * @return a new predicate which returns {@code true} if either predicate
//     * returns {@code true}.
//     */
//    public default Predicate<T> or(Predicate<? super T> p) {
//        return (t) -> test(t) || p.test(t);
//    }
//
//    /**
//     * Returns a predicate that evaluates to {@code true} if both or neither of
//     * the component predicates evaluate to {@code true}.
//     *
//     * @param p a predicate which will be logically-XORed with this predicte.
//     * @return a predicate that evaluates to {@code true} if both or neither of
//     * the component predicates evaluate to {@code true}.
//     */
//    public default Predicate<T> xor(Predicate<? super T> p) {
//        return (t) -> test(t) ^ p.test(t);
//    }
}
