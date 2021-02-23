
package com.marvel.api.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnail implements Serializable
{

    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("extension")
    @Expose
    private String extension;
    private final static long serialVersionUID = -8316897913231011347L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Thumbnail() {
    }

    /**
     * 
     * @param path
     * @param extension
     */
    public Thumbnail(String path, String extension) {
        super();
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Thumbnail withPath(String path) {
        this.path = path;
        return this;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Thumbnail withExtension(String extension) {
        this.extension = extension;
        return this;
    }

}
