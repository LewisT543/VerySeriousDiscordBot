package com.spartaslavepens.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static final String PATH = "src/main/resources/application.properties";

    public static String getToken() {
         try (InputStream input = new FileInputStream(PATH)) {

             Properties prop = new Properties();
             // load a properties file
             prop.load(input);

             // get the property value and print it out
             return prop.getProperty("token");

         } catch (IOException ex) {
             ex.printStackTrace();
         }
         return null;
     }
}
