package com.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility{
 public String getDataFromPropertiesFile (String Key) throws Throwable  {
	FileInputStream fis = new FileInputStream("./configAppData\\CrOrgData.properties");
    Properties pObj = new Properties();
    pObj.load(fis);
    String data = pObj.getProperty(Key);
    return data;
}
}