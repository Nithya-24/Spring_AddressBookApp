package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.Contact;

import java.util.List;

public interface IAddressBookService {
    List<Contact> getContact();

    void deleteContact(int contactId);

    Contact updateContact(int contactId, AddressBookDTO contactDTO);

    Contact createContact(AddressBookDTO contactDTO);

    Contact getContactById(int contactId);
    List<Contact> sortByCity();

    List<Contact> sortByState();
}
