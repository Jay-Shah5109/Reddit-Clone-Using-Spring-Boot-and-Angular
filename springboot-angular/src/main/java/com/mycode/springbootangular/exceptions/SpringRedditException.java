package com.mycode.springbootangular.exceptions;

import org.springframework.mail.MailException;

public class SpringRedditException extends RuntimeException {
    public SpringRedditException(String s, MailException e) {
        super(e);
    }
    public SpringRedditException(String exMessage) {
        super(exMessage);
    }
}
