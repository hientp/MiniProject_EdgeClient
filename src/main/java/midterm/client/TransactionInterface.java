package midterm.client;

import midterm.client.dto.AccountDTO;
import midterm.client.dto.BalanceDTO;
import midterm.client.dto.TransactionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient(name="transactionclient")
public interface TransactionInterface {


    @PostMapping("/banking/transferMoney/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TransactionDTO> transferMoney(@RequestBody @Valid TransactionDTO transactionDTO);

    @GetMapping("/banking/transactions/getaccount/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AccountDTO> getTransactionAccount(@RequestParam Integer id);

    @PostMapping("/banking/transactions/postaccount/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AccountDTO> postTransactionAccount(@RequestParam Integer id,@RequestBody AccountDTO accountDTO);

    @PatchMapping("/banking/transactions_account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO modifyAccountBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO);
}
