
package com.marvel.api.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item__ implements Serializable
{

    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = 2752339750885288988L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item__() {
    }

    /**
     * 
     * @param name
     * @param resourceURI
     */
    public Item__(String resourceURI, String name) {
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

    public Item__ withResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item__ withName(String name) {
        this.name = name;
        return this;
    }

}
