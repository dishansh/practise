
package com.marvel.api.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StorySummary implements Serializable
{
    private String resourceURI;
    private String name;
    private String type;
    private final static long serialVersionUID = -3063414606529367838L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public StorySummary() {
    }

    /**
     * 
     * @param name
     * @param resourceURI
     * @param type
     */
    public StorySummary(String resourceURI, String name, String type) {
        super();
        this.resourceURI = resourceURI;
        this.name = name;
        this.type = type;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public StorySummary withResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StorySummary withName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public StorySummary withType(String type) {
        this.type = type;
        return this;
    }

}
