package com.contactApp.contactApp.controller;


import com.contactApp.contactApp.DTO.RequestDTO;
import com.contactApp.contactApp.DTO.ResponseDTO;
import com.contactApp.contactApp.entity.ContactApp;
import com.contactApp.contactApp.service.ContactAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contactApp")
public class ContactAppController {

    @Autowired
    private final ContactAppService contactAppService;

    public ContactAppController(ContactAppService contactAppService) {
        this.contactAppService = contactAppService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@RequestBody RequestDTO req){

        ContactApp contact=ContactApp.builder().name(req.getName()).email(req.getEmail()).mobNo(req.getMobNo()).build();
         ResponseDTO ans=contactAppService.add(contact);

         return  ResponseEntity
                 .status(HttpStatus.CREATED)
                 .body(ans);


    }
}
