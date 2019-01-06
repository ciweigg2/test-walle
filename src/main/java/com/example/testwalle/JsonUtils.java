package com.example.testwalle;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class JsonUtils {

    public static String XmlToJson2(String filepath) throws IOException {
        FileInputStream in = new FileInputStream(new File(filepath));
        String xml = IOUtils.toString(in, "utf-8");
        JSONObject object = XML.toJSONObject(xml);
        return object.toString();
    }

    public static void main(String[] args) throws JSONException, IOException {
        String filepath = "C:\\Users\\Administrator\\Desktop\\11234567891234201901032220A110 .txt";
        String json = XmlToJson2(filepath);
        System.out.println(json);
    }

}
