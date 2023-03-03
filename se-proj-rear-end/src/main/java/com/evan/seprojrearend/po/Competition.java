package com.evan.seprojrearend.po;

import java.util.Date;

public class Competition {
    private String competitionid;

    private String competitionname;

    private Date starttime;

    private Date endtime;

    private String description;

    private String sponsor;

    private String status;
    /*competitionid*/
    public String getCompetitionid() {
        return competitionid;
    }

    public void setCompetitionid(String competitionid) {
        this.competitionid = competitionid == null ? null : competitionid.trim();
    }
    /*competitionname*/
    public String getCompetitionname() {
        return competitionname;
    }

    public void setCompetitionname(String competitionname) {
        this.competitionname = competitionname == null ? null : competitionname.trim();
    }
    /*starttime*/
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }
    /*endtime*/
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
    /*description*/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
    /*sponsor*/
    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor == null ? null : sponsor.trim();
    }
    /*status*/
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}
