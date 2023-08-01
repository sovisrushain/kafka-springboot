package com.rechargeservice.controller;

import com.rechargeservice.dto.Pkg;
import com.rechargeservice.service.RechargeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recharge")
@RequiredArgsConstructor
public class RechargeController {

    private final RechargeService rechargeService;

    @PostMapping
    public String packageRecharge(@RequestBody Pkg pkg) {
        System.out.println(pkg.getAmount());
        return rechargeService.packageRecharge(pkg);
    }

}
