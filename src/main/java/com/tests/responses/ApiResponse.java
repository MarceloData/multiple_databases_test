package com.tests.responses;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private T data;
    private Integer count;

    public ApiResponse() {
    }

    public ApiResponse(T data) {
        this.data = data;
        if (data instanceof Collection<?> coll) {
            this.count = coll.size();
        }
    }
}
