package com.cache.springbootcaching.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Book {

    @Id
    private Long id;
    private String title;
}
