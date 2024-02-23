package com.ucell.backend.controller;

import com.ucell.backend.response.ApiResponseV1;
import com.ucell.backend.service.GroupService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/")
public class GroupController {

    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }


    @GetMapping("api/group")
    public ApiResponseV1 getAllCategory(@RequestParam(value = "direction",defaultValue = "in") String direction,
                                        @RequestParam(value = "details",defaultValue = "0") Integer detail,
                                        @RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                        @RequestParam(value = "limit",defaultValue = "20") Integer limit) throws Exception {

        return groupService.getGroupList(direction,detail,offset,limit);

    }

    @GetMapping("api/group/{id}")
    public ApiResponseV1 getCategoryById(@PathVariable("id") String id,
                                         @RequestParam(value = "direction",defaultValue = "in") String direction,
                                         @RequestParam(value = "details",defaultValue = "0") Integer detail,
                                         @RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                         @RequestParam(value = "limit",defaultValue = "20") Integer limit) throws Exception {

        return groupService.getGroupByIdAndDirection(id, direction,detail,offset,limit);

    }



}
