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

    public Integer getId() {
        return id;
    }

    public AccountDTO() {
    }

    public AccountDTO(Integer id, Integer userId, StatusDTO status, TypDTO typ, BigDecimal balance) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.typ = typ;
        this.balance = balance;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public TypDTO getTyp() {
        return typ;
    }

    public void setTyp(TypDTO typ) {
        this.typ = typ;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
