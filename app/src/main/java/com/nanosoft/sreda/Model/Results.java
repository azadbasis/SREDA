package com.nanosoft.sreda.Model;

/**
 * Created by NanoSoft on 12/31/2017.
 */

public class Results {

    private String[] technologies;

    private Data data;

    public String[] getTechnologies ()
    {
        return technologies;
    }

    public void setTechnologies (String[] technologies)
    {
        this.technologies = technologies;
    }

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
    }
}
