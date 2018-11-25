package com.asiainfo.release.session;


import com.asiainfo.release.config.IConfig;
import com.asiainfo.release.exception.NoLoginException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductReleasePlatform {
    private ProductReleasePlatform() {
    }

    private static CloseableHttpClient httpClient = HttpClients.createDefault();
    private static int loginstatus = 0;

    synchronized public static CloseableHttpClient getLoginSession() {
        if (loginstatus != 1) {
            HttpPost httpPost = new HttpPost(IConfig.getInstance().getByKey("login.url"));
            List reqContent = new ArrayList();
            reqContent.add(new BasicNameValuePair("inputUserName", IConfig.getInstance().getByKey("login.name")));
            reqContent.add(new BasicNameValuePair("inputPassword", IConfig.getInstance().getByKey("login.passwd")));
            try {
                HttpEntity entity = new UrlEncodedFormEntity(reqContent, "UTF-8");
                httpPost.setEntity(entity);
                httpPost.setHeader("Accept","application/json, text/javascript, */*; q=0.01");
                HttpResponse response = httpClient.execute(httpPost);
                if (response.getStatusLine().getStatusCode() == 200) {
                    InputStream in = response.getEntity().getContent();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuffer stringBuffer = new StringBuffer();
                    String str = "";
                    while ((str = reader.readLine()) != null) {
                        stringBuffer.append(str);
                    }
                    reader.close();
                    in.close();
                    JsonObject jsonObject = new JsonParser().parse(stringBuffer.toString()).getAsJsonObject();
                    if (jsonObject.get("code").getAsInt() == 1) {
                        loginstatus = 1;
                    }else{
                        try {
                            throw new NoLoginException();
                        } catch (NoLoginException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return httpClient;
    }

}
