package com.softserve.web.dto;

public class ResponceDto {
    private String message;
    private Object data;

    public ResponceDto(String message) {
        this.message = message;
        data = null;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponceDto{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
