package com.northcoders.recordshop.model;

import java.util.List;

public class ItunesResponse {

    private Integer resultCount;
    private List<ArtworkUrl> results;

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public List<ArtworkUrl> getResults() {
        return results;
    }

    public void setResults(List<ArtworkUrl> results) {
        this.results = results;
    }
}
