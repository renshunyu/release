package com.asiainfo.release.config;


import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

import static java.lang.System.exit;

public class IConfig {
    private static Logger logger = Logger.getLogger(IConfig.class);
    private static IConfig iConfig;
    private static Properties properties = new Properties();

    static {
        logger.info("读取配置文件开始");
        try {
            ClassLoader classLoader = IConfig.class.getClassLoader();
            properties.load(classLoader.getResourceAsStream("conf.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("读取配置文件结束");
    }

    public static IConfig getInstance() {
        if (iConfig == null) {
            iConfig = new IConfig();
        }
        return iConfig;
    }

    public static boolean setConfig(String[] args) {
        for (String arg : args) {
            if (arg.indexOf("=") != -1) {
                logger.info(arg.indexOf("="));
                logger.info(arg.substring(0, arg.indexOf("=")));
                logger.info(arg.substring(arg.indexOf("=") + 1));
                if (properties.containsKey(arg.substring(0, arg.indexOf("=")))) {
                    properties.setProperty(arg.substring(0, arg.indexOf("=")), arg.substring(arg.indexOf("=") + 1));
                } else {
                    logger.error("非法参数 " + arg);
                    return false;
                }


            } else {
                logger.error("非法参数 " + arg);
                return false;
            }
        }
        return true;
    }

    public String getByKey(String key) {
        return properties.getProperty(key);
    }

    public String getByKey(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public Properties getProperties() {
        return properties;
    }

    private IConfig() {
    }
}
