package com.example.desafioItau.controller;

import com.example.desafioItau.entity.TransactionEntity;
import com.example.desafioItau.exceptions.TransactionException;
import com.example.desafioItau.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void makeTransaction(@RequestBody @Validated TransactionEntity transactionEntity) {
        try {
            transactionService.fazerTransacao(transactionEntity);
        } catch (TransactionException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteTransactions() {
        transactionService.deleteAllTransactions();
    }

    @GetMapping
    public List<TransactionEntity> getAllTransactions() {
        return transactionService.getAllTransactions();
    }


}
