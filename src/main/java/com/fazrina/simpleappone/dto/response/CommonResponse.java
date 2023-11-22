package com.fazrina.simpleappone.dto.response;

public class CommonResponse<T> {
    private String message;
    private Integer statusCode;
    private T data;
}
