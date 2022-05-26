package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AddressBookService implements IAddressBookService {
    @Override
    public List<Contact> getContact() {
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact(1,
                new AddressBookDTO("Nithya", "Ram", "Satchiyapuram", "TN", "Sivakasi", "626130", "7894561230")));
        System.out.println(contactList.toString());

        return contactList;
    }

    @Override
    public Contact getContactById(int contactId) {
        Contact contact = new Contact(1,
                new AddressBookDTO("Jonalyn", "J", "Persai", "Karnataka", "Bangalore", "526130", "9876543210"));
        return contact;
    }

    @Override
    public Contact createContact(AddressBookDTO contactDTO) {
        Contact contact = new Contact(1, contactDTO);
        return contact;
    }

    @Override
    public Contact updateContact(int contactId, AddressBookDTO contactDTO) {
        Contact contact = new Contact(1, contactDTO);
        return contact;
    }

    @Override
    public void deleteContact(int contactId) {
        // TODO Auto-generated method stub

    }
}