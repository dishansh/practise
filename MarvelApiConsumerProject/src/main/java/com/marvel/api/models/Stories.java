
package com.marvel.api.models;

import java.io.Serializable;
import java.util.List;
import javax.validation.Valid;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stories implements Serializable
{
    private String available;
    private String returned;
    private String collectionURI;
    private List<StorySummary> items = null;
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
    public Stories(String available, String returned, String collectionURI, List<StorySummary> items) {
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

    public List<StorySummary> getItems() {
        return items;
    }

    public void setItems(List<StorySummary> items) {
        this.items = items;
    }

    public Stories withItems(List<StorySummary> items) {
        this.items = items;
        return this;
    }

}
