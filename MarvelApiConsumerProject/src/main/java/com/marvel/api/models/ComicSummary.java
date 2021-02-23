
package com.marvel.api.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComicSummary implements Serializable
{
    private String resourceURI;
    private String name;
    private final static long serialVersionUID = -7925716741000943313L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ComicSummary() {
    }

    /**
     * 
     * @param name
     * @param resourceURI
     */
    public ComicSummary(String resourceURI, String name) {
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

    public ComicSummary withResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComicSummary withName(String name) {
        this.name = name;
        return this;
    }

}
