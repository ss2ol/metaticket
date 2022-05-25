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
       Admin admin = adminRepository.findById(9L).get();

        Notice notice = Notice.builder().
                admin(admin).
                classify("테스트").
                title("테스트").
                content("테스트").
                build();

        Notice temp = noticeRepository.save(notice);
        System.out.println(temp.toString());
    }

    @Test
    @DisplayName("공지사항 수정 테스트")
    public void updateTest() throws Exception{

        Notice findNotice = noticeRepository.findById(2L).get();
        findNotice.update("테스트1","테스트2","테스트3");
        Notice updateNotice = noticeRepository.save(findNotice);

        assertEquals(updateNotice.getClassify(),"테스트1");
        assertEquals(updateNotice.getTitle(),"테스트2");
        assertEquals(updateNotice.getContent(), "테스트3");
    }
//
//    @Test
//    @DisplayName("공지사항 삭제 테스트")
//    public void deleteTest(){
//        Optional<Admin> admin = adminRepository.findById(6L);
//        Assert.assertTrue(admin.isPresent());
//
//        admin.ifPresent(selectAdmin->{
//            adminRepository.delete(selectAdmin);
//        });
//
//        Optional<Admin> deletedAdmin = adminRepository.findById(6L);
//
//        Assert.assertFalse(deletedAdmin.isPresent());
//
//    }
//
//
//    @Test
//    @DisplayName("공지사항 조회 테스트")
//    public void selectTest(){
//        Long id = 7L;
//        Optional<Admin> result = adminRepository.findById(id);
//
//        if(result.isPresent()){
//            Admin admin = result.get();
//            assertEquals(admin.getId(),7L);
//
//            System.out.println(admin.toString());
//        }
//
//    }

}

