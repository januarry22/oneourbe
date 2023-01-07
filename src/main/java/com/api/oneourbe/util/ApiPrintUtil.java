package com.api.oneourbe.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ApiPrintUtil {

    static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    public static void reqPrint(String str){
        try{
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(str);
            str = gson.toJson(je);
            System.out.println("############################################      Request(요청) Param     #################################");
            System.out.println(str);
            System.out.println("############################################      Request(요청) Param     #################################");
            //    this.reqSave(str);
        }catch(Exception e){
            //errorCode.save(e);
        }
    }
    public static void returnPrint(String str){
        try{
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(str);
            str = gson.toJson(je);

            System.out.println("############################################      Response(응답) Param     ################################");
            System.out.println(str);
            System.out.println("############################################      Response(응답) Param     ################################");
            //  this.resSave(str);
        }catch(Exception e){
            //errorCode.save(e);
        }
    }

    public static String mapToJson(Object obj){
        try{
            String ss = "";
            ObjectMapper objectMapper = new ObjectMapper();
            Map map = objectMapper.convertValue(obj, Map.class);
            ss += gson.toJson(map);
            return ss;
        }catch(Exception e){
            return null;
        }

    }
}
