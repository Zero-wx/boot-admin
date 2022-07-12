package com.zero.serverApi.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String getUserInfo(String account);
}
