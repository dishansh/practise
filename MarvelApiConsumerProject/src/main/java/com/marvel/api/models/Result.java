
package com.marvel.api.models;

import java.io.Serializable;
import java.util.List;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Serializable
{
    private String id;
    private String name;
    private String description;
    private String modified;
    private String resourceURI;
    private List<Url> urls = null;
    private Thumbnail thumbnail;
    private Comics comics;
    private Stories stories;
    private Events events;
    private Series series;
    private final static long serialVersionUID = -4486492338462769528L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param urls
     * @param thumbnail
     * @param stories
     * @param series
     * @param comics
     * @param name
     * @param description
     * @param modified
     * @param id
     * @param resourceURI
     * @param events
     */
    public Result(String id, String name, String description, String modified, String resourceURI, List<Url> urls, Thumbnail thumbnail, Comics comics, Stories stories, Events events, Series series) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.modified = modified;
        this.resourceURI = resourceURI;
        this.urls = urls;
        this.thumbnail = thumbnail;
        this.comics = comics;
        this.stories = stories;
        this.events = events;
        this.series = series;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Result withId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Result withName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Result withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonIgnore
    public String getModified() {
        return modified;
    }

    @JsonIgnore
    public void setModified(String modified) {
        this.modified = modified;
    }

    public Result withModified(String modified) {
        this.modified = modified;
        return this;
    }

    @JsonIgnore
    public String getResourceURI() {
        return resourceURI;
    }

    @JsonIgnore
    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Result withResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
        return this;
    }

    @JsonIgnore
    public List<Url> getUrls() {
        return urls;
    }

    @JsonIgnore
    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public Result withUrls(List<Url> urls) {
        this.urls = urls;
        return this;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Result withThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    @JsonIgnore
    public Comics getComics() {
        return comics;
    }

    @JsonIgnore
    public void setComics(Comics comics) {
        this.comics = comics;
    }

    public Result withComics(Comics comics) {
        this.comics = comics;
        return this;
    }

    @JsonIgnore
    public Stories getStories() {
        return stories;
    }

    @JsonIgnore
    public void setStories(Stories stories) {
        this.stories = stories;
    }

    public Result withStories(Stories stories) {
        this.stories = stories;
        return this;
    }

    @JsonIgnore
    public Events getEvents() {
        return events;
    }

    @JsonIgnore
    public void setEvents(Events events) {
        this.events = events;
    }

    public Result withEvents(Events events) {
        this.events = events;
        return this;
    }

    @JsonIgnore
    public Series getSeries() {
        return series;
    }

    @JsonIgnore
    public void setSeries(Series series) {
        this.series = series;
    }

    public Result withSeries(Series series) {
        this.series = series;
        return this;
    }

}
