package com.bluesoft.vetclinicsystem.entities.common;

import java.io.Serializable;

public class DefaultResponse implements Serializable {

    private Integer statusCode;

    private String message;

    public DefaultResponse() {
    }

    public DefaultResponse(String message) {
        this.message = message;
    }

    public DefaultResponse(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
