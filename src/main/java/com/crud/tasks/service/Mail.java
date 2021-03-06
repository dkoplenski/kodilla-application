package com.crud.tasks.service;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Mail {
    private String mailTo;
    private String toCc;
    private String subject;
    private String message;

}
