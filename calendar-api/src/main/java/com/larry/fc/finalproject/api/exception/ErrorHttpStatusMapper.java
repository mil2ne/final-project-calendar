package com.larry.fc.finalproject.api.exception;

import com.larry.fc.finalproject.core.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public abstract class ErrorHttpStatusMapper {

    public static HttpStatus mapToStatus(ErrorCode errorCode) {
        switch (errorCode) {
            case ALREADY_EXIST_USER:
            case VALIDATION_FAIL:
            case BAD_REQUEST:
            case EVENT_CREATE_OVERLAPPED_PERIOD:
                return HttpStatus.BAD_REQUEST;
            case USER_NOT_FOUND:
            case PASSWORD_NOT_MATCH:
                return HttpStatus.UNAUTHORIZED;
            default:
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
