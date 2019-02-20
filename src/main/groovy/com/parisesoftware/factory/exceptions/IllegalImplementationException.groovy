package com.parisesoftware.factory.exceptions

/**
 * {@inheritDoc}
 *
 * Exception thrown when the configured implementation does not implement the proper interface
 *
 * @since   2.0.0
 * @version 2.0.0
 */
class IllegalImplementationException extends ClassCastException {

    IllegalImplementationException(String message) {
        super(message)
    }

}
