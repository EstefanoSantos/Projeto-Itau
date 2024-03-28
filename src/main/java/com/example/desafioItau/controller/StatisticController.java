package com.example.desafioItau.controller;

import com.example.desafioItau.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class StatisticController {

    @Autowired
    TransactionService transactionService;

    @GetMapping
    public DoubleSummaryStatistics getTransactionsStatistics() {
        return transactionService.calculateTransactionsStatistics();
    }


}
