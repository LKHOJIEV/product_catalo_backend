package com.ucell.backend.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSearchingResponse {

    private String message;
    private HttpStatus status;
    private Integer attempts;
    private Boolean isAccepted;

    @Override
    public String toString() {
        return "UserSearchingResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", attempts=" + attempts +
                ", isAccepted=" + isAccepted +
                '}';
    }
}
