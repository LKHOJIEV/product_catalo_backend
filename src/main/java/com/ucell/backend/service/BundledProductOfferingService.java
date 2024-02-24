package com.ucell.backend.service;

import com.ucell.backend.entity.BundledProductOffering;
import com.ucell.backend.repository.BundledProductOfferingRepository;
import com.ucell.backend.response.ApiResponseV1;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@Log4j2
public class BundledProductOfferingService {
    @Autowired
    private BundledProductOfferingRepository bundledProductOfferingRepository;
    @Autowired
    private UsersService usersService;


    public ApiResponseV1 getAllProductOffers(String fields, Integer detail, Integer offset, Integer limit)
            {

            Pageable pageable = PageRequest.of(offset,limit);
            List<?> list = new ArrayList<>();

            Page<BundledProductOffering> bundledProductOfferingList =
                    detail==1
                            ? bundledProductOfferingRepository.findAll(pageable)
                            :  bundledProductOfferingRepository.findAllOnlyNode(pageable);



            if (fields.split(",").length > 0 && !fields.equals("")){
                JSONArray jsonArray = new JSONArray();

                bundledProductOfferingList.toList().forEach((offering) -> {

                  JSONObject jsonObj = new JSONObject();
                    Arrays.stream(fields.split(",")).toList().forEach((field) -> {
//                        if (field.contains(".")){
//                            Object res = "";
//                            Arrays.stream(field.split(".")).forEach((specField) ->{
//                                res = new JSONObject().opt(specField);
//                             });
//                        }
                        try {
                            jsonObj.put(field,new JSONObject(offering).opt(field));
                            //new JSONObject(offering).opt()
                        }catch (JSONException e){
                            System.out.println(e.getMessage());
                            return;
                        }

                    });
                  jsonArray.put(jsonObj);
                });
                list = jsonArray.toList();
            } else {
                list = bundledProductOfferingList.toList();
            }

            return new ApiResponseV1(
                    HttpStatus.ACCEPTED,
                    bundledProductOfferingList.getTotalElements()>0 ? "success" : "data not found",
                    list,
                    (long) list.size(),
                    offset,
                    limit);

    }

    public ApiResponseV1 getProductOffersById(String id, Integer detail, Integer offset, Integer limit)
             {


        Pageable pageable = PageRequest.of(offset,limit);

        Page<BundledProductOffering> bundledProductOfferingList =
                detail==1
                        ? bundledProductOfferingRepository.findByRtplId(id,pageable)
                        : bundledProductOfferingRepository.findByRtplIdOnlyNode(id,pageable);


        return new ApiResponseV1(
                HttpStatus.ACCEPTED,
                bundledProductOfferingList.getTotalElements()>0 ? "success" : "data not found",
                bundledProductOfferingList.toList(),
                bundledProductOfferingList.getTotalElements(),
                offset,
                limit);
    }
}
