
package com.marvel.api.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item_ implements Serializable
{

    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    private final static long serialVersionUID = -3063414606529367838L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item_() {
    }

    /**
     * 
     * @param name
     * @param resourceURI
     * @param type
     */
    public Item_(String resourceURI, String name, String type) {
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

    public Item_ withResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item_ withName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item_ withType(String type) {
        this.type = type;
        return this;
    }

}
