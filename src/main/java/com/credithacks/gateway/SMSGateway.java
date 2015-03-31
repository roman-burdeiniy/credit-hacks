package com.credithacks.gateway;

import com.credithacks.exception.SendSMSException;

/**
 * Created by roman_b on 12/19/2014.
 */
public interface SMSGateway {
    String send(String phone, String msg) throws SendSMSException;
}
