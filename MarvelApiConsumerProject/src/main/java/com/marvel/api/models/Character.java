
package com.marvel.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Character implements Serializable {
    private String id;
    private String name;
    private String description;
    @JsonIgnore
    private String modified;
    @JsonIgnore
    private String resourceURI;
    private Thumbnail thumbnail;
    private final static long serialVersionUID = -4486492338462769528L;

    /**
     * No args constructor for use in serialization
     */
    public Character() {
    }

    public Character(String id, String name, String description, Thumbnail thumbnail) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail=" + thumbnail +
                '}';
    }
}
