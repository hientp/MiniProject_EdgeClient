package midterm.client;

import midterm.client.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ServiceInstanceRestController {

    @Autowired
    BankingSystemInterface bankingSystemInterface;

    @Autowired
    TransactionInterface transactionInterface;

    //Transaction
    @PostMapping("/minibanking/transferMoney/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TransactionDTO> transferMoney(@RequestBody @Valid TransactionDTO transactionDTO) {
        return transactionInterface.transferMoney(transactionDTO);
    }


    //Accounts
    @GetMapping("/banking/checking_accounts/")
    @ResponseStatus(HttpStatus.OK)
    public List<CheckingAccountDTO> searchCheckingAccount(@RequestParam Optional<Integer> user) {
        if(user.isPresent()) {
            FirstPartyUserDTO primaryOwner = (FirstPartyUserDTO) bankingSystemInterface.findById(user.get()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
            return bankingSystemInterface.findCheckingAccountByPrimaryOwner(primaryOwner);
        } else {
            return bankingSystemInterface.findAllCheckingAccounts();
        }
    }

    @GetMapping("/banking/savings_accounts/")
    @ResponseStatus(HttpStatus.OK)
    public List<SavingsAccountDTO> searchSavingsAccount(@RequestParam Optional<Integer> user) {
        if(user.isPresent()) {
            FirstPartyUserDTO primaryOwner = (FirstPartyUserDTO) bankingSystemInterface.findById(user.get()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
            return bankingSystemInterface.findSavingsAccountByPrimaryOwner(primaryOwner);
        } else {
            return bankingSystemInterface.findAllSavingsAccounts();
        }
    }

    @GetMapping("/banking/credit_cards/")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCardDTO> searchCreditCard(@RequestParam Optional<Integer> user) {
        if(user.isPresent()) {
            FirstPartyUserDTO primaryOwner = (FirstPartyUserDTO) bankingSystemInterface.findById(user.get()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
            return bankingSystemInterface.findCreditCardByPrimaryOwner(primaryOwner);
        } else {
            return bankingSystemInterface.findAllCreditCards();
        }
    }

    @GetMapping("/banking/account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BalanceDTO searchBalance(@PathVariable Integer id) {
        return new BalanceDTO(bankingSystemInterface.findBalanceOfAccount(id));
    }


    @PatchMapping("/banking/checking_account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CheckingAccountDTO modifyCheckingAccountBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO)  {
        return bankingSystemInterface.modifyCheckingAccountBalance(id,balanceDTO);
    }


    @PatchMapping("/banking/savings_account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SavingsAccountDTO modifySavingsAccountBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO)  {
        return bankingSystemInterface.modifySavingsAccountBalance(id,balanceDTO);
    }

    @PatchMapping("/banking/credit_card_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreditCardDTO modifyCreditCardBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO)  {
        return bankingSystemInterface.modifyCreditCardBalance(id,balanceDTO);
    }


}
