package com.asiainfo.release;

import com.asiainfo.release.base.ProductVersion;
import com.asiainfo.release.session.ProductReleasePlatform;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class App2 {

    public static void main(String[] args) throws IOException {
        HttpGet httpGet = new HttpGet("http://10.21.37.164:8080/productReleasePlatform/productManage/getProductInfoList?productName=%E5%AE%A1%E8%AE%A1&versionNum=aisiav04r05c02_20180820");
        HttpResponse httpResponse = ProductReleasePlatform.getLoginSession().execute(httpGet);
        String result = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        System.out.println(result);
        System.out.println(ProductVersion.getVersionId("aisiav04r05c02_20180820"));
        System.out.println(ProductVersion.getVersionId("aisiav04r05c02_20180821"));
    }

}
