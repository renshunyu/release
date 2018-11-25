package com.asiainfo.release.entity;

import java.util.Date;
import java.util.List;

public class InstallPackReq {

    /**
     * id
     */
    private Integer productId;


    /**
     * 安装包列表
     */
    private List<InstallPackInfo> installPackInfoList;

    public InstallPackReq(Integer productId, List<InstallPackInfo> installPackInfoList) {
        this.productId = productId;
        this.installPackInfoList = installPackInfoList;
    }

    public InstallPackReq() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }



    public List<InstallPackInfo> getInstallPackInfoList() {
        return installPackInfoList;
    }

    public void setInstallPackInfoList(List<InstallPackInfo> installPackInfoList) {
        this.installPackInfoList = installPackInfoList;
    }


    @Override
    public String toString() {
        return "InstallPackReq [productId=" + productId +", installPackInfoList=" + installPackInfoList
                + "]";
    }
}
