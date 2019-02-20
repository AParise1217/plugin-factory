package com.parisesoftware.factory

import com.parisesoftware.factory.exceptions.ConstructionFailedException
import com.parisesoftware.factory.exceptions.IllegalImplementationException
import com.parisesoftware.factory.exceptions.NoImplementationException
import org.apache.commons.lang3.StringUtils

/**
 * <h1>Plugin Factory</h1>
 * <p>Generic Abstract Factory to handle creating instances based on a configured implementing class</p>
 *
 * @since   2.0.0
 * @version 2.0.0
 */
class PluginFactory {

    /**
     * Factory Method to handle creating {@code T} instances
     * @return {@code <T> T} Generic corresponding to param interfaceType
     */
    protected <T> T getPlugin(Class<T> interfaceType, String implClassName) {

        if (StringUtils.isEmpty(implClassName)) {
            throw new NoImplementationException("Implementation not specified for `${interfaceType.name}` in Application Context.")
        }

        try {
            Object newInstance = Class.forName(implClassName).newInstance()

            if (!(newInstance instanceof T)) {
                // if the constructed instance does not implement the expected interface
                throw new IllegalImplementationException("the Configured Implementation does not implement `${interfaceType.name}`")
            }

            return interfaceType.cast(newInstance)

        } catch(Exception ignored) {
            throw new ConstructionFailedException("the Plugin Factory is unable to construct an instance of `${interfaceType.name}`")
        }
    }

}
