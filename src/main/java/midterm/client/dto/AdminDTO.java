package midterm.client.dto;

import java.util.Date;

public class AdminDTO {

    private String name;
    private Date birthDay;
    private AddressDTO address;

    public AdminDTO() {

    }

    public AdminDTO(String name, Date birthDay, AddressDTO address) {
        this.name = name;
        this.birthDay = birthDay;
        this.address=address;
    }
}
