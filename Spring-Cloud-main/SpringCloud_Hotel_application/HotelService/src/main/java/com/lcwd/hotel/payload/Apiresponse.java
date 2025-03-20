package com.lcwd.hotel.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Apiresponse {

    private String message;
    private boolean success;
    private HttpStatus status;
}
