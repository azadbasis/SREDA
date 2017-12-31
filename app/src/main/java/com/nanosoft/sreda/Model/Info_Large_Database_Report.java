package com.nanosoft.sreda.Model;

/**
 * Created by NanoSoft on 12/31/2017.
 */

public class Info_Large_Database_Report {

    private Results results;

    private ReReport[] reReport;

    public Results getResults ()
    {
        return results;
    }

    public void setResults (Results results)
    {
        this.results = results;
    }

    public ReReport[] getReReport ()
    {
        return reReport;
    }

    public void setReReport (ReReport[] reReport)
    {
        this.reReport = reReport;
    }
}
