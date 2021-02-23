
package com.marvel.api.model;

import java.io.Serializable;
import java.util.List;
import javax.validation.Valid;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stories implements Serializable
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
    private List<Item_> items = null;
    private final static long serialVersionUID = -1867349611507186313L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Stories() {
    }

    /**
     * 
     * @param collectionURI
     * @param available
     * @param returned
     * @param items
     */
    public Stories(String available, String returned, String collectionURI, List<Item_> items) {
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

    public Stories withAvailable(String available) {
        this.available = available;
        return this;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public Stories withReturned(String returned) {
        this.returned = returned;
        return this;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public Stories withCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
        return this;
    }

    public List<Item_> getItems() {
        return items;
    }

    public void setItems(List<Item_> items) {
        this.items = items;
    }

    public Stories withItems(List<Item_> items) {
        this.items = items;
        return this;
    }

}
