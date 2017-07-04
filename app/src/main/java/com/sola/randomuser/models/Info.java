package com.sola.randomuser.models;

import java.io.Serializable;

/**
 * Created by Sola2Be on 04.07.2017.
 */

public class Info implements Serializable{

    private int results;

    private int page;

    private String seed;

    private String version;

    public String getSeed ()
    {
        return seed;
    }

    public void setSeed (String seed)
    {
        this.seed = seed;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
