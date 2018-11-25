package com.asiainfo.release;

import com.asiainfo.release.config.IConfig;
import com.asiainfo.release.entity.UploadFileResponse;
import com.google.gson.Gson;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static Logger logger = Logger.getLogger(App.class);
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://10.21.37.164:8080/productReleasePlatform/authen/checkLogin");
        //httpPost.addHeader("WAPSESSIONID","fcb7d5db-e4e3-47db-aa64-f4abae43cddb");

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("inputUserName","renshunyu"));
        nvps.add(new BasicNameValuePair("inputPassword","12345678"));
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nvps, "UTF-8");
        urlEncodedFormEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        httpPost.setEntity(urlEncodedFormEntity);
        httpPost.setHeader("Accept","application/json, text/javascript, */*; q=0.01");
        //httpPost.setHeader("Accept-Language","zh-CN,zh;q=0.9");


        // httpClient对象执行post请求,并返回响应参数对象
        HttpResponse httpResponse = httpClient.execute(httpPost);

        // 从响应对象中获取响应内容
        HttpEntity entity = httpResponse.getEntity();

        Header[]  httpHeaders = httpResponse.getHeaders("Set-Cookie");
        String result = EntityUtils.toString(entity,"UTF-8");
        logger.info(result);
        StringBuffer cookieValue=new StringBuffer();
        for (Header str:httpHeaders){
            for (HeaderElement headerElement:str.getElements()){
                if (headerElement.toString().split(";")[0].indexOf("WAPSESSIONID=") != -1 ||
                        (headerElement.toString().split(";")[0].indexOf("rememberMe=")!=-1 &&
                        headerElement.toString().split(";")[0].indexOf("==")!=-1)){
                    logger.info(headerElement.toString().split(";")[0]);
                    cookieValue.append(headerElement.toString().split(";")[0]+";");
                }

            }
        }
        cookieValue.deleteCharAt(cookieValue.length()-1);


        httpPost = new HttpPost("http://10.21.37.164:8080/productReleasePlatform/productManage/uploadFile");

        //httpPost.removeHeaders("Cookie");
        //httpPost.addHeader("Cookie",cookieValue.toString());
        httpPost.addHeader("Referer","http://10.21.37.164:8080/productReleasePlatform/productManage/addInfoIndexDispatcher?pId=355&&pP=renshunyu&&dispatcherCode=1");
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder.addTextBody("path","installPackInfoPath");
        multipartEntityBuilder.addBinaryBody("file",new File("C:\\Users\\rensy\\Desktop\\ww.py"));
        entity=multipartEntityBuilder.build();
        httpPost.setEntity(entity);
        httpResponse = httpClient.execute(httpPost);
//        int statusCode= httpResponse.getStatusLine().getStatusCode();
//        if(statusCode == 200){
//            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
//            StringBuffer buffer = new StringBuffer();
//            String str = "";
//            while((str = reader.readLine())!=null) {
//                buffer.append(str);
//            }
//            System.out.println(buffer.toString());
//        }
        int statusCode= httpResponse.getStatusLine().getStatusCode();
        Gson gs = new Gson();
        if(statusCode == 200) {
            String string = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            System.out.println(string);
            UploadFileResponse uploadFileResponse = gs.fromJson(string, UploadFileResponse.class);
            System.out.println(uploadFileResponse.getPath());
        }

        IConfig iConfig=IConfig.getInstance();
        logger.info(iConfig.getByKey("A.url.server"));






    }
}
