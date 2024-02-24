package com.ucell.backend.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomService {

    public static List<?> getFieldsByOrder(String fields, Page<?> page){
        List<?> list = new ArrayList<>();

        if (fields.split(",").length > 0 && !fields.equals("")){
            JSONArray jsonArray = new JSONArray();

            page.toList().forEach((offering) -> {

                JSONObject jsonObj = new JSONObject();
                Arrays.stream(fields.split(",")).toList().forEach((field) -> {

                    try {
                        jsonObj.put(field,new JSONObject(offering).get(field));
                    }catch (JSONException e){
                        System.out.println(e.getMessage());
                    }

                });
                jsonArray.put(jsonObj);
            });
            list = jsonArray.toList();
        } else {
            list = page.toList();
        }
        return list;
    }



}
