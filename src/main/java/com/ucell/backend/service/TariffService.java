package com.ucell.backend.service;

import com.ucell.backend.entity.Tariff;
import com.ucell.backend.repository.TariffRepository;
import com.ucell.backend.response.ApiResponseV1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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

    public ApiResponseV1 getTariffList(String fields,Integer detail, String state, Integer offset, Integer limit) {

            Pageable pageable = (Pageable) PageRequest.of(offset,limit);

            Page<Tariff> tariffList =
                    detail==1
                            ? tariffRepository.findAllByState(state,pageable)
                            : tariffRepository.findAllByStateOnlyNode(state,pageable);

            return new ApiResponseV1(
                    HttpStatus.ACCEPTED,
                    tariffList.getTotalElements()>0 ? "success" : "data not found",
                    CustomService.getFieldsByOrder(fields,tariffList),
                    (long) CustomService.getFieldsByOrder(fields,tariffList).size(),
                    offset,
                    limit);
    }

    public ApiResponseV1 getTariffbyRtpl(String fields,Integer detail, String id, String state, Integer offset, Integer limit) {


            Pageable pageable = PageRequest.of(offset,limit);

            Page<Tariff> tariffList =
                    detail==1
                            ? tariffRepository.findByRtplIdAndState(id,state,pageable)
                            : tariffRepository.findByRtplIdAndStateOnlyNode(id,state,pageable);

            return new ApiResponseV1(
                    HttpStatus.ACCEPTED,
                    tariffList.getTotalElements()>0 ? "success" : "data not found",
                    CustomService.getFieldsByOrder(fields,tariffList),
                    (long) CustomService.getFieldsByOrder(fields,tariffList).size(),
                    offset,
                    limit);


    }
}
