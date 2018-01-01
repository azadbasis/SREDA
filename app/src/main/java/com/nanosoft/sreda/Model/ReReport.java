package com.nanosoft.sreda.Model;

/**
 * Created by NanoSoft on 12/31/2017.
 */
public class ReReport
{
    private String tech_name;

    private String project_name;

    private String present_status;

    private String union_name;

    private String data_entry_id;

    private String completion_date;

    private String division_name;

    private String pi_name;

    private String user_type_name;

    private String district_name;

    private String village;

    private String nires_no;

    private String project_id;

    private String capacity;

    private String sub_district_name;

    private String finance_name;
    private String user_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTech_name ()
    {
        return tech_name;
    }

    public void setTech_name (String tech_name)
    {
        this.tech_name = tech_name;
    }

    public String getProject_name ()
    {
        return project_name;
    }

    public void setProject_name (String project_name)
    {
        this.project_name = project_name;
    }

    public String getPresent_status ()
    {
        return present_status;
    }

    public void setPresent_status (String present_status)
    {
        this.present_status = present_status;
    }

    public String getUnion_name ()
    {
        return union_name;
    }

    public void setUnion_name (String union_name)
    {
        this.union_name = union_name;
    }

    public String getData_entry_id ()
    {
        return data_entry_id;
    }

    public void setData_entry_id (String data_entry_id)
    {
        this.data_entry_id = data_entry_id;
    }

    public String getCompletion_date ()
    {
        return completion_date;
    }

    public void setCompletion_date (String completion_date)
    {
        this.completion_date = completion_date;
    }

    public String getDivision_name ()
    {
        return division_name;
    }

    public void setDivision_name (String division_name)
    {
        this.division_name = division_name;
    }

    public String getPi_name ()
    {
        return pi_name;
    }

    public void setPi_name (String pi_name)
    {
        this.pi_name = pi_name;
    }

    public String getUser_type_name ()
    {
        return user_type_name;
    }

    public void setUser_type_name (String user_type_name)
    {
        this.user_type_name = user_type_name;
    }

    public String getDistrict_name ()
    {
        return district_name;
    }

    public void setDistrict_name (String district_name)
    {
        this.district_name = district_name;
    }

    public String getVillage ()
    {
        return village;
    }

    public void setVillage (String village)
    {
        this.village = village;
    }

    public String getNires_no ()
    {
        return nires_no;
    }

    public void setNires_no (String nires_no)
    {
        this.nires_no = nires_no;
    }

    public String getProject_id ()
    {
        return project_id;
    }

    public void setProject_id (String project_id)
    {
        this.project_id = project_id;
    }

    public String getCapacity ()
    {
        return capacity;
    }

    public void setCapacity (String capacity)
    {
        this.capacity = capacity;
    }

    public String getSub_district_name ()
    {
        return sub_district_name;
    }

    public void setSub_district_name (String sub_district_name)
    {
        this.sub_district_name = sub_district_name;
    }

    public String getFinance_name ()
    {
        return finance_name;
    }

    public void setFinance_name (String finance_name)
    {
        this.finance_name = finance_name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [tech_name = "+tech_name+", project_name = "+project_name+", present_status = "+present_status+", union_name = "+union_name+", data_entry_id = "+data_entry_id+", completion_date = "+completion_date+", division_name = "+division_name+", pi_name = "+pi_name+", user_type_name = "+user_type_name+", district_name = "+district_name+", village = "+village+", nires_no = "+nires_no+", project_id = "+project_id+", capacity = "+capacity+", sub_district_name = "+sub_district_name+", finance_name = "+finance_name+"]";
    }
}
