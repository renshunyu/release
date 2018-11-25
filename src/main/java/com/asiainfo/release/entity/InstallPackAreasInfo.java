package com.asiainfo.release.entity;

public class InstallPackAreasInfo {

    private String areaFileName;

    private String downUrl;

    private String areaNames;

    public InstallPackAreasInfo(String areaFileName, String downUrl, String areaNames) {
        this.areaFileName = areaFileName;
        this.downUrl = downUrl;
        this.areaNames = areaNames;
    }

    public InstallPackAreasInfo() {}



    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }



    public String getAreaNames() {
        return areaNames;
    }

    public void setAreaNames(String areaNames) {
        this.areaNames = areaNames;
    }

    public String getAreaFileName() {
        return areaFileName;
    }

    public void setAreaFileName(String areaFileName) {
        this.areaFileName = areaFileName;
    }

    @Override
    public String toString() {
        return "InstallPackAreasInfo{" +
                ", areaFileName='" + areaFileName + '\'' +
                ", downUrl='" + downUrl + '\'' +
                ", areaNames='" + areaNames + '\'' +
                '}';
    }
}
