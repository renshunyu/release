package com.asiainfo.release.entity;

public class UploadFileResponse {
    private int code;
    private String msg;
    private String path;

    public UploadFileResponse(int code, String msg, String path) {
        this.code = code;
        this.msg = msg;
        this.path = path;
    }

    public UploadFileResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "UploadFileResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
