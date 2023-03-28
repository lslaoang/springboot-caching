package com.cache.springbootcaching.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookModel {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String title;
}
