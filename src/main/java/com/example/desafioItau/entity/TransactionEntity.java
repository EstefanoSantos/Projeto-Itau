package com.example.desafioItau.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@Component
public class TransactionEntity {

    private int id;
    private double valor;
    private LocalDateTime timeStamp;

    public TransactionEntity() {
        this.timeStamp = LocalDateTime.now();
    }
}
