package com.nanosoft.sreda.Model;

/**
 * Created by NanoSoft on 12/31/2017.
 */

public class Year2017 {
    private String total;

    private Hydro Hydro;

    private Biogas_To_Electricity biogas_to_electricity;

    private Biomass_To_Electricity biomass_to_electricity;

    private Wind Wind;

    private Solar Solar;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public Hydro getHydro ()
    {
        return Hydro;
    }

    public void setHydro (Hydro Hydro)
    {
        this.Hydro = Hydro;
    }



    public Biogas_To_Electricity getBiogas_to_electricity() {
        return biogas_to_electricity;
    }

    public void setBiogas_to_electricity(Biogas_To_Electricity biogas_to_electricity) {
        this.biogas_to_electricity = biogas_to_electricity;
    }

    public Biomass_To_Electricity getBiomass_to_electricity() {
        return biomass_to_electricity;
    }

    public void setBiomass_to_electricity(Biomass_To_Electricity biomass_to_electricity) {
        this.biomass_to_electricity = biomass_to_electricity;
    }



    public Wind getWind ()
    {
        return Wind;
    }

    public void setWind (Wind Wind)
    {
        this.Wind = Wind;
    }

    public Solar getSolar ()
    {
        return Solar;
    }

    public void setSolar (Solar Solar)
    {
        this.Solar = Solar;
    }


}
