package ru.t1.java.demo.service.jsonParser;

import ru.t1.java.demo.dto.TransactionDTO;
import ru.t1.java.demo.model.Transaction;

import java.util.List;

public interface JsonParsingTransaction {
    TransactionDTO[] arrayTransactionDTO();
    List<Transaction> arrayaListTransaction();
}
