
package com.marvel.api.models;

import java.io.Serializable;

public class Thumbnail implements Serializable
{
    private String path;
    private String extension;
    private final static long serialVersionUID = -8316897913231011347L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Thumbnail() {
    }

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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "Thumbnail{" +
                "path='" + path + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }
}
