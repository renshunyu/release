package com.asiainfo.release.entity;

public class CreateVersionInfo {

    private int isWhole;
    private String productName;
    private String versionNum;
    private String productDescription;

    public CreateVersionInfo(int isWhole, String productName, String versionNum, String productDescription) {
        this.isWhole = isWhole;
        this.productName = productName;
        this.versionNum = versionNum;
        this.productDescription = productDescription;
    }

    public CreateVersionInfo() {
    }

    public int getIsWhole() {
        return isWhole;
    }

    public void setIsWhole(int isWhole) {
        this.isWhole = isWhole;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "CreateVersionInfo{" +
                "isWhole=" + isWhole +
                ", productName='" + productName + '\'' +
                ", versionNum='" + versionNum + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
