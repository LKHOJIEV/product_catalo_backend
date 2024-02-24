package com.ucell.backend.controller;

import com.ucell.backend.response.ApiResponseV1;
import com.ucell.backend.service.BundledProductOfferingService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BundledProductOfferingController {

    private BundledProductOfferingService bundledProductOfferingService;

    public BundledProductOfferingController(BundledProductOfferingService bundledProductOfferingService) {
        this.bundledProductOfferingService = bundledProductOfferingService;
    }

    @GetMapping("/bundledProductOffers")
    public ApiResponseV1 getAllProductOffers(@RequestParam(value = "authToken") String authToken,
                                             @RequestParam(value = "fields",defaultValue = "") String fields,
                                             @RequestParam(value = "details",defaultValue = "0") Integer detail,
                                             @RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                             @RequestParam(value = "limit",defaultValue = "20") Integer limit) throws Exception {

        return bundledProductOfferingService.getAllProductOffers(fields,detail,offset,limit);

    }

    @GetMapping("/bundledProductOffers/{id}")
    public ApiResponseV1 getProductOffersById(@RequestParam(value = "authToken") String authToken,
                                              @RequestParam(value = "fields",defaultValue = "") String fields,
                                              @PathVariable("id") String id,
                                              @RequestParam(value = "details",defaultValue = "0") Integer detail,
                                              @RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                              @RequestParam(value = "limit",defaultValue = "20") Integer limit) throws Exception {

        return bundledProductOfferingService.getProductOffersById(fields,id,detail,offset,limit);

    }


}


