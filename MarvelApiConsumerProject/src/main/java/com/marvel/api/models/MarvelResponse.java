
package com.marvel.api.models;

import java.io.Serializable;

public class MarvelResponse implements Serializable
{
    private String code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private Data data;
    private String eTag;
    private final static long serialVersionUID = -988061985969353015L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MarvelResponse() {
    }

    public MarvelResponse(String code, String status, String copyright, String attributionText, String attributionHTML, Data data, String eTag) {
        super();
        this.code = code;
        this.status = status;
        this.copyright = copyright;
        this.attributionText = attributionText;
        this.attributionHTML = attributionHTML;
        this.data = data;
        this.eTag = eTag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public MarvelResponse withAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getETag() {
        return eTag;
    }

    public void setETag(String eTag) {
        this.eTag = eTag;
    }

    public MarvelResponse withEtag(String eTag) {
        this.eTag = eTag;
        return this;
    }

    @Override
    public String toString() {
        return "Example{" +
                "code='" + code + '\'' +
                ", status='" + status + '\'' +
                ", copyright='" + copyright + '\'' +
                ", attributionText='" + attributionText + '\'' +
                ", attributionHTML='" + attributionHTML + '\'' +
                ", data=" + data +
                ", eTag='" + eTag + '\'' +
                '}';
    }
}
