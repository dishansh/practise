
package com.marvel.api.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item___ implements Serializable
{

    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = 7389290658897614271L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item___() {
    }

    /**
     * 
     * @param name
     * @param resourceURI
     */
    public Item___(String resourceURI, String name) {
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

    public Item___ withResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item___ withName(String name) {
        this.name = name;
        return this;
    }

}
