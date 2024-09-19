package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Verification {
    @JsonProperty("verified")
    private boolean verified;

    @JsonProperty("reason")
    private String reason;

    @JsonProperty("signature")
    private String signature;

    @JsonProperty("payload")
    private String payload;

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
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
        String maskedSign = signature != null
                ? signature.replaceAll("(?<=.{3}).", "*")
                : null;

        return "Verification{" +
                "verified=" + verified +
                ", reason='" + reason + '\'' +
                ", signature='" + maskedSign + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}

