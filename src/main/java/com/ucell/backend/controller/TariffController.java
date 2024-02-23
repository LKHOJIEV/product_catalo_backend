package com.ucell.backend.controller;

import com.ucell.backend.response.ApiResponseV1;
import com.ucell.backend.service.TariffService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/")
public class TariffController {

    private TariffService tariffService;

    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping("api/tariff")
    public ApiResponseV1 getAllCategory(@RequestParam(value = "state",defaultValue = "init") String state,
                                        @RequestParam(value = "details",defaultValue = "0") Integer detail,
                                        @RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                        @RequestParam(value = "limit",defaultValue = "20") Integer limit
                                        ) throws Exception {

        return tariffService.getTariffList(detail,state,offset,limit);

    }

    @GetMapping("api/tariff/{id}")
    public ApiResponseV1 getAllCategory(@RequestParam(value = "state",defaultValue = "init") String state,
                                        @RequestParam(value = "details",defaultValue = "0") Integer detail,
                                        @RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                        @RequestParam(value = "limit",defaultValue = "20") Integer limit,
                                        @PathVariable("id") String id) throws Exception {

        return tariffService.getTariffbyRtpl(detail,id,state,offset,limit);

    }

}
