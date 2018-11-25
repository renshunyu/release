package com.asiainfo.release;

import com.asiainfo.release.base.ProductVersion;
import com.asiainfo.release.base.UploadFile;
import com.asiainfo.release.config.IConfig;
import com.asiainfo.release.entity.*;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class Issue {
    private static Logger logger = Logger.getLogger(Issue.class);

    public static void main(String[] args) throws IOException {
        if (!IConfig.setConfig(args)) {
            exit(1);
        }


        Gson gs = new Gson();
        //创建新版本并获取新版本的id
        boolean b = ProductVersion.newVersion(IConfig.getInstance().getByKey("versionNum"));
        if (false == b) {
            logger.error("创建版本错误！");
            exit(1);
        }
        int productVersionId = ProductVersion.getVersionId(IConfig.getInstance().getByKey("versionNum"));
        //获取描述信息

        File file;
        File[] files;
        String objectStr;


        //扫描安装包目录上传安装包并记录
        file = new File(new String(IConfig.getInstance().getByKey("packagepath").getBytes("iso-8859-1"), "UTF-8"));
        files = file.listFiles();

        List<InstallPackInfo> installPackInfos = new ArrayList<InstallPackInfo>();
        for (File tf : files) {
            if (tf.isFile()) {
                List<InstallPackAreasInfo> installPackAreasInfos = new ArrayList<InstallPackAreasInfo>();
                //上传文件
                UploadFileResponse uploadFileResponse = UploadFile.upload(tf, IConfig.getInstance().getByKey("installPackInfoPath"));
                logger.info(uploadFileResponse.getPath());
                //System.out.println(tf.getAbsolutePath());
                installPackAreasInfos.add(new InstallPackAreasInfo(tf.getName(), URLDecoder.decode(uploadFileResponse.getPath(), "UTF-8"), new String(IConfig.getInstance().getByKey("installVersion").getBytes("iso-8859-1"), "UTF-8")));
                installPackInfos.add(new InstallPackInfo(tf.getName(), tf.getAbsolutePath(), installPackAreasInfos));
            }
        }
        //添加安装包信息
        if (installPackInfos.size() > 0) {
            InstallPackReq installPackReq = new InstallPackReq(productVersionId, installPackInfos);
            objectStr = gs.toJson(installPackReq);
            System.out.println(objectStr);
            UploadFile.addInfo(IConfig.getInstance().getByKey("addInstallPackUrl"), objectStr);
        }


        //扫描db变更目录上传安装包并记录
        file = new File(new String(IConfig.getInstance().getByKey("dbpath").getBytes("iso-8859-1"), "UTF-8"));
        files = file.listFiles();

        List<ChangeDescriptionInfo> changeDescriptionInfos = new ArrayList<ChangeDescriptionInfo>();
        for (File tf : files) {
            if (tf.isFile()) {
                UploadFileResponse uploadFileResponse = UploadFile.upload(tf, IConfig.getInstance().getByKey("changeDescriptionInfoPath"));
                changeDescriptionInfos.add(new ChangeDescriptionInfo(tf.getName(), URLDecoder.decode(uploadFileResponse.getPath(), "UTF-8"), tf.getAbsolutePath()));
            }
        }
        if (changeDescriptionInfos.size() > 0) {
            ChangeDescriptionReq changeDescriptionReq = new ChangeDescriptionReq(productVersionId, changeDescriptionInfos);
            objectStr = gs.toJson(changeDescriptionReq);
            logger.info(objectStr);
            UploadFile.addInfo(IConfig.getInstance().getByKey("addChangeDescriptionUrl"), objectStr);
        }


        //扫描文档目录目录上传安装包并记录
        file = new File(new String(IConfig.getInstance().getByKey("docpath").getBytes("iso-8859-1"), "UTF-8"));
        files = file.listFiles();

        List<ManualInfo> manualInfos = new ArrayList<ManualInfo>();
        for (File tf : files) {
            if (tf.isFile()) {
                UploadFileResponse uploadFileResponse = UploadFile.upload(tf, IConfig.getInstance().getByKey("manualInfoPath"));
                manualInfos.add(new ManualInfo(tf.getName(), URLDecoder.decode(uploadFileResponse.getPath(), "UTF-8"), tf.getAbsolutePath()));
            }
        }
        if (manualInfos.size() > 0) {
            ManualReq manualReq = new ManualReq(productVersionId, manualInfos);
            objectStr = gs.toJson(manualReq);
            logger.info(objectStr);
            UploadFile.addInfo(IConfig.getInstance().getByKey("addManualUrl"), objectStr);
        }

    }
}
