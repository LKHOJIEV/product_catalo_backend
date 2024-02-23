package com.ucell.backend.service;

import com.ucell.backend.entity.BundledProductOffering;
import com.ucell.backend.repository.BundledProductOfferingRepository;
import com.ucell.backend.response.ApiResponseV1;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class BundledProductOfferingService {
    @Autowired
    private BundledProductOfferingRepository bundledProductOfferingRepository;
    @Autowired
    private UsersService usersService;


    public ApiResponseV1 getAllProductOffers(Integer detail, Integer offset, Integer limit)
            throws Exception {

            Pageable pageable = PageRequest.of(offset,limit);

            Page<BundledProductOffering> bundledProductOfferingList =
                    detail==1
                            ? bundledProductOfferingRepository.findAll(pageable)
                            :  bundledProductOfferingRepository.findAllOnlyNode(pageable);

            return new ApiResponseV1(
                    HttpStatus.ACCEPTED,
                    bundledProductOfferingList.getTotalElements()>0 ? "success" : "data not found",
                    bundledProductOfferingList.toList(),
                    bundledProductOfferingList.getTotalElements(),
                    offset,
                    limit);

    }

    public ApiResponseV1 getProductOffersById(String id, Integer detail, Integer offset, Integer limit)
            throws Exception {


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
