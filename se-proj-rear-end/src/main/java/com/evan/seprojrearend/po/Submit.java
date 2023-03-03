package com.evan.seprojrearend.po;

import java.util.Date;

public class Submit {
    private String submitid;

    private String submitterid;

    private String competitionid;

    private Date submittime;

    private Date testtime;

    private Float score;

    private String dockerid;

    private String papertype;

    private String resultlink;

    /*submitid*/
    public String getSubmitid() {
        return submitid;
    }

    public void setSubmitid(String submitid) {
        this.submitid = submitid == null ? null : submitid.trim();
    }
    /*submitterid*/
    public String getSubmitterid() {
        return submitterid;
    }

    public void setSubmitterid(String submitterid) {
        this.submitterid = submitterid == null ? null : submitterid.trim();
    }
    /*competitionid*/
    public String getCompetitionid() {
        return competitionid;
    }

    public void setCompetitionid(String competitionid) {
        this.competitionid = competitionid == null ? null : competitionid.trim();
    }
    /*submittime*/
    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }
    /*testtime*/
    public Date getTesttime() {
        return testtime;
    }

    public void setTesttime(Date testtime) {
        this.testtime = testtime;
    }
    /*score*/
    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
    /*dockerid*/
    public String getDockerid() {
        return dockerid;
    }

    public void setDockerid(String dockerid) {
        this.dockerid = dockerid == null ? null : dockerid.trim();
    }
    /*papertype*/
    public String getPapertype() {
        return papertype;
    }

    public void setPapertype(String papertype) {
        this.papertype = papertype == null ? null : papertype.trim();
    }
    /*resultlink*/
    public String getResultlink() {
        return resultlink;
    }

    public void setResultlink(String resultlink) {
        this.resultlink = resultlink == null ? null : resultlink.trim();
    }
}
