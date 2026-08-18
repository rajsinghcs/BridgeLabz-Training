package com.contactApp.contactApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactApp.contactApp.DTO.RequestDTO;
import com.contactApp.contactApp.DTO.ResponseDTO;
import com.contactApp.contactApp.entity.ContactApp;
import com.contactApp.contactApp.service.ContactAppService;

@RestController
@RequestMapping("/contactApp")
public class ContactAppController {

    @Autowired
    private final ContactAppService contactAppService;

    public ContactAppController(ContactAppService contactAppService) {
        this.contactAppService = contactAppService;
    }

    @GetMapping
    public ResponseEntity<String> welcomeMessage() {
        return ResponseEntity.ok("Welcome to Contact App");
    }

//    @PostMapping("/create")
//    public ResponseEntity<ResponseDTO> create(@RequestBody RequestDTO req){
//        ContactApp added=ContactApp.builder().name(req.getName()).email(req.getEmail()).mobNo(req.getMobNo()).build();
//        ResponseDTO ans=contactAppService.add(added);
//        return ResponseEntity.status(HttpStatus.CREATED).body(ans);
//    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@RequestBody RequestDTO req) {
        ContactApp contact = ContactApp.builder()
                .name(req.getName())
                .email(req.getEmail())
                .mobNo(req.getMobNo())
                .build();
        ResponseDTO ans = contactAppService.add(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(ans);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ResponseDTO>> getAll() {
        return ResponseEntity.ok(contactAppService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(contactAppService.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable int id, @RequestBody RequestDTO req) {
        return ResponseEntity.ok(contactAppService.update(id, req));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        contactAppService.delete(id);
        return ResponseEntity.ok("Contact deleted successfully with id: " + id);
    }
}