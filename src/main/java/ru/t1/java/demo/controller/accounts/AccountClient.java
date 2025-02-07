package ru.t1.java.demo.controller.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.java.demo.dto.AccountDTO;
import ru.t1.java.demo.dto.TransactionDTO;
import ru.t1.java.demo.model.Account;
import ru.t1.java.demo.model.Transaction;
import ru.t1.java.demo.service.DataProcessorService;

import java.util.List;

@RestController
@RequestMapping("/ra")
public class AccountClient {

    private final DataProcessorService dataProcessorService;

    @Autowired
    public AccountClient(DataProcessorService dataProcessorService){
        this.dataProcessorService = dataProcessorService;

    }
    @GetMapping("/ga")
    public ResponseEntity<List<AccountDTO>> getAccountDTO()  {
        return new ResponseEntity<>(dataProcessorService.createAccountDTOFromFile(), HttpStatus.OK);
    }
    @GetMapping("/gtx")
    public ResponseEntity<List<TransactionDTO>> getTransactionDTO() {
        return new ResponseEntity<>(dataProcessorService.createTransactionDTOFromFile(), HttpStatus.OK);
    }
    @GetMapping("gf")
    public ResponseEntity<List<Account>> createAccountFromFile()  {
        List<Account> accountList = dataProcessorService.createAccountFromFile();
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }
    @GetMapping("gftx")
    public ResponseEntity<List<Transaction>> createTransactionFromFile()  {
        List<Transaction> transactionList = dataProcessorService.createTransactionFromFile();
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }
    @PostMapping("/pa")
    public ResponseEntity<List<Account>> postAccountList(@RequestBody String account)  {
        List<Account> accountList = dataProcessorService.createAccountPost(account);
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }
    @PostMapping("/ptx")
    public ResponseEntity<List<Transaction>> postTransactionList(@RequestBody String transaction) {
        List<Transaction> transactionList = dataProcessorService.createTransactionPost(transaction);
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }


}
