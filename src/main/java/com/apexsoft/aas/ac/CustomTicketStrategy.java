package com.apexsoft.aas.ac;

import com.apexsoft.aas.ac.core.strategy.TicketStrategy;
import com.apexsoft.aas.modules.index.model.AuthData;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Custom ac ticket generator
 * Should use {@link Primary} to override default strategy.
 * @see com.apexsoft.aas.ac.core.SimpleTicket
 * @author linqz
 * @date 10/16/2018
 */
//@Component
//@Primary
public class CustomTicketStrategy implements TicketStrategy {
    @Override
    public String generateTicket(AuthData authData) {
        return UUID.randomUUID().toString();
    }
}
