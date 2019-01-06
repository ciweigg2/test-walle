package com.example.testwalle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jdom2.JDOMException;

import java.io.IOException;

import static com.example.testwalle.JsonUtils.XmlToJson2;

public class XmlToJson {

    public static void main(String[] args) throws JDOMException, IOException {
        String filepath = "C:\\Users\\Administrator\\Desktop\\11234567891234201901032220A110 .txt";
        String json = XmlToJson2(filepath);
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject Document = jsonObject.getJSONObject("Document");
        JSONObject InCtrctMdfc = Document.getJSONObject("InCtrctMdfc");
        //单条记录
        JSONObject BsSgmt = InCtrctMdfc.getJSONObject("BsSgmt");
        System.out.println(BsSgmt.toJSONString());
        //多条记录
        JSONObject MdfcSgmt = InCtrctMdfc.getJSONObject("MdfcSgmt");
        JSONObject CtrctCertRelSgmt = MdfcSgmt.getJSONObject("CtrctCertRelSgmt");
        JSONArray CtrctCertRel = CtrctCertRelSgmt.getJSONArray("CtrctCertRel");
        System.out.println(CtrctCertRel.toJSONString());
    }

}
