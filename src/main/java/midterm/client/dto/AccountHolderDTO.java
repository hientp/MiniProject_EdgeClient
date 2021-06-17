package midterm.client.dto;

import java.util.Date;

public class AccountHolderDTO {

    private String name;
    private Date birthDay;
    private AddressDTO address;

    public AccountHolderDTO() {

    }

    public AccountHolderDTO(String name, Date birthDay, AddressDTO address) {
        this.name = name;
        this.birthDay = birthDay;
        this.address=address;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public AddressDTO getAddresses() {
        return address;
    }

    public void setAddresses(AddressDTO address) {
        this.address = address;
    }

}
