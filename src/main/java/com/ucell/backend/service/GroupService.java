package com.ucell.backend.service;

import com.ucell.backend.entity.Group;
import com.ucell.backend.repository.GroupRepository;
import com.ucell.backend.response.ApiResponseV1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GroupService {


    private UsersService usersService;

    private GroupRepository groupRepository;

    public GroupService(UsersService usersService, GroupRepository groupRepository) {
        this.usersService = usersService;
        this.groupRepository = groupRepository;
    }

    public ApiResponseV1 getGroupById(String user, String password, String id, Integer detail,Integer offset,Integer limit) throws Exception {

        if (usersService.isRightUserWithPass(user,password).getIsAccepted()){
            Pageable pageable = (Pageable) PageRequest.of(offset,limit);

            Page<Group> groupList = detail==1 ? groupRepository.findByRtplId(id,pageable) : groupRepository.findByRtplIdOnlyNode(id,pageable);

            return new ApiResponseV1(usersService.isRightUserWithPass(user,password).getStatus(),"success",groupList.toList(),(long) groupList.getTotalElements(),offset,limit);
        }else{
            return new ApiResponseV1(usersService.isRightUserWithPass(user,password).getStatus(),usersService.isRightUserWithPass(user,password).getMessage(),null,0L,offset,limit);
        }
    }

    public ApiResponseV1 getGroupByIdAndDirection(String user, String password, String id, String direction,Integer detail,Integer offset,Integer limit)
            throws Exception {

        if (!usersService.isRightUserWithPass(user,password).getIsAccepted()){
            return new ApiResponseV1(
                    usersService.isRightUserWithPass(user,password).getStatus(),
                    usersService.isRightUserWithPass(user,password).getMessage(),
                    null,
                    0L,
                    offset,
                    limit);
        }
        Pageable pageable = (Pageable) PageRequest.of(offset,limit);

            Page<Group> groupList =
                    detail==1
                            ? groupRepository.findByRtplIdAndDirection(id,direction,pageable)
                            : groupRepository.findByRtplIdAndDirectionOnlyNode(id,direction,pageable);

        return new ApiResponseV1(
                usersService.isRightUserWithPass(user,password).getStatus(),
                groupList.getTotalElements()>0 ? "success" : "data not found",
                groupList.toList(),
                groupList.getTotalElements(),
                offset,
                limit);
    }

    public ApiResponseV1 getGroupList(String user, String password, String direction,Integer detail,Integer offset,Integer limit)
            throws Exception {

        if (!usersService.isRightUserWithPass(user,password).getIsAccepted()){
            return new ApiResponseV1(
                    usersService.isRightUserWithPass(user,password).getStatus(),
                    usersService.isRightUserWithPass(user,password).getMessage(),
                    null,
                    0L,
                    offset,
                    limit);
        }

        Pageable pageable = (Pageable) PageRequest.of(offset,limit);

        Page<Group> groups =
                detail==1
                        ? groupRepository.findAllByDirection(direction,pageable)
                        : groupRepository.findAllByDirectionOnlyNode(direction,pageable);

            return new ApiResponseV1(
                    usersService.isRightUserWithPass(user,password).getStatus(),
                    groups.getTotalElements()>0 ? "success" : "data not found",
                    groups.toList(),
                    groups.getTotalElements(),
                    offset,
                    limit);
    }
}
