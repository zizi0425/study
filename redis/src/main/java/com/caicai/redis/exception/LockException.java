package com.caicai.redis.exception;

import lombok.Getter;

@Getter
public class LockException extends RuntimeException {

    public static Integer LOCK_ERROR = 10001;

    private Integer code;

    public LockException() {
        super();
    }
    public LockException(String message) {
        this(message, LOCK_ERROR);
    }

    public LockException(String message, Integer code) {
        super(message);
        this.code = code;
    }

}
