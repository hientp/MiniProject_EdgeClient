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
    @GetMapping("/minibanking/checking_accounts/")
    @ResponseStatus(HttpStatus.OK)
    public List<CheckingAccountDTO> searchCheckingAccount(@RequestParam Optional<Integer> user) {
       return bankingSystemInterface.searchCheckingAccount(user);
    }

    @GetMapping("/minibanking/savings_accounts/")
    @ResponseStatus(HttpStatus.OK)
    public List<SavingsAccountDTO> searchSavingsAccount(@RequestParam Optional<Integer> user) {
        return bankingSystemInterface.searchSavingsAccount(user);
    }

    @GetMapping("/minibanking/credit_cards/")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCardDTO> searchCreditCard(@RequestParam Optional<Integer> user) {
       return bankingSystemInterface.searchCreditCard(user);
    }

    @GetMapping("/minibanking/account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BalanceDTO searchBalance(@PathVariable Integer id) {
        return bankingSystemInterface.searchBalance(id);
    }


    @PatchMapping("/minibanking/checking_account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CheckingAccountDTO modifyCheckingAccountBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO)  {
        return bankingSystemInterface.modifyCheckingAccountBalance(id,balanceDTO);
    }


    @PatchMapping("/minibanking/savings_account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SavingsAccountDTO modifySavingsAccountBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO)  {
        return bankingSystemInterface.modifySavingsAccountBalance(id,balanceDTO);
    }

    @PatchMapping("/minibanking/credit_card_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreditCardDTO modifyCreditCardBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO)  {
        return bankingSystemInterface.modifyCreditCardBalance(id,balanceDTO);
    }

    @PostMapping("/minibanking/account/new_checking_account/")
    @ResponseStatus(HttpStatus.CREATED)
    public CheckingAccountDTO createNewCheckingAccount(@RequestBody @Valid CheckingAccountDTO checkingAccountDTO) {
        return bankingSystemInterface.createNewCheckingAccount(checkingAccountDTO);
    }

    @PostMapping("/minibanking/account/new_savings_account/")
    @ResponseStatus(HttpStatus.CREATED)
    public SavingsAccountDTO createNewSavingsAccount(@RequestBody @Valid SavingsAccountDTO savingsAccountDTO) {
        return bankingSystemInterface.createNewSavingsAccount(savingsAccountDTO);
    }

    @PostMapping("/minibanking/account/new_credit_card/")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCardDTO createNewCreditCard(@RequestBody @Valid CreditCardDTO creditCardDTO) {
        return bankingSystemInterface.createNewCreditCard(creditCardDTO);
    }

    @GetMapping("/minibanking/user/")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> searchUser(@RequestParam Optional<Integer> user) {
        return bankingSystemInterface.searchUser(user);
    }

    @PostMapping("/minibanking/user/new_account_holder/")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolderDTO createNewCustomer(@RequestBody @Valid FirstPartyUserDTO firstPartyUserDTO) {
        return bankingSystemInterface.createNewCustomer(firstPartyUserDTO);
    }

    @PostMapping("/minibanking/user/new_admin/")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminDTO createNewAdmin(@RequestBody @Valid FirstPartyUserDTO firstPartyUserDTO) {
        return bankingSystemInterface.createNewAdmin(firstPartyUserDTO);
    }

    @PostMapping("/minibanking/user/new_third_party/")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdPartyDTO createNewThirdParty(@RequestBody @Valid ThirdPartyDTO thirdPartyDTO) {
        return bankingSystemInterface.createNewThirdParty(thirdPartyDTO);
    }

    @GetMapping("/minibanking/transactions/getaccount/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AccountDTO> getTransactionAccount(@RequestParam Integer id) {
        return transactionInterface.getTransactionAccount(id);
    }

    @PostMapping("/minibanking/transactions/postaccount/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AccountDTO> postTransactionAccount(@RequestParam Integer id,@RequestBody AccountDTO accountDTO) {
        return transactionInterface.postTransactionAccount(id, accountDTO);
    }

    @PatchMapping("/minibanking/transactions_account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO modifyAccountBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO) {
        return transactionInterface.modifyAccountBalance(id, balanceDTO);
    }
}
