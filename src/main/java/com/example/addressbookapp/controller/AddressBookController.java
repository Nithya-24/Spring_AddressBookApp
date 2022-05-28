package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.model.Contact;
import com.example.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @Autowired
    private IAddressBookService addressbookservice;

    @GetMapping("/get" )
    public ResponseEntity<ResponseDTO> getContactData() {

        List<Contact> contactList = addressbookservice.getContact();
        System.out.println(contactList.toString());
        ResponseDTO response = new ResponseDTO("Get call success", contactList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDTO> getContactData(@PathVariable("contactId") int contactId) {

        Contact contact = addressbookservice.getContactById(contactId);
        ResponseDTO response = new ResponseDTO("Get call success for id", contact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContactData( @Valid @RequestBody AddressBookDTO contactDTO) {
        Contact contact = addressbookservice.createContact(contactDTO);
        ResponseDTO response = new ResponseDTO("Created contact data for", contact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping("/sortbycity")
    public ResponseEntity<ResponseDTO> sortByCity() {
        List<Contact> contactList = null;
        contactList = addressbookservice.sortByCity();
        ResponseDTO response = new ResponseDTO("Get Call  is Successful Sort By City: ", contactList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
    @GetMapping("/sortbystate")
    public ResponseEntity<ResponseDTO> sortByState() {
        List<Contact> contactList = null;
        contactList = addressbookservice.sortByState();
        ResponseDTO response = new ResponseDTO("Get Call  is Successful Sort By City: ", contactList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("contactId") int contactId,
                                                         @Valid @RequestBody AddressBookDTO contactDTO) {
        Contact contact = addressbookservice.updateContact(contactId, contactDTO);
        ResponseDTO response = new ResponseDTO("Updated contact data for", contact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("contactId") int contactId) {
        addressbookservice.deleteContact(contactId);
        ResponseDTO response = new ResponseDTO("Delete call success for id ", "deleted id:" + contactId);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }


}