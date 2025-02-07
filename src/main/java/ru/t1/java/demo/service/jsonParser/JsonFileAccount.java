package ru.t1.java.demo.service.jsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import ru.t1.java.demo.dto.AccountDTO;
import ru.t1.java.demo.model.Account;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class JsonFileAccount implements JsonParsingAccount {
    private final File file = new File("src/main/resources/account.json");

    @Override
    public AccountDTO[] arrayAccountDTO()  {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(file, AccountDTO[].class);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Account> arrayaListAccount()  {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Account.class));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
