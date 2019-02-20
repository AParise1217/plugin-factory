package com.parisesoftware.factory.exceptions

import spock.lang.Specification

class ConstructionFailedExceptionTest extends Specification {

    def "ConstructionFailedException should be of type RuntimeException"() {

        when: 'a new ConstructionFailedException is instantiated'
        ConstructionFailedException testException = new ConstructionFailedException('blah')

        then: 'then the ConstructionFailedException instance is of type RuntimeException'
        testException instanceof RuntimeException
    }

}
