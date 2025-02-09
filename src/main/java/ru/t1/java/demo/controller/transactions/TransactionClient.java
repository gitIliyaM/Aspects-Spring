package ru.t1.java.demo.controller.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.java.demo.dto.TransactionDTO;
import ru.t1.java.demo.model.Account;
import ru.t1.java.demo.service.DataProcessorService;

import java.util.List;

@RestController
@RequestMapping("/rt")
public class TransactionClient {
    private final DataProcessorService dataProcessorService;

    @Autowired
    TransactionClient(DataProcessorService dataProcessorService){
        this.dataProcessorService = dataProcessorService;
    }

    @GetMapping("/gt")
    private ResponseEntity<List<TransactionDTO>> getTransaction() {
        return new ResponseEntity<>(dataProcessorService.createTransactionDTOFromFile(), HttpStatus.OK);
    }
    @PostMapping("/pt")
    private ResponseEntity<Account> postTransaction(@RequestBody Account account) {

        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
