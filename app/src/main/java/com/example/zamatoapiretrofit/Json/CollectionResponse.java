package com.example.zamatoapiretrofit.Json;

import java.util.List;

public class CollectionResponse {

    private int has_more;
     private int has_total;
    private String share_url;
    private String display_text;
    private List<Collection> collections;

    public int getHas_more() {
        return has_more;
    }

    public void setHas_more(int has_more) {
        this.has_more = has_more;
    }

    public int getHas_total() {
        return has_total;
    }

    public void setHas_total(int has_total) {
        this.has_total = has_total;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getDisplay_text() {
        return display_text;
    }

    public void setDisplay_text(String display_text) {
        this.display_text = display_text;
    }

    public List<Collection> getCollection() {
        return collections;
    }

    public void setCollection(List<Collection> collection) {
        this.collections = collection;
    }
}

// Create InterFace

