package com.asiainfo.release.entity;

public class FixPackInfo {
    private String fixPackName;
    private String fixDescription;
    private String downUrl;
    private String remarks;

    public FixPackInfo(String fixPackName, String fixDescription, String downUrl, String remarks) {
        this.fixPackName = fixPackName;
        this.fixDescription = fixDescription;
        this.downUrl = downUrl;
        this.remarks = remarks;
    }

    public String getFixPackName() {
        return fixPackName;
    }

    public void setFixPackName(String fixPackName) {
        this.fixPackName = fixPackName;
    }

    public String getFixDescription() {
        return fixDescription;
    }

    public void setFixDescription(String fixDescription) {
        this.fixDescription = fixDescription;
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
        return "FixPackInfo{" +
                "fixPackName='" + fixPackName + '\'' +
                ", fixDescription='" + fixDescription + '\'' +
                ", downUrl='" + downUrl + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
