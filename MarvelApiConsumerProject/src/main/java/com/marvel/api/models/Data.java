
package com.marvel.api.model;

import java.io.Serializable;
import java.util.List;
import javax.validation.Valid;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable
{

    @SerializedName("offset")
    @Expose
    private String offset;
    @SerializedName("limit")
    @Expose
    private String limit;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("results")
    @Expose
    @Valid
    private List<Result> results = null;
    private final static long serialVersionUID = 6063159335557875396L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param total
     * @param offset
     * @param limit
     * @param count
     * @param results
     */
    public Data(String offset, String limit, String total, String count, List<Result> results) {
        super();
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.count = count;
        this.results = results;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public Data withOffset(String offset) {
        this.offset = offset;
        return this;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public Data withLimit(String limit) {
        this.limit = limit;
        return this;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Data withTotal(String total) {
        this.total = total;
        return this;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Data withCount(String count) {
        this.count = count;
        return this;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Data withResults(List<Result> results) {
        this.results = results;
        return this;
    }

}
