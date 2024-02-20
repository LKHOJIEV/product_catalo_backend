package com.ucell.backend.response;

import com.ucell.backend.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ApiResponseV2 {

    private HttpStatus Status;
    private String message;
    private Map<String,Category> items;
    private Long count;
    private Integer offset;
    private Integer limit;

    @Override
    public String toString() {
        return "CategoryApiResponse{" +
                "Status='" + Status + '\'' +
                ", message='" + message + '\'' +
                ", categoryMap=" + items +
                ", count=" + count +
                ", offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}
