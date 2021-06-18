package midterm.client;

import midterm.client.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.awt.*;
import java.math.BigDecimal;
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
    public TransactionDTO transferMoney(@RequestBody @Valid TransactionDTO transactionDTO) {
        TransactionDTO transactionDTO1 = transactionInterface.transferMoney(transactionDTO);
//        BigDecimal amount = transactionDTO1.getAmount();
//        Integer receiverAccountId = transactionDTO.getReceiverAccountId();
//        Integer senderAccountId = transactionDTO.getSenderAccountId();
//        List<CheckingAccountDTO> checkingDTOList = bankingSystemInterface.searchCheckingAccount(Optional.empty());
//        for(int x = 0; x < checkingDTOList.size(); x++){
//            if(checkingDTOList.get(x).getId() == senderAccountId){
//                CheckingAccountDTO senderAccount = checkingDTOList.get(x);
//                BigDecimal balance = senderAccount.getBalance();
//                balance = balance.subtract(amount);
//                BalanceDTO balanceDTO = new BalanceDTO(balance);
//                bankingSystemInterface.modifyCheckingAccountBalance(senderAccountId, balanceDTO);
//            }
//        }
//        for(int x = 0; x < checkingDTOList.size(); x++){
//            if(checkingDTOList.get(x).getId() == receiverAccountId){
//                CheckingAccountDTO receiverAccount = checkingDTOList.get(x);
//                BigDecimal balance = receiverAccount.getBalance();
//                balance = balance.add(amount);
//                BalanceDTO balanceDTO = new BalanceDTO(balance);
//                bankingSystemInterface.modifyCheckingAccountBalance(receiverAccountId, balanceDTO);
//            }
//        }

        return transactionDTO1;
    }


    //Accounts
    @RequestMapping(value = "/minibanking/checking_accounts/", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseStatus(HttpStatus.OK)
    public List<CheckingAccountDTO> searchCheckingAccount(@RequestBody Optional<Integer> user) {

        return bankingSystemInterface.searchCheckingAccount(user);
    }


    @RequestMapping(value = "/minibanking/savings_accounts/", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseStatus(HttpStatus.OK)
    public List<SavingsAccountDTO> searchSavingsAccount(@RequestBody Optional<Integer> user) {
        return bankingSystemInterface.searchSavingsAccount(user);
    }

    @RequestMapping(value = "/minibanking/credit_cards/", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCardDTO> searchCreditCard(@RequestBody Optional<Integer> user) {
       return bankingSystemInterface.searchCreditCard(user);
    }

    @RequestMapping(value = "/minibanking/account_balance/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseStatus(HttpStatus.OK)
    public BalanceDTO searchBalance(@PathVariable Integer id) {
        return bankingSystemInterface.searchBalance(id);
    }


    @PutMapping("/minibanking/checking_account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CheckingAccountDTO modifyCheckingAccountBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO)  {
        return bankingSystemInterface.modifyCheckingAccountBalance(id,balanceDTO);
    }


    @PutMapping("/minibanking/savings_account_balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SavingsAccountDTO modifySavingsAccountBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO)  {
        return bankingSystemInterface.modifySavingsAccountBalance(id,balanceDTO);
    }

    @PutMapping("/minibanking/credit_card_balance/{id}")
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

    @RequestMapping(value = "/minibanking/user/", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> searchUser(@RequestBody Optional<Integer> user) {
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
    public AccountDTO getTransactionAccount(@PathVariable Integer id) {
        return transactionInterface.getTransactionAccount(id);
    }

    @PostMapping("/minibanking/transactions/postaccount/")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDTO postTransactionAccount(@RequestParam Integer id,@RequestBody AccountDTO accountDTO) {
        return transactionInterface.postTransactionAccount(id, accountDTO);
    }

    @RequestMapping( value = "/minibanking/transactions_account_balance/{id}", method = {RequestMethod.PUT, RequestMethod.POST})
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO modifyAccountBalance(@PathVariable Integer id, @RequestBody @Valid BalanceDTO balanceDTO) {
        return transactionInterface.modifyAccountBalance(id, balanceDTO);
    }
}
