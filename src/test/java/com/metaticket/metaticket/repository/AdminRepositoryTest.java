package com.metaticket.metaticket.repository;

import com.metaticket.metaticket.domain.Admin;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@PropertySource("classpath:application.yml")
class AdminRepositoryTest {

    @Autowired
    AdminRepository adminRepository;

    @Test
    @DisplayName("관리자 삽입 테스트1")
    public void insertTest(){
        Admin admin = Admin.builder().
                password("테스트").
                build();
        Admin temp = adminRepository.save(admin);
        System.out.println(temp.toString());
    }

    @Test
    @DisplayName("관리자 수정 테스트")
    public void updateTest() throws Exception{

        Admin findAdmin = adminRepository.findById(1L).get();

        findAdmin.update("12345");
        Admin updatedAdmin = adminRepository.save(findAdmin);

        assertEquals(updatedAdmin.getPassword(), "12345");

        System.out.println(updatedAdmin.toString());
    }

    @Test
    @DisplayName("관리자 삭제 테스트")
    public void deleteTest(){
        Optional<Admin> admin = adminRepository.findById(1L);
        Assert.assertTrue(admin.isPresent());

        admin.ifPresent(selectAdmin->{
            adminRepository.delete(selectAdmin);
        });

        Optional<Admin> deletedAdmin = adminRepository.findById(1L);

        Assert.assertFalse(deletedAdmin.isPresent());

        System.out.println(deletedAdmin.toString());
    }


    @Test
    @DisplayName("관리자 조회 테스트")
    public void selectTest(){
        Long id = 2L;
        Optional<Admin> result = adminRepository.findById(id);

        if(result.isPresent()){
            Admin admin = result.get();
            assertEquals(admin.getId(),2L);

            System.out.println(admin.toString());
        }

    }

}