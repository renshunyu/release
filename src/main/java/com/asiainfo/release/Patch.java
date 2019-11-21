package com.asiainfo.release;

import com.asiainfo.release.base.ProductVersion;
import com.asiainfo.release.base.UploadFile;
import com.asiainfo.release.config.IConfig;
import com.asiainfo.release.entity.FixPackInfo;
import com.asiainfo.release.entity.FixPackReq;
import com.asiainfo.release.entity.UploadFileResponse;
import com.asiainfo.release.util.CodeUtil;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static java.lang.System.exit;

public class Patch {
    private static Logger logger = Logger.getLogger(Patch.class);
    public static void main(String[] args) throws IOException, InterruptedException {
        if (!IConfig.setConfig(args)) {
            logger.error("参数错误！");
            exit(1);
        }
        IConfig iConfig = IConfig.getInstance();

        Properties properties = iConfig.getProperties();
        for (String na : properties.stringPropertyNames()){
            logger.info(na + " " + properties.getProperty(na) + " " + CodeUtil.getEncoding(properties.getProperty(na)));
        }

        if (ProductVersion.isVersionNotExist(IConfig.getInstance().getByKey("versionNum"))) {
            logger.error("版本"+IConfig.getInstance().getByKey("versionNum")+"不存在！");
            exit(1);
        }
        Gson gson = new Gson();
        int productId = ProductVersion.getVersionId(IConfig.getInstance().getByKey("versionNum"));
        File file;
        File[] files;
        String objectStr;
        file = new File(IConfig.getInstance().getByKey("patchpath"));
        files = file.listFiles();
        List<FixPackInfo> fixPackInfos = new ArrayList<FixPackInfo>();

        for (File tf : files) {
            if (tf.isFile()) {
                UploadFileResponse uploadFileResponse = UploadFile.upload(tf, IConfig.getInstance().getByKey("fixPackInfoPath"));
                //fixPackInfos.add(new FixPackInfo(tf.getName(), new String(IConfig.getInstance().getByKey("fixDescription","").getBytes("iso-8859-1"), "UTF-8"), URLDecoder.decode(uploadFileResponse.getPath(), "UTF-8"), new String(IConfig.getInstance().getByKey("fixRemark","").getBytes("iso-8859-1"), "UTF-8")));
                fixPackInfos.add(new FixPackInfo(tf.getName(),IConfig.getInstance().getByKey("fixDescription",""), URLDecoder.decode(uploadFileResponse.getPath(), "UTF-8"), IConfig.getInstance().getByKey("fixRemark","")));
            }
        }
        if (fixPackInfos.size()>0){
            FixPackReq fixPackReq = new FixPackReq(productId,fixPackInfos);
            objectStr = gson.toJson(fixPackReq);
            logger.info(objectStr);
            UploadFile.addInfo(IConfig.getInstance().getByKey("addFixPackUrl"), objectStr);
        }

    }
}
