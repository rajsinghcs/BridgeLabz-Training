package com.contactApp.contactApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.contactApp.contactApp.DTO.ResponseDTO;
import com.contactApp.contactApp.entity.ContactApp;
import com.contactApp.contactApp.repository.ContactAppRepository;

@Service
public class ContactAppService implements ContactAppInterface {

    private final ContactAppRepository contactAppRepository;

    public ContactAppService(ContactAppRepository contactAppRepository) {
        this.contactAppRepository = contactAppRepository;
    }

    @Override
    public ResponseDTO add(ContactApp contactAppReq) {
        ContactApp cont = contactAppRepository.save(contactAppReq);
        return mapToResponse(cont);
    }

    @Override
    public List<ResponseDTO> getAll() {
        return contactAppRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDTO getById(int id) {
        return contactAppRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found with id " + id));
    }

    @Override
    public ResponseDTO update(int id, ContactApp contactAppReq) {
        ContactApp existing = contactAppRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found with id " + id));

        existing.setName(contactAppReq.getName());
        existing.setEmail(contactAppReq.getEmail());
        existing.setMobNo(contactAppReq.getMobNo());

        return mapToResponse(contactAppRepository.save(existing));
    }

    @Override
    public void delete(int id) {
        ContactApp existing = contactAppRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found with id " + id));
        contactAppRepository.delete(existing);
    }

    private ResponseDTO mapToResponse(ContactApp contactApp) {
        return ResponseDTO.builder()
                .id(contactApp.getId())
                .name(contactApp.getName())
                .email(contactApp.getEmail())
                .mobNo(contactApp.getMobNo())
                .build();
    }
}
