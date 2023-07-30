
package com.marvel.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class Data implements Serializable {
    private String offset;
    private String limit;
    private String total;
    private String count;
    @JsonProperty("results")
    private List<Character> characters = null;
    private final static long serialVersionUID = 6063159335557875396L;

    /**
     * No args constructor for use in serialization
     */
    public Data() {
    }

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

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
