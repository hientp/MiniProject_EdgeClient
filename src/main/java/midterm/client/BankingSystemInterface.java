package midterm.client;

import midterm.client.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@FeignClient(name="bankingclient")
public interface BankingSystemInterface {

    //Accounts
    @GetMapping("/banking/checking_accounts/")
    @ResponseStatus(HttpStatus.OK)
    public List<CheckingAccountDTO> searchCheckingAccount(@RequestParam Optional<Integer> user);

    List<CheckingAccountDTO> findCheckingAccountByPrimaryOwner(FirstPartyUserDTO primaryOwner);

    List<CheckingAccountDTO> findAllCheckingAccounts();

    Optional<Object> findById(Integer integer);


    @GetMapping("/banking/savings_accounts/")
    @ResponseStatus(HttpStatus.OK)
    public List<SavingsAccountDTO> searchSavingsAccount(@RequestParam Optional<Integer> user);

    List<SavingsAccountDTO> findSavingsAccountByPrimaryOwner(FirstPartyUserDTO primaryOwner);

    List<SavingsAccountDTO> findAllSavingsAccounts();


    @GetMapping("/banking/credit_cards/")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCardDTO> searchCreditCard(@RequestParam Optional<Integer> user);

    List<CreditCardDTO> findCreditCardByPrimaryOwner(FirstPartyUserDTO primaryOwner);

    List<CreditCardDTO> findAllCreditCards();


    @GetMapping("/banking/account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BalanceDTO searchBalance(@PathVariable Integer id);

    BigDecimal findBalanceOfAccount(Integer id);


    @PatchMapping("/banking/checking_account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CheckingAccountDTO modifyCheckingAccountBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO);


    @PatchMapping("/banking/savings_account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SavingsAccountDTO modifySavingsAccountBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO);


    @PatchMapping("/banking/credit_card_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreditCardDTO modifyCreditCardBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO);
}
