package midterm.client.dto;

import ch.qos.logback.core.status.Status;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AccountDTO {

    Integer id;

    Integer userId;

    private StatusDTO status= StatusDTO.ACTIVE;

    private TypDTO typ;

    private BigDecimal balance;
}
