package com.metaticket.metaticket.repository;

import com.metaticket.metaticket.domain.Admin;
import com.metaticket.metaticket.domain.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@PropertySource("classpath:application.yml")
class AdminRepositoryTest {

    @Autowired
    AdminRepository adminRepository;

    @Test
    @DisplayName("관리자 삽입 테스트1")
    public void InsertTest(){
        Admin admin = Admin.builder().
                password("테스트").
                build();
        Admin temp = adminRepository.save(admin);
        System.out.println(temp.toString());
    }



}