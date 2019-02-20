package com.parisesoftware.factory.exceptions

/**
 * {@inheritDoc}
 *
 * Exception thrown when there is no Implementation for the Requested Interface
 *
 * @since   2.0.0
 * @version 2.0.0
 */
class NoImplementationException extends RuntimeException {

    NoImplementationException(String message) {
        super(message)
    }

}
