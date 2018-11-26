package com.asiainfo.release.base;

import com.asiainfo.release.config.IConfig;
import com.asiainfo.release.entity.UploadFileResponse;
import com.asiainfo.release.session.ProductReleasePlatform;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class UploadFile {
    private static Logger logger = Logger.getLogger(UploadFile.class);
    private static Gson gson = new Gson();
    public static UploadFileResponse upload(File file ,String path) throws IOException {
        HttpPost httpPost = new HttpPost(IConfig.getInstance().getByKey("installPackUrl"));
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder.addTextBody("path",path);
        multipartEntityBuilder.addBinaryBody("file",file);
        multipartEntityBuilder.setCharset(Charset.forName("utf-8"));
        multipartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

        HttpEntity entity=multipartEntityBuilder.build();
        httpPost.setEntity(entity);
        HttpResponse httpResponse = ProductReleasePlatform.getLoginSession().execute(httpPost);
        String string = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        logger.info(string);
        UploadFileResponse uploadFileResponse = gson.fromJson(string, UploadFileResponse.class);
        return uploadFileResponse;
    }

    public static void addInfo(String url ,String body) throws IOException, InterruptedException {
        HttpPost httpPost = new HttpPost(url);
        StringEntity stringEntity = new StringEntity( body,"UTF-8");
        stringEntity.setContentType("application/json");
        stringEntity.setContentEncoding("UTF-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Accept","application/json, text/javascript, */*; q=0.01");
        JsonObject jsonObject;
        int executeCount=0;
        do{
            logger.info("第"+ ++executeCount + "次添加！");
            Thread.sleep(Integer.valueOf(IConfig.getInstance().getByKey("retryInterval")).intValue());
            HttpResponse httpResponse = ProductReleasePlatform.getLoginSession().execute(httpPost);
            String result = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
            logger.info(result);
            jsonObject = (JsonObject) new JsonParser().parse(result);
        } while (jsonObject.get("code").getAsInt() != 1 && executeCount<=Integer.valueOf(IConfig.getInstance().getByKey("retryCount")).intValue());

    }
}
