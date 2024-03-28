package com.example.desafioItau.service;

import com.example.desafioItau.entity.TransactionEntity;
import com.example.desafioItau.exceptions.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.DoubleSummaryStatistics;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private int idGenerator = 0;
    @Autowired
    TransactionEntity transaction;
    List<TransactionEntity> transactions = new ArrayList<>();


    public List<TransactionEntity> getAllTransactions() {
        return transactions;
    }

    public void fazerTransacao(TransactionEntity transacao) {
        try {
            if (transacao != null && transacao.getValor() >= 0) {
                TransactionEntity novaTransacao = new TransactionEntity();
                novaTransacao.setId(idGenerator++);
                novaTransacao.setValor(transacao.getValor());
                novaTransacao.setTimeStamp(transacao.getTimeStamp());
                transactions.add(novaTransacao);

            } else {
                throw new TransactionException("O valor da transação dever ser maior que zero");
            }

        } catch (TransactionException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public DoubleSummaryStatistics calculateTransactionsStatistics() {
        return transactions.stream()
                .mapToDouble(TransactionEntity::getValor)
                .summaryStatistics();
    }

    public TransactionEntity getTransactionById(int id){
        for(TransactionEntity transactionEntity : transactions) {
            if (transaction.getId() == id) {
                return transaction;
            }
        }
        return null;
    }

    public void deleteAllTransactions() {
        transactions.clear();
    }
}
