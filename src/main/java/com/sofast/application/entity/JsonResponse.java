package com.sofast.application.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/*
 *
 * @author fjiang
 * @description 
 * @date 7/7/16
 */
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
public class JsonResponse<T> {

    private int status;
    private String errorMsg;
    private String redirectUrl;
    private T data;

    public JsonResponse() {

    }

    @JsonCreator
    public JsonResponse(@JsonProperty("data") T t) {
        this.status = 200;
        this.data = t;
    }

}
