package com.metaticket.metaticket.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Question")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQl 자동으로 키본키 생성
    private Long ques_id;

    @Column(name = "classify")
    private String classify;

}
