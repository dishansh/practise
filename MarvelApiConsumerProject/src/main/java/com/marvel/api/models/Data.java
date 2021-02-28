
package com.marvel.api.models;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable
{
    private String offset;
    private String limit;
    private String total;
    private String count;
    private List<Character> characters = null;
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
     * @param characters
     */
    public Data(String offset, String limit, String total, String count, List<Character> characters) {
        super();
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.count = count;
        this.characters = characters;
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

    public List<Character> getResults() {
        return characters;
    }

    public void setResults(List<Character> characters) {
        this.characters = characters;
    }

    public Data withResults(List<Character> characters) {
        this.characters = characters;
        return this;
    }

}
