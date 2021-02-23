
package com.marvel.api.models;

import java.io.Serializable;
import java.util.List;

public class Comics implements Serializable
{
    private String available;
    private String returned;
    private String collectionURI;
    private List<ComicSummary> comicSummaries = null;
    private final static long serialVersionUID = 5395616851129754447L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Comics() {
    }

    /**
     * 
     * @param collectionURI
     * @param available
     * @param returned
     * @param comicSummaries
     */
    public Comics(String available, String returned, String collectionURI, List<ComicSummary> comicSummaries) {
        super();
        this.available = available;
        this.returned = returned;
        this.collectionURI = collectionURI;
        this.comicSummaries = comicSummaries;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public Comics withAvailable(String available) {
        this.available = available;
        return this;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public Comics withReturned(String returned) {
        this.returned = returned;
        return this;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public Comics withCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
        return this;
    }

    public List<ComicSummary> getItems() {
        return comicSummaries;
    }

    public void setItems(List<ComicSummary> comicSummaries) {
        this.comicSummaries = comicSummaries;
    }

    public Comics withItems(List<ComicSummary> comicSummaries) {
        this.comicSummaries = comicSummaries;
        return this;
    }

}
