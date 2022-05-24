package com.metaticket.metaticket.repository;

import com.metaticket.metaticket.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  QuestionRepository extends JpaRepository<Question, Long> {

}
