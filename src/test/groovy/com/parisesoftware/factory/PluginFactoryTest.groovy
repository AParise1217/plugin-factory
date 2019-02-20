package com.parisesoftware.factory

import com.parisesoftware.factory.exceptions.ConstructionFailedException
import com.parisesoftware.factory.exceptions.NoImplementationException
import spock.lang.Specification

class PluginFactoryTest extends Specification {

    def "getPlugin(): should throw NoImplementationException when `implClassName` is null"() {

        given: 'an `implClassName` value of `null`'
        String testImplClassName = null

        and: 'a new PluginFactory is created with the implClassName value'
        PluginFactory testFactory = new PluginFactory()

        when: 'getPlugin() is invoked on the PluginFactory'
        testFactory.getPlugin(String.class, testImplClassName)

        then: 'NoImplementationException is thrown'
        thrown(NoImplementationException)
    }

    def "getPlugin(): should throw NoImplementationException when `implClassName` is an empty String"() {

        given: 'an `implClassName` value of \'\''
        String testImplClassName = ''

        and: 'a new PluginFactory is created with the implClassName value'
        PluginFactory testFactory = new PluginFactory()

        when: 'getPlugin() is invoked on the PluginFactory'
        testFactory.getPlugin(String.class, testImplClassName)

        then: 'NoImplementationException is thrown'
        thrown(NoImplementationException)
    }

    def '''getPlugin(): should throw ConstructionFailedException when `implClassName` refers to a class
                        that does not implement IAmAFakeObjectProvider'''() {

        given: 'an `implClassName` value of a class that does not implement IAmAFakeObjectProvider'
        String testImplClassName = 'com.pennmutual.common.factory.TestClassNotIAmAFakeObjectProviderImplementation'

        and: 'a new PluginFactory'
        PluginFactory testFactory = new PluginFactory()

        when: 'getPlugin() is invoked on the PluginFactory'
        testFactory.getPlugin(IAmAFakeObjectProvider.class, testImplClassName)

        then: 'ConstructionFailedException is thrown'
        thrown(ConstructionFailedException)
    }

    def '''getPlugin(): should throw ConstructionFailedException when `implClassName` refers to a class
                        that does not exist'''() {

        given: 'an `implClassName` value of a class that does not exist'
        String testImplClassName = 'I.Really.Should.Not.Exist'

        and: 'a new PluginFactory is created'
        PluginFactory testFactory = new PluginFactory()

        when: 'getPlugin() is invoked on the PluginFactory'
        testFactory.getPlugin(IAmAFakeObjectProvider.class, testImplClassName)

        then: 'ConstructionFailedException is thrown'
        thrown(ConstructionFailedException)
    }

    def '''getPlugin(): should return a new, constructed instance `implClassName` refers to a class
                        that does exists and implements IAmAFakeObjectProvider'''() {

        given: 'an `implClassName` value of a class that exists, has a valid constructor, and implements IAmAFakeObjectProvider'
        String testImplClassName = 'com.parisesoftware.factory.TestFakeObjectProvider'

        and: 'a new PluginFactory is created'
        PluginFactory testFactory = new PluginFactory()

        when: 'getPlugin() is invoked on the PluginFactory'
        IAmAFakeObjectProvider resultant = testFactory.getPlugin(IAmAFakeObjectProvider.class, testImplClassName)

        then: 'no exceptions are thrown'
        noExceptionThrown()

        and: 'the resultant is not null'
        resultant != null

        and: 'the resultant is of type IAmAFakeObjectProvider'
        resultant instanceof IAmAFakeObjectProvider
    }

}

/**
 * Test Implementation to pull back an instance of something that isn't a IAmAFakeObjectProvider
 */
@SuppressWarnings("unused")
class TestClassNotIAmAFakeObjectImplementation {}

interface IAmAFakeObjectProvider {
    @SuppressWarnings("unused")
    String getFakeString(String key)
}

@SuppressWarnings("unused")
class TestFakeObjectProvider implements IAmAFakeObjectProvider {

    @Override
    String getFakeString(String key) {
        return key
    }
}
