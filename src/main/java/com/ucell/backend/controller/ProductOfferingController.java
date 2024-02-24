package com.ucell.backend.controller;

import com.ucell.backend.response.ApiResponseV1;
import com.ucell.backend.service.ProductOfferingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductOfferingController {


    private ProductOfferingService productOfferingService;


    @GetMapping("/productOffers")
    public ApiResponseV1 getAllProductOffers(@RequestParam(value = "authToken") String authToken,
                                             @RequestParam(value = "fields",defaultValue = "") String fields,
                                             @RequestParam(value = "details",defaultValue = "0") Integer detail,
                                             @RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                             @RequestParam(value = "limit",defaultValue = "20") Integer limit){

        return productOfferingService.getAllProductOffers(fields,detail,offset,limit);

    }

    @GetMapping("/productOffers/{id}")
    public ApiResponseV1 getProductOffersById(@RequestParam(value = "authToken") String authToken,
                                              @PathVariable("id") String id,
                                              @RequestParam(value = "details",defaultValue = "0") Integer detail,
                                              @RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                              @RequestParam(value = "limit",defaultValue = "20") Integer limit){

        return productOfferingService.getProductOffersById(id,detail,offset,limit);

    }


}
