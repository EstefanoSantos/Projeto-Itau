package com.example.desafioItau.service;

import com.example.desafioItau.entity.TransactionEntity;
import com.example.desafioItau.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Transactional(rollbackOn = Exception.class)
    public void fazerTransacao(TransactionEntity transacao) {

        transactionRepository.save(transacao);

    }

    public DoubleSummaryStatistics calculateTransactionsStatistics() {
        List<TransactionEntity> transacoes = transactionRepository.findAll();

        return transacoes.stream()
                .mapToDouble(TransactionEntity::getValor)
                .summaryStatistics();
    }

    public TransactionEntity getTransactionById(Long id){
        return transactionRepository.getReferenceById(id);
    }

    public List<TransactionEntity> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public void deleteAllTransactions() {
        transactionRepository.deleteAll();
    }
}
