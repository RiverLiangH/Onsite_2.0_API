package com.evan.seprojrearend.po;

import java.util.Date;

public class Competition {
    private String competitionid;

    private String competitionname;

    private Date starttime;

    private Date duration;

    public String getCompetitionid() {
        return competitionid;
    }

    public void setCompetitionid(String competitionid) {
        this.competitionid = competitionid == null ? null : competitionid.trim();
    }

    public String getCompetitionname() {
        return competitionname;
    }

    public void setCompetitionname(String competitionname) {
        this.competitionname = competitionname == null ? null : competitionname.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }
}