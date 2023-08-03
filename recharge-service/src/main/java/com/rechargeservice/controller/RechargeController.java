package com.rechargeservice.controller;

import com.rechargeservice.dto.Pkg;
import com.rechargeservice.service.RechargeService;
import com.rechargeservice.service.RechargeServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/recharge")
@RequiredArgsConstructor
public class RechargeController {

    private final RechargeService rechargeService;

    private static final Logger logger = LoggerFactory.getLogger(RechargeController.class);

    @PostMapping
    public String packageRecharge(@Valid @RequestBody Pkg pkg, Errors errors) {
        if(errors.hasErrors()) {
            String errorMsg = Objects.requireNonNull(errors.getFieldError()).getDefaultMessage();
            logger.error(errorMsg);
            return errorMsg;
        }
        return rechargeService.packageRecharge(pkg);
    }

}
