package com.contactApp.contactApp.service;

import java.util.List;

import com.contactApp.contactApp.DTO.ResponseDTO;
import com.contactApp.contactApp.entity.ContactApp;

public interface ContactAppInterface {
    ResponseDTO add(ContactApp contactAppReq);
    List<ResponseDTO> getAll();
    ResponseDTO getById(int id);
    ResponseDTO update(int id, ContactApp contactAppReq);
    void delete(int id);
}
