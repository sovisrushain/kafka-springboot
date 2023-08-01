package com.rechargeservice.controller;

import com.rechargeservice.dto.Pkg;
import com.rechargeservice.service.RechargeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    @PostMapping
    public String packageRecharge(@Valid @RequestBody Pkg pkg, Errors errors) {
        if(errors.hasErrors()) {
            return Objects.requireNonNull(errors.getFieldError()).getDefaultMessage();
        }
        System.out.println(pkg.getAmount());
        return rechargeService.packageRecharge(pkg);
    }

}
