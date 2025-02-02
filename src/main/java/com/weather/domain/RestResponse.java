package com.weather.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestResponse<T> {
    private Integer code;
    private T response;
    private String status;
    private Error error;
}
