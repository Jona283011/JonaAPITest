package com.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Permissions {

    @JsonProperty("admin")
    private boolean admin;

    @JsonProperty("maintain")
    private boolean maintain;

    @JsonProperty("push")
    private boolean push;

    @JsonProperty("triage")
    private boolean triage;

    @JsonProperty("pull")
    private boolean pull;

    // Getters and Setters

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isMaintain() {
        return maintain;
    }

    public void setMaintain(boolean maintain) {
        this.maintain = maintain;
    }

    public boolean isPush() {
        return push;
    }

    public void setPush(boolean push) {
        this.push = push;
    }

    public boolean isTriage() {
        return triage;
    }

    public void setTriage(boolean triage) {
        this.triage = triage;
    }

    public boolean isPull() {
        return pull;
    }

    public void setPull(boolean pull) {
        this.pull = pull;
    }
}
