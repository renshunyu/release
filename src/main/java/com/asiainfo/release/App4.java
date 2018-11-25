package com.asiainfo.release;

import com.asiainfo.release.config.IConfig;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Properties;

import static java.lang.System.exit;

public class App4 {
    static private Logger logger = Logger.getLogger(App4.class);
    public static void main(String[] args) throws IOException {
        if (!IConfig.setConfig(args)) {
            exit(1);
        }
        IConfig.getInstance().getProperties().load(ClassLoader.getSystemResourceAsStream("iap.properties"));
        logger.info(new String(IConfig.getInstance().getByKey("data-monitor.zip").getBytes("iso-8859-1"), "UTF-8"));
        logger.info(new String(IConfig.getInstance().getByKey(new String("哈哈".getBytes("UTF-8"),"iso-8859-1"),"").getBytes("iso-8859-1"), "UTF-8"));
        Properties properties = new Properties();
        logger.info(properties.getProperty("versionNum","").toString());
        exit(0);



        logger.error(IConfig.getInstance().getByKey("versionNum"));
        logger.error(IConfig.getInstance().getByKey("productName"));
        //exit(0);
        //logger.info(IConfig.getInstance().getByKey("packagepath"));
        logger.info(new String(IConfig.getInstance().getByKey("packagepath").getBytes("iso-8859-1"),"UTF-8"));
        logger.info("E:\\工作文件夹\\10.1.252.239\\aisiav04r06c00_20181017\\安装包");
        logger.info(URLDecoder.decode(IConfig.getInstance().getByKey("productName"),"UTF-8"));
        logger.info(new String(URLDecoder.decode("/usr/local/productReleasePlatform/webapp/manual/%3F%3F4A%3F%3F%3F%3F%3F%3F%3F%3Fv04r06c00_20181106165129.docx","GBK")));
        logger.info(URLEncoder.encode("审计","UTF-8"));
        File file = new File("C:\\Program Files\\Git");
        for (File f :file.listFiles()){
            logger.info("");
        }

    }
}
