package com.sola.randomuser.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sola2Be on 04.07.2017.
 */

public class User implements Serializable{

    private List<Result> results;

    private Info info;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }


    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
