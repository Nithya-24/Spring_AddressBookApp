package com.example.addressbookapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AddressBookAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(AddressBookAppApplication.class, args);
        System.out.println("Welcome to AddressBook App");
        log.info("AddressBookApp started");
    }

}
