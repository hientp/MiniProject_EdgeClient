package midterm.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="bankingclient")
public interface BankingSystemInterface {
}
