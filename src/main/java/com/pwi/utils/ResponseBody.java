package com.pwi.utils;

public class ResponseBody {

    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseBody(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Response [success=");
        builder.append(success);
        builder.append(", message=");
        builder.append(message);
        builder.append("]");
        return builder.toString();
    }


}
