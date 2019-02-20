package com.parisesoftware.factory.exceptions

import spock.lang.Specification

class IllegalImplementationExceptionTest extends Specification {

    def "IllegalImplementationException should be of type ClassCastException"() {

        when: 'a new IllegalImplementationException is instantiated'
        IllegalImplementationException testException = new IllegalImplementationException('blah')

        then: 'then the IllegalImplementationException instance is of type ClassCastException'
        testException instanceof ClassCastException
    }

}
