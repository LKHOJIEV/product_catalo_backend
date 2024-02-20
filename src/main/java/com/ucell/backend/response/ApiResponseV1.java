package com.ucell.backend.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ApiResponseV1 {

    private HttpStatus Status;
    private String message;
    private List<?> items;
    private Long count;
    private Integer offset;
    private Integer limit;

    @Override
    public String toString() {
        return "CategoryApiResponse{" +
                "Status='" + Status + '\'' +
                ", message='" + message + '\'' +
                ", categoryList=" + items +
                ", count=" + count +
                ", offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}
