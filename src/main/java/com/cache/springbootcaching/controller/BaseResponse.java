package com.cache.springbootcaching.controller;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse implements Serializable {
    String status;
    String message;
}
