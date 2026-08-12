package com.contactApp.contactApp.service;

import com.contactApp.contactApp.DTO.ResponseDTO;
import com.contactApp.contactApp.entity.ContactApp;

public interface ContactAppInterface {
    public ResponseDTO add(ContactApp contactAppReq);

}
