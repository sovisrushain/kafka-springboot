package com.smsservice.service;

import com.smsservice.dto.Pkg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements MsgService {

    private static final Logger logger = LoggerFactory.getLogger(MsgServiceImpl.class);

    @Override
    public void sendMsg(Pkg pkg) {
        // send the msg -msg service
        logger.info("Your account {} have been recharged of {}", pkg.getNumber(), pkg.getAmount());
    }
}
