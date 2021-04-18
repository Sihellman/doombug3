package com.ti.server.checkout.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data

public class CustomerItemDTO {
    private String email;
    private String userId;
}
