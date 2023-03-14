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

    private String submissiontype;

    private String remark;

    private Date deadline;

    private Date switchtime;

    private Date submittime;

    private String competitiontype;

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

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor == null ? null : sponsor.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSubmissiontype() {
        return submissiontype;
    }

    public void setSubmissiontype(String submissiontype) {
        this.submissiontype = submissiontype == null ? null : submissiontype.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getSwitchtime() {
        return switchtime;
    }

    public void setSwitchtime(Date switchtime) {
        this.switchtime = switchtime;
    }

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public String getCompetitiontype() {
        return competitiontype;
    }

    public void setCompetitiontype(String competitiontype) {
        this.competitiontype = competitiontype == null ? null : competitiontype.trim();
    }
}