package com.yangqiang.tuku.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonResult {

    private static String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss.SSS";

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    private int status;

    private String message;

    private Object result;

    private String timestamp;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public CommonResult() {}

    public CommonResult(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.timestamp = LocalDateTime.now().format(dateTimeFormatter);
    }

}
