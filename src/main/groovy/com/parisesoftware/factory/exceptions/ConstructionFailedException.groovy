package com.parisesoftware.factory.exceptions

/**
 * {@inheritDoc}
 *
 * Exception thrown when a Factory is unable to construct an instance of an object
 *
 * @since   2.0.0
 * @version 2.0.0
 */
class ConstructionFailedException extends RuntimeException {

    ConstructionFailedException(String message) {
        super(message)
    }

}
