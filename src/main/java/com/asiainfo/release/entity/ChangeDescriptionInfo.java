package com.asiainfo.release.entity;

public class ChangeDescriptionInfo {
    private String changeDescriptionName;
    private String downUrl;
    private String remarks;

    public ChangeDescriptionInfo(String changeDescriptionName, String downUrl, String remarks) {
        this.changeDescriptionName = changeDescriptionName;
        this.downUrl = downUrl;
        this.remarks = remarks;
    }


    public String getChangeDescriptionName() {
        return changeDescriptionName;
    }

    public void setChangeDescriptionName(String changeDescriptionName) {
        this.changeDescriptionName = changeDescriptionName;
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
        return "ChangeDescriptionInfo{" +
                "changeDescriptionName='" + changeDescriptionName + '\'' +
                ", downUrl='" + downUrl + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
