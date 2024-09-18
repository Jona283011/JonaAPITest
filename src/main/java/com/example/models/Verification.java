package com.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Verification {
    @JsonProperty("verified")
    private boolean verified;

    @JsonProperty("reason")
    private String reason;

    @JsonProperty("signature")
    private Object signature;

    @JsonProperty("payload")
    private Object payload;

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public Object getSignature() {
        return signature;
    }

    public void setSignature(Object signature) {
        this.signature = signature;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "Verification{" +
                "verified=" + verified +
                ", reason='" + reason + '\'' +
                ", signature='" + signature + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}

