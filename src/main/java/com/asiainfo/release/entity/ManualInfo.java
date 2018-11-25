package com.asiainfo.release.entity;

public class ManualInfo {
    private String userManualName;
    private String downUrl;
    private String remarks;

    public ManualInfo(String userManualName, String downUrl, String remarks) {
        this.userManualName = userManualName;
        this.downUrl = downUrl;
        this.remarks = remarks;
    }

    public String getUserManualName() {
        return userManualName;
    }

    public void setUserManualName(String userManualName) {
        this.userManualName = userManualName;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "ManualInfo{" +
                "userManualName='" + userManualName + '\'' +
                ", downUrl='" + downUrl + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
