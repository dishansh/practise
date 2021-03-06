
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
    private String etag;
    private final static long serialVersionUID = -988061985969353015L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MarvelResponse() {
    }

    /**
     * 
     * @param copyright
     * @param code
     * @param data
     * @param attributionHTML
     * @param attributionText
     * @param etag
     * @param status
     */
    public MarvelResponse(String code, String status, String copyright, String attributionText, String attributionHTML, Data data, String etag) {
        super();
        this.code = code;
        this.status = status;
        this.copyright = copyright;
        this.attributionText = attributionText;
        this.attributionHTML = attributionHTML;
        this.data = data;
        this.etag = etag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MarvelResponse withCode(String code) {
        this.code = code;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MarvelResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public MarvelResponse withCopyright(String copyright) {
        this.copyright = copyright;
        return this;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public MarvelResponse withAttributionText(String attributionText) {
        this.attributionText = attributionText;
        return this;
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

    public MarvelResponse withData(Data data) {
        this.data = data;
        return this;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public MarvelResponse withEtag(String etag) {
        this.etag = etag;
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
                ", etag='" + etag + '\'' +
                '}';
    }
}
