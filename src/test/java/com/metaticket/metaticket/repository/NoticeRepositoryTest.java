package com.metaticket.metaticket.repository;

import com.metaticket.metaticket.domain.Admin;
import com.metaticket.metaticket.domain.Notice;
import com.metaticket.metaticket.domain.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@PropertySource("classpath:application.yml")
class NoticeRepositoryTest {

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Test
    @DisplayName("공시사항 삽입 테스트1")
    public void InsertTest(){
        Admin admin = adminRepository.findById(1L).get();

        Notice notice = Notice.builder().
                admin(admin).
                classify("테스트").
                title("테스트").
                content("테스트").
                build();

        Notice temp = noticeRepository.save(notice);
        System.out.println(temp.toString());
    }


}