package com.ti.server.checkout.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class StripeRespons {
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public StripeRespons(String sessionId) {
        this.sessionId = sessionId;
    }

    public StripeRespons() {
    }
}
