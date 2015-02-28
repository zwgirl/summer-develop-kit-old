/*
 * Copyright (c) 1997, 2006, Oracle and/or its affiliates. All rights reserved.
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
 * Thrown to indicate that the requested operation is not supported.<p>
 *
 * This class is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author  Josh Bloch
 * @since   1.2
 */
public class UnsupportedOperationException extends RuntimeException {
    /**
     * Constructs an UnsupportedOperationException with no detail message.
     */
    public UnsupportedOperationException() {
    }

    /**
     * Constructs an UnsupportedOperationException with the specified
     * detail message.
     *
     * @param message the detail message
     */
    public UnsupportedOperationException(String message) {
        super(message);
    }

    static final long serialVersionUID = -1242599979055084673L;
}
