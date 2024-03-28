package com.example.desafioItau.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@Component
@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valor;
    private LocalDateTime timeStamp;

    public TransactionEntity() {
        this.timeStamp = LocalDateTime.now();
    }
}
