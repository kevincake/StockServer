package com.ifreedom.beauty.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifreedom.beauty.bean.HttpResult;
import com.ifreedom.beauty.constants.HttpConstants;
import com.ifreedom.beauty.entity.UserEntity;
import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SignTest {
    private RestTemplate template = new TestRestTemplate();

    @Test
    public void testSignIn() {
        String url = "http://localhost:8080/sign/signIn?phone={phone}&password={password}";
        UserEntity userEntity = new UserEntity();
        userEntity.setPhone("18311362506");
        userEntity.setPassword("123456");
        ObjectMapper mapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        UserEntity forObject = template.getForObject(url, UserEntity.class, userEntity.getPhone(), userEntity.getPassword());
        System.out.println(forObject.toString());
    }

    @Test
    public void testSignUp() {
        String url = "http://localhost:8080/sign/signUp";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("email", "first.last@example.com");
        params.add(HttpConstants.NAME, "testSignUp");
        params.add(HttpConstants.PASSWORD, 111111 + "");
        params.add(HttpConstants.AVATAR, "avatar");
        params.add(HttpConstants.PHONE, "18311362506");
        params.add(HttpConstants.SEX, 1 + "");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        String result = template.postForObject(url, request, String.class);

    }

    @Test
    public void testIsPhoneRegister() {
        String url = "http://localhost:8080/sign/isPhoneRegister?phone={phone}";
        UserEntity userEntity = new UserEntity();
        userEntity.setPhone("18311362505");
        ObjectMapper mapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        HttpResult forObject = template.getForObject(url, HttpResult.class, userEntity.getPhone());
        System.out.println(forObject.toString());
    }


    @Test
    public void testVerifyCode() {
        String url = "http://localhost:8080/sign/getVerifyCode?phone={phone}";
        HttpResult forObject = template.getForObject(url, HttpResult.class, "18311362505");
        System.out.println(forObject.toString());
    }



}
