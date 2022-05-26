package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.model.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @RequestMapping("/get" )
    public ResponseEntity<ResponseDTO> getContactData() {

        Contact contact = new Contact(1,
                new AddressBookDTO("Nithya", "Ram", "satchiyapuram", "TN", "VNR", "626130", "7894561230"));
        ResponseDTO response = new ResponseDTO("Get call success", contact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDTO> getContactData(@PathVariable("contactId") int contactId) {

        Contact contact=null;
        contact=new Contact(2,new AddressBookDTO("Jonalyn", "Joel", "Perur", "Karnataka", "Bangalore", "516723", "4561237890"));
        ResponseDTO response = new ResponseDTO("Get call success for id", contact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContactData(@RequestBody AddressBookDTO contactDTO) {
        Contact contact = new Contact(1, contactDTO);
        ResponseDTO response = new ResponseDTO("Created contact data for", contact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("contactId") int contactId,
                                                         @RequestBody AddressBookDTO contactDTO) {
        Contact contact = new Contact(1, contactDTO);
        ResponseDTO response = new ResponseDTO("Updated contact data for", contact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("contactId") int contactId) {
        ResponseDTO response = new ResponseDTO("Delete call success for id ", "deleted id:" + contactId);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

}