package com.ucell.backend.service;

import com.ucell.backend.entity.Tariff;
import com.ucell.backend.repository.TariffRepository;
import com.ucell.backend.response.ApiResponseV1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
public class TariffService {

    private final UsersService usersService;

    private final TariffRepository tariffRepository;

    public TariffService(UsersService usersService, TariffRepository tariffRepository) {
        this.usersService = usersService;
        this.tariffRepository = tariffRepository;
    }

    public ApiResponseV1 getTariffList(String userName, String password, Integer detail, String state, Integer offset, Integer limit)
            throws Exception {


            if (!usersService.isRightUserWithPass(userName,password).getIsAccepted()){
                return new ApiResponseV1(
                        usersService.isRightUserWithPass(userName,password).getStatus(),
                        usersService.isRightUserWithPass(userName,password).getMessage(),
                        null,
                        0L,
                        offset,
                        limit);
            }

            Pageable pageable = (Pageable) PageRequest.of(offset,limit);

            Page<Tariff> tariffList =
                    detail==1
                            ? tariffRepository.findAllByState(state,pageable)
                            : tariffRepository.findAllByStateOnlyNode(state,pageable);

            return new ApiResponseV1(
                    usersService.isRightUserWithPass(userName,password).getStatus(),
                    tariffList.getTotalElements()>0 ? "success" : "data not found",
                    tariffList.toList(),
                    tariffList.getTotalElements(),
                    offset,
                    limit);
    }

    public ApiResponseV1 getTariffbyRtpl(String user, String password, Integer detail, String id, String state, Integer offset, Integer limit)
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

            Pageable pageable = PageRequest.of(offset,limit);

            Page<Tariff> tariffList =
                    detail==1
                            ? tariffRepository.findByRtplIdAndState(id,state,pageable)
                            : tariffRepository.findByRtplIdAndStateOnlyNode(id,state,pageable);

            return new ApiResponseV1(
                    usersService.isRightUserWithPass(user,password).getStatus(),
                    tariffList.getTotalElements()>0 ? "success" : "data not found",
                    tariffList.toList(),
                    tariffList.getTotalElements(),
                    offset,
                    limit);


    }
}
