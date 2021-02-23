
package com.marvel.api.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeriesSummary implements Serializable
{
    private String resourceURI;
    private String name;
    private final static long serialVersionUID = 7389290658897614271L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SeriesSummary() {
    }

    /**
     * 
     * @param name
     * @param resourceURI
     */
    public SeriesSummary(String resourceURI, String name) {
        super();
        this.resourceURI = resourceURI;
        this.name = name;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public SeriesSummary withResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SeriesSummary withName(String name) {
        this.name = name;
        return this;
    }

}
