package com.ucell.backend.controller;

import com.ucell.backend.response.ApiResponseV1;
import com.ucell.backend.service.BundledProductOfferingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/")
public class BundledProductOfferingController {

    private BundledProductOfferingService bundledProductOfferingService;

    public BundledProductOfferingController(BundledProductOfferingService bundledProductOfferingService) {
        this.bundledProductOfferingService = bundledProductOfferingService;
    }

    @GetMapping("api/productOffers")
    public ApiResponseV1 getAllProductOffers(@RequestParam("user") String user,
                                             @RequestParam("secret") String password,
                                             @RequestParam(value = "details",defaultValue = "0") Integer detail,
                                             @RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                             @RequestParam(value = "limit",defaultValue = "20") Integer limit) throws Exception {

        return bundledProductOfferingService.getAllProductOffers(user,password,detail,offset,limit);

    }

    @GetMapping("api/productOffers/{id}")
    public ApiResponseV1 getProductOffersById(@RequestParam("user") String user,
                                              @RequestParam("secret") String password,
                                              @PathVariable("id") String id,
                                              @RequestParam(value = "details",defaultValue = "0") Integer detail,
                                              @RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                              @RequestParam(value = "limit",defaultValue = "20") Integer limit) throws Exception {

        return bundledProductOfferingService.getProductOffersById(user,password,id,detail,offset,limit);

    }


}


