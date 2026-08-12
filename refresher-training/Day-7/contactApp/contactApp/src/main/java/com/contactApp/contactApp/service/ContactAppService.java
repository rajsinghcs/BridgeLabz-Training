package com.contactApp.contactApp.service;

import com.contactApp.contactApp.DTO.ResponseDTO;
import com.contactApp.contactApp.entity.ContactApp;
import com.contactApp.contactApp.repository.ContactAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactAppService implements ContactAppInterface{

    @Autowired
    private final ContactAppRepository contactAppRepository;

    public ContactAppService(ContactAppRepository contactAppRepository) {
        this.contactAppRepository = contactAppRepository;
    }

    @Override
    public ResponseDTO add(ContactApp contactAppReq){
        ContactApp cont=contactAppRepository.save(contactAppReq);
        ResponseDTO res= ResponseDTO.builder().name(cont.getName()).id(cont.getId()).mail(cont.getEmail()).mobNo(cont.getMobNo()).build();
        return res;

    }

}
