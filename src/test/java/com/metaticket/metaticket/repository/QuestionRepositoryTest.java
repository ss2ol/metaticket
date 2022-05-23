package com.metaticket.metaticket.repository;

import com.metaticket.metaticket.domain.Question;
import com.metaticket.metaticket.repository.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

@SpringBootTest
@PropertySource("classpath:application.yml")
class QuestionRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    @DisplayName("문의사항 삽입 테스트1")
    public void InsertTest(){
        Question question = Question.builder().classify("테스트").build();
        Question temp = questionRepository.save(question);
        System.out.println(temp.toString());
    }

}