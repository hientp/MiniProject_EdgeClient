package midterm.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceInstanceRestController {

    @Autowired
    BankingSystemInterface bankingSystemInterface;

    @Autowired
    TransactionInterface transactionInterface;
}
