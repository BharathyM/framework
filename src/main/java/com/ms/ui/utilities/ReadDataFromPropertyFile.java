package com.ms.ui.utilities;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
    @Test
    public void run() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("./config/AppConfig.properties");
        prop.load(file);

        String property = prop.getProperty("browser");
        System.out.println(property);
    }
}
