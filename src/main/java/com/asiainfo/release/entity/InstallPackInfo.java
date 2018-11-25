package com.asiainfo.release.entity;

import java.util.List;

public class InstallPackInfo {


    private String installPackName;

    private String changeDescription;


    private List<InstallPackAreasInfo> installPackAreasInfoList;

    public InstallPackInfo(String installPackName, String changeDescription, List<InstallPackAreasInfo> installPackAreasInfoList) {
        this.installPackName = installPackName;
        this.changeDescription = changeDescription;
        this.installPackAreasInfoList = installPackAreasInfoList;
    }

    public InstallPackInfo() {}

    public String getChangeDescription() {
        return changeDescription;
    }

    public void setChangeDescription(String changeDescription) {
        this.changeDescription = changeDescription;
    }




    public List<InstallPackAreasInfo> getInstallPackAreasInfoList() {
        return installPackAreasInfoList;
    }

    public void setInstallPackAreasInfoList(List<InstallPackAreasInfo> installPackAreasInfoList) {
        this.installPackAreasInfoList = installPackAreasInfoList;
    }

    public String getInstallPackName() {
        return installPackName;
    }

    public void setInstallPackName(String installPackName) {
        this.installPackName = installPackName;
    }


    @Override
    public String toString() {
        return "InstallPackInfo{" +
                ", installPackName='" + installPackName + '\'' +
                ", changeDescription='" + changeDescription + '\'' +
                ", installPackAreasInfoList=" + installPackAreasInfoList +
                '}';
    }
}
