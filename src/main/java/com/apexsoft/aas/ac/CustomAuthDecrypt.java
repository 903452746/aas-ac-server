package com.apexsoft.aas.ac;

import com.apexsoft.aas.ac.core.strategy.AuthDecryptStrategy;
import com.apexsoft.aas.common.exception.AuthException;
import com.apexsoft.aas.modules.index.model.AuthData;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Custom auth decrypt strategy for receive request from client.
 * Should use {@link Primary} to override default strategy.
 * @see com.apexsoft.aas.ac.core.SimpleAuthDecrypt
 * @author linqz
 * @date 10/16/2018
 */
//@Component
//@Primary
public class CustomAuthDecrypt implements AuthDecryptStrategy {

    /**
     * AuthData already contains clientId and ext params. user can
     * Obtain them with method {@code Get} help for decrypt
     * Return should fill back authData's { user & password & timestamp}
     *
     * @param authData
     * @param signature signature of request
     * @param secret client secret
     * @throws AuthException
     */
    @Override
    public void decrypt(AuthData authData, String signature, String secret) throws AuthException {

    }
}
