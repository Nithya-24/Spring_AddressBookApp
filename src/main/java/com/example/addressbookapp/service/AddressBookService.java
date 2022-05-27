package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.exception.AddressBookException;
import com.example.addressbookapp.model.Contact;
import com.example.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    private AddressBookRepository addressBookRepository;
    List<Contact> contactList = new ArrayList<>();
    @Override
    public List<Contact> getContact() {

        return addressBookRepository.findAll();
    }
    @Override
    public Contact getContactById(int contactId) {
        return addressBookRepository.findById(contactId)
                .orElseThrow(() -> new AddressBookException("Addressbook with ContactId" + contactId
                        + " Doesn't Exists"));
    }

    @Override
    public Contact createContact(AddressBookDTO contactDTO) {

        Contact contactData = new Contact(contactList.size()+1, contactDTO);
        contactList.add(contactData);
        return addressBookRepository.save(contactData);

    }

    @Override
    public Contact updateContact(int contactId, AddressBookDTO contactDTO) {
        Contact contact = this.getContactById(contactId);
        contact.updateContact(contactDTO);
        return addressBookRepository.save(contact);
    }

    @Override
    public void deleteContact(int contactId) {
        Contact contact = this.getContactById(contactId);
        addressBookRepository.delete(contact);

    }
}