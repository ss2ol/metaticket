package com.metaticket.metaticket.repository;


import com.metaticket.metaticket.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
