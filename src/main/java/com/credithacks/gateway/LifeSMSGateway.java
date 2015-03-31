package com.credithacks.gateway;

import com.credithacks.exception.SendSMSException;

import javax.enterprise.inject.Default;

/**
 * Created by roman_b on 12/19/2014.
 */
@Default
public class LifeSMSGateway implements SMSGateway {
    @Override
    public String send(String phone, String msg) throws SendSMSException {
        return null;
    }
}
