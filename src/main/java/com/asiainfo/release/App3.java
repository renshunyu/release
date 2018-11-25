package com.asiainfo.release;

import com.asiainfo.release.config.IConfig;
import com.asiainfo.release.entity.InstallPackAreasInfo;
import com.asiainfo.release.entity.UploadFileResponse;
import com.asiainfo.release.entity.InstallPackInfo;
import com.asiainfo.release.entity.InstallPackReq;
import com.asiainfo.release.session.ProductReleasePlatform;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App3 {
    private static List<File> f=new ArrayList<File>();
    public static void main(String[] args) throws IOException {

        List<InstallPackInfo> installPackInfos = new ArrayList<InstallPackInfo>();
        Gson gs = new Gson();

        File file = new File(new String(IConfig.getInstance().getByKey("packagepath").getBytes("iso-8859-1"),"UTF-8"));
        for (File tf :rlist(file)){
            List<InstallPackAreasInfo> installPackAreasInfos = new ArrayList<InstallPackAreasInfo>();
            //上传文件
            HttpPost httpPost = new HttpPost("http://10.21.37.164:8080/productReleasePlatform/productManage/uploadFile");
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            multipartEntityBuilder.addTextBody("path","installPackInfoPath");
            multipartEntityBuilder.addBinaryBody("file",tf);
            HttpEntity entity=multipartEntityBuilder.build();
            httpPost.setEntity(entity);
            HttpResponse httpResponse = ProductReleasePlatform.getLoginSession().execute(httpPost);
            String string = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            System.out.println(string);
            UploadFileResponse uploadFileResponse = gs.fromJson(string, UploadFileResponse.class);
            System.out.println(uploadFileResponse.getPath());


            //System.out.println(tf.getAbsolutePath());
            installPackAreasInfos.add(new InstallPackAreasInfo(tf.getName(), uploadFileResponse.getPath(),"通用版本"));
            installPackInfos.add(new InstallPackInfo(tf.getName(),tf.getAbsolutePath(),installPackAreasInfos));
        }
        InstallPackReq installPackReq = new InstallPackReq(354,installPackInfos);

        String objectStr = gs.toJson(installPackReq);
        System.out.println(objectStr);

        HttpPost httpPost = new HttpPost("http://10.21.37.164:8080/productReleasePlatform/productManage/addInstallPackInfo");
        StringEntity stringEntity = new StringEntity( objectStr,"UTF-8");
        stringEntity.setContentType("application/json");
        stringEntity.setContentEncoding("UTF-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Accept","application/json, text/javascript, */*; q=0.01");
        HttpResponse httpResponse = ProductReleasePlatform.getLoginSession().execute(httpPost);
        String result = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        System.out.println(result);

    }

    public static List<File> rlist(File file){
        if (file.isDirectory()){
            for (File xf:file.listFiles()){
                rlist(xf);
            }
        }else{
            f.add(file);
        }
        return f;
    }
}
