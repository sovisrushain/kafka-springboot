package com.rechargeservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rechargeservice.dto.Pkg;
import com.rechargeservice.util.Producer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RechargeServiceImpl implements RechargeService {

    private final Producer producer;

    private static final Logger logger = LoggerFactory.getLogger(RechargeServiceImpl.class);

    @Override
    public String packageRecharge(Pkg pkg) {
        // recharge package - business logic
        try {
            return producer.sendMessage(pkg);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            return "FAILED!";
        }
    }
}
