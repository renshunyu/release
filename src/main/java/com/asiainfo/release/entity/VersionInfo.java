package com.asiainfo.release.entity;

public class VersionInfo {
    private long createTime;
    private int delFlag;
    private int downCount;
    private int isWhole;
    private int pageNum;
    private int pageSize;
    private String productDescription;
    private int productGroupId;
    private int  productId;
    private String productName;
    private String publishPeople;
    private long publishTime;
    private long updateTime;
    private String versionNum;

    public VersionInfo() {
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public int getDownCount() {
        return downCount;
    }

    public void setDownCount(int downCount) {
        this.downCount = downCount;
    }

    public int getIsWhole() {
        return isWhole;
    }

    public void setIsWhole(int isWhole) {
        this.isWhole = isWhole;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(int productGroupId) {
        this.productGroupId = productGroupId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPublishPeople() {
        return publishPeople;
    }

    public void setPublishPeople(String publishPeople) {
        this.publishPeople = publishPeople;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }

    @Override
    public String toString() {
        return "VersionInfo{" +
                "createTime=" + createTime +
                ", delFlag=" + delFlag +
                ", downCount=" + downCount +
                ", isWhole=" + isWhole +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", productDescription='" + productDescription + '\'' +
                ", productGroupId=" + productGroupId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", publishPeople='" + publishPeople + '\'' +
                ", publishTime=" + publishTime +
                ", updateTime=" + updateTime +
                ", versionNum='" + versionNum + '\'' +
                '}';
    }
}
