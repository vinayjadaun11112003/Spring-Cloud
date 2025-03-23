package com.lcwd.hotel.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class Apiresponse {
    private String message;
    private boolean success;
    private HttpStatus status;
    public void setMessage(String m){
        this.message=m;
    }
    public void setSuccess(boolean s){
        this.success=s;
    }
    public void setStatus(HttpStatus s){
        this.status=s;
    }


}
