package com.yang.util;

import net.sf.json.*;
import java.io.*;
import java.util.List;

public class Util {

    public static void writeFile(String fileName,String content) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        fw.write(content);
        fw.close();
    }

    public static JSONArray readFile(String fileName) throws IOException {
        StringBuffer stringBuffer =new StringBuffer();
        FileReader fr = new FileReader(fileName);
        int ch = 0;
        while ((ch = fr.read()) != -1) {
            stringBuffer.append((char) ch);
        }
        fr.close();
        return JSONArray.fromObject(stringBuffer.toString());
    }

    public static JSONObject objToJson(Object obj){
        return JSONObject.fromObject(obj);
    }

    public static Object jsonToObj(JSONObject obj,Class T){
        return JSONObject.toBean(obj,T);
    }

    public static JSONArray listToJSONArray(List list){
        return JSONArray.fromObject(list);
    }
    public static List jsonArrayToList(JSONArray jsonArray,Class objClass){
        return (List) JSONArray.toList(jsonArray,objClass);
    }
}
