package com.asiainfo.release.base;

import com.asiainfo.release.config.IConfig;
import com.asiainfo.release.entity.CreateVersionInfo;
import com.asiainfo.release.session.ProductReleasePlatform;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ProductVersion {
    private static Logger logger = Logger.getLogger(ProductVersion.class);

    public static boolean isVersionNotExist(String ver) throws IOException {
        HttpPost httpPost = new HttpPost(IConfig.getInstance().getByKey("checkUniqueProductUrl"));
        List reqContent = new ArrayList();
        reqContent.add(new BasicNameValuePair("versionNum", ver));
        reqContent.add(new BasicNameValuePair("productName", new String(IConfig.getInstance().getByKey("productName").getBytes("iso-8859-1"), "UTF-8")));
        HttpEntity entity = new UrlEncodedFormEntity(reqContent, "UTF-8");
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        HttpResponse response = ProductReleasePlatform.getLoginSession().execute(httpPost);
        String responseStr = EntityUtils.toString(response.getEntity());
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(responseStr);
        if (jsonObject.get("code").getAsInt() == 1)
            return true;
        else
            return false;
    }

    public static boolean newVersion(String ver) throws IOException {
        if (!isVersionNotExist(ver)) {
            return false;
        }
        HttpPost httpPost = new HttpPost(IConfig.getInstance().getByKey("saveWholeProductUrl"));
        CreateVersionInfo createVersionInfo = new CreateVersionInfo();
        createVersionInfo.setIsWhole(1);
        createVersionInfo.setProductName(new String(IConfig.getInstance().getByKey("productName").getBytes("iso-8859-1"), "UTF-8"));
        createVersionInfo.setVersionNum(ver);
        createVersionInfo.setProductDescription("");
        Gson gson = new Gson();
        logger.info(gson.toJson(createVersionInfo));
        StringEntity stringEntity = new StringEntity(gson.toJson(createVersionInfo), "UTF-8");
        stringEntity.setContentType("application/json");
        stringEntity.setContentEncoding("UTF-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        HttpResponse httpResponse = ProductReleasePlatform.getLoginSession().execute(httpPost);
        String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(result);
        if (jsonObject.get("code").getAsInt() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean newVersion(String ver, String description) throws IOException {
        if (!isVersionNotExist(ver)) {
            return false;
        }
        HttpPost httpPost = new HttpPost(IConfig.getInstance().getByKey("saveWholeProductUrl"));
        CreateVersionInfo createVersionInfo = new CreateVersionInfo();
        createVersionInfo.setIsWhole(1);
        createVersionInfo.setProductName(new String(IConfig.getInstance().getByKey("productName").getBytes("iso-8859-1"), "UTF-8"));
        createVersionInfo.setVersionNum(ver);
        createVersionInfo.setProductDescription(description);
        Gson gson = new Gson();
        logger.info(gson.toJson(createVersionInfo));
        StringEntity stringEntity = new StringEntity(gson.toJson(createVersionInfo), "UTF-8");
        stringEntity.setContentType("application/json");
        stringEntity.setContentEncoding("UTF-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        HttpResponse httpResponse = ProductReleasePlatform.getLoginSession().execute(httpPost);
        String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(result);
        if (jsonObject.get("code").getAsInt() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int getVersionId(String ver) throws IOException {
        HttpGet httpGet = new HttpGet(IConfig.getInstance().getByKey("getVersionIdUrl") + "productName=" + URLEncoder.encode(new String(IConfig.getInstance().getByKey("productName").getBytes("iso-8859-1"), "UTF-8"),"UTF-8") + "&versionNum=" + ver);
        HttpResponse httpResponse = ProductReleasePlatform.getLoginSession().execute(httpGet);
        String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(result);
        int productId = jsonObject.getAsJsonArray("msg").get(0).getAsJsonObject().get("productId").getAsInt();
        logger.debug(productId);
        return productId;
    }


}
