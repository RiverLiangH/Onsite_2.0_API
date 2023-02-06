package com.evan.seprojrearend.po;

import java.util.Date;

public class Submit {
    private String submitid;

    private String submitterid;

    private String competitionid;

    private Date submittime;

    private Date testtime;

    private Float score;

    public String getSubmitid() {
        return submitid;
    }

    public void setSubmitid(String submitid) {
        this.submitid = submitid == null ? null : submitid.trim();
    }

    public String getSubmitterid() {
        return submitterid;
    }

    public void setSubmitterid(String submitterid) {
        this.submitterid = submitterid == null ? null : submitterid.trim();
    }

    public String getCompetitionid() {
        return competitionid;
    }

    public void setCompetitionid(String competitionid) {
        this.competitionid = competitionid == null ? null : competitionid.trim();
    }

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public Date getTesttime() {
        return testtime;
    }

    public void setTesttime(Date testtime) {
        this.testtime = testtime;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}