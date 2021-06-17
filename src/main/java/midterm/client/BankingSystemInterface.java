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



    @GetMapping("/banking/savings_accounts/")
    @ResponseStatus(HttpStatus.OK)
    public List<SavingsAccountDTO> searchSavingsAccount(@RequestParam Optional<Integer> user);



    @GetMapping("/banking/credit_cards/")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCardDTO> searchCreditCard(@RequestParam Optional<Integer> user);




    @GetMapping("/banking/account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BalanceDTO searchBalance(@PathVariable Integer id);



    @PatchMapping("/banking/checking_account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CheckingAccountDTO modifyCheckingAccountBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO);


    @PatchMapping("/banking/savings_account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SavingsAccountDTO modifySavingsAccountBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO);


    @PatchMapping("/banking/credit_card_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreditCardDTO modifyCreditCardBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO);

    @PostMapping("/banking/account/new_checking_account/")
    @ResponseStatus(HttpStatus.CREATED)
    public CheckingAccountDTO createNewCheckingAccount(@RequestBody @Valid CheckingAccountDTO checkingAccountDTO);

    @PostMapping("/banking/account/new_savings_account/")
    @ResponseStatus(HttpStatus.CREATED)
    public SavingsAccountDTO createNewSavingsAccount(@RequestBody @Valid SavingsAccountDTO savingsAccountDTO);

    @PostMapping("/banking/account/new_credit_card/")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCardDTO createNewCreditCard(@RequestBody @Valid CreditCardDTO creditCardDTO);

    //User

    @GetMapping("/banking/user/")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> searchUser(@RequestParam Optional<Integer> user);

    @PostMapping("/banking/user/new_account_holder/")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolderDTO createNewCustomer(@RequestBody @Valid FirstPartyUserDTO firstPartyUserDTO);

    @PostMapping("/banking/user/new_admin/")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminDTO createNewAdmin(@RequestBody @Valid FirstPartyUserDTO firstPartyUserDTO);

    @PostMapping("/banking/user/new_third_party/")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdPartyDTO createNewThirdParty(@RequestBody @Valid ThirdPartyDTO thirdPartyDTO);
}
