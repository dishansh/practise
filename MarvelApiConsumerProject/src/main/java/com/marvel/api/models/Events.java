
package com.marvel.api.model;

import java.io.Serializable;
import java.util.List;
import javax.validation.Valid;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Events implements Serializable
{

    @SerializedName("available")
    @Expose
    private String available;
    @SerializedName("returned")
    @Expose
    private String returned;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("items")
    @Expose
    @Valid
    private List<Item__> items = null;
    private final static long serialVersionUID = -6488572432064422893L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Events() {
    }

    /**
     * 
     * @param collectionURI
     * @param available
     * @param returned
     * @param items
     */
    public Events(String available, String returned, String collectionURI, List<Item__> items) {
        super();
        this.available = available;
        this.returned = returned;
        this.collectionURI = collectionURI;
        this.items = items;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public Events withAvailable(String available) {
        this.available = available;
        return this;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public Events withReturned(String returned) {
        this.returned = returned;
        return this;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public Events withCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
        return this;
    }

    public List<Item__> getItems() {
        return items;
    }

    public void setItems(List<Item__> items) {
        this.items = items;
    }

    public Events withItems(List<Item__> items) {
        this.items = items;
        return this;
    }

}
