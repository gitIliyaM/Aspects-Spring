package ru.t1.java.demo.service.PostParsing;

import ru.t1.java.demo.model.Transaction;

import java.util.List;

public interface PostParsingTransaction {
    List<Transaction> transactionList (String accountPost);
}
