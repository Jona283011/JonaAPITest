package com.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Plan {

    @JsonProperty("name")
    private String name;
    @JsonProperty("space")
    private int space;
    @JsonProperty("collaborators")
    private int collaborators;
    @JsonProperty("private_repos")
    private int privateRepos;

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public int getSpace() { return space; }
    public void setSpace(int value) { this.space = value; }

    public int getCollaborators() { return collaborators; }
    public void setCollaborators(int value) { this.collaborators = value; }

    public int getPrivateRepos() { return privateRepos; }
    public void setPrivateRepos(int value) { this.privateRepos = value; }
}
