/*
 * Copyright (c) 1994, 2012, Oracle and/or its affiliates. All rights reserved.
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

package java.lang;

/**
 * Thrown to indicate that a method has been passed an illegal or
 * inappropriate argument.
 *
 * @author  unascribed
 * @since   JDK1.0
 */
public
class IllegalArgumentException extends RuntimeException {
    /**
     * Constructs an <code>IllegalArgumentException</code> with no
     * detail message.
     */
    public IllegalArgumentException() {
        super();
    }

    /**
     * Constructs an <code>IllegalArgumentException</code> with the
     * specified detail message.
     *
     * @param   s   the detail message.
     */
    public IllegalArgumentException(String s) {
        super(s);
    }

    private static final long serialVersionUID = -5365630128856068164L;
}
