package com.northcoders.recordshop.model;

import java.util.List;

public class Results {

    private Integer resultCount;
    private List<ItunesResponse> results;

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public List<ItunesResponse> getResults() {
        return results;
    }

    public void setResults(List<ItunesResponse> results) {
        this.results = results;
    }
}
