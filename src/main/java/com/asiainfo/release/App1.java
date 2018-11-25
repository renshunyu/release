package com.asiainfo.release;

import com.asiainfo.release.session.ProductReleasePlatform;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.*;

public class App1 {
    public static void main(String[] args) throws IOException {
        HttpPost httpPost = new HttpPost("http://10.21.37.164:8080/productReleasePlatform/productManage/addInstallPackInfo");
        StringEntity stringEntity = new StringEntity( "{\"productId\":\"355\",\"installPackInfoList\":[{\"installPackAreasInfoList\":[{\"downUrl\":\"/usr/local/productReleasePlatform/webapp/installPackage/ap_gather_syslog_20181031192802.war\",\"areaNames\":\"哈哈\",\"areaFileName\":\"ww.py\"}],\"changeDescription\":\"哈哈哈哈\",\"installPackName\":\"erwre\"}]}","UTF-8");
        stringEntity.setContentType("application/json");
        stringEntity.setContentEncoding("UTF-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Accept","application/json, text/javascript, */*; q=0.01");
        HttpResponse httpResponse = ProductReleasePlatform.getLoginSession().execute(httpPost);
        String result = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        System.out.println(result);



    }
}
