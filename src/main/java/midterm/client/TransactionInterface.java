package midterm.client;

import midterm.client.dto.TransactionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@FeignClient(name="transactionclient")
public interface TransactionInterface {



    @PostMapping("/banking/transferMoney/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TransactionDTO> transferMoney(@RequestBody @Valid TransactionDTO transactionDTO);
}
