package com.example.addressbookapp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public @Data class AddressBookDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "First name is Invalid ")
    @NotEmpty(message = "first name cannot be null")
    public String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-z\\s]{2,}$", message = "Last name is Invalid ")
    @NotEmpty(message = "last name cannot be null")
    public String lastName;
    @Pattern(regexp = "^[A-Za-z,.0-9\\s]{3,}$", message = "Address is Invalid ")
    @NotEmpty(message = "Address cannot be null")
    public String address;
    @Pattern(regexp = "^[A-Za-z,.0-9\\s]{2,}$", message = "State is Invalid")
    @NotEmpty(message = "State cannot be null")
    public String state;
    @Pattern(regexp = "^[A-Za-z,.0-9]{3,}$", message = "City is Invalid")
    @NotEmpty(message = "City cannot be null")
    public String city;
    @Pattern(regexp = "^[0-9]{3}\\s{0,1}[0-9]{3}$")
    public String zip;
    @Pattern(regexp = "^^[0-9]{2}?[\\s,-]{0,1}[7-9]{1}[0-9]{9}$",message = "Phone number is Invalid")
    public String phone;

    @Pattern(regexp = "^[a-zA-Z0-9]+([0-9A-Za-z]+)@[a-zA-Z0-9]+.[a-zA-Z]{2,4}([.][a-z]{2,4})?$",message = "email is invalid")
    @NotEmpty(message = "Email id cannot be null")
    public String email;


    public AddressBookDTO(String firstName, String lastName, String address, String state, String city, String zip,
                      String phone,String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.email=email;
    }


}