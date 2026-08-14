package com.contactApp.contactApp.controller;

import java.util.List;

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

    private final ContactAppService contactAppService;

    public ContactAppController(ContactAppService contactAppService) {
        this.contactAppService = contactAppService;
    }

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

    @GetMapping("/all")
    public ResponseEntity<List<ResponseDTO>> getAll() {
        return ResponseEntity.ok(contactAppService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(contactAppService.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable int id, @RequestBody RequestDTO req) {
        ContactApp contact = ContactApp.builder()
                .name(req.getName())
                .email(req.getEmail())
                .mobNo(req.getMobNo())
                .build();

        return ResponseEntity.ok(contactAppService.update(id, contact));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        contactAppService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
