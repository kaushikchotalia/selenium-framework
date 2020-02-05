package com.kaushik.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class FrameWorkConfig {
    private Properties properties;
    private  static FrameWorkConfig frameWorkConfig;

    //Constructor to get properties
    private FrameWorkConfig(){
        try{
            InputStream inputStream = new FileInputStream(Paths.get("src/test/resources/framework.properties").toFile());
            properties = new Properties();
            properties.load(inputStream);
        }catch(IOException ex) {
        }
    }
    public static String getProperty(String key){
        if(frameWorkConfig == null)
        {
            frameWorkConfig = new FrameWorkConfig();
        }
        return (String) frameWorkConfig.properties.get(key);
    }
}
