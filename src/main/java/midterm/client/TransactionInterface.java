package midterm.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="transactionclient")
public interface TransactionInterface {
}
