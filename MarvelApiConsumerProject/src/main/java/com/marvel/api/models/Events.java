
package com.marvel.api.models;

import java.io.Serializable;
import java.util.List;

public class Events implements Serializable
{
    private String available;
    private String returned;
    private String collectionURI;
    private List<EventSummary> items = null;
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
    public Events(String available, String returned, String collectionURI, List<EventSummary> items) {
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

    public List<EventSummary> getItems() {
        return items;
    }

    public void setItems(List<EventSummary> items) {
        this.items = items;
    }

    public Events withItems(List<EventSummary> items) {
        this.items = items;
        return this;
    }

}
