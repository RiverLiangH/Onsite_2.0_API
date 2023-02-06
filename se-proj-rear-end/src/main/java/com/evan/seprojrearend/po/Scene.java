package com.evan.seprojrearend.po;

public class Scene {
    private String scenename;

    private String source;

    private String scenetype;

    private String risktype;

    private String roadtype;

    private Integer lanenum;

    private Float apolloscore;

    private String downloadlink;

    public String getScenename() {
        return scenename;
    }

    public void setScenename(String scenename) {
        this.scenename = scenename == null ? null : scenename.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getScenetype() {
        return scenetype;
    }

    public void setScenetype(String scenetype) {
        this.scenetype = scenetype == null ? null : scenetype.trim();
    }

    public String getRisktype() {
        return risktype;
    }

    public void setRisktype(String risktype) {
        this.risktype = risktype == null ? null : risktype.trim();
    }

    public String getRoadtype() {
        return roadtype;
    }

    public void setRoadtype(String roadtype) {
        this.roadtype = roadtype == null ? null : roadtype.trim();
    }

    public Integer getLanenum() {
        return lanenum;
    }

    public void setLanenum(Integer lanenum) {
        this.lanenum = lanenum;
    }

    public Float getApolloscore() {
        return apolloscore;
    }

    public void setApolloscore(Float apolloscore) {
        this.apolloscore = apolloscore;
    }

    public String getDownloadlink() {
        return downloadlink;
    }

    public void setDownloadlink(String downloadlink) {
        this.downloadlink = downloadlink == null ? null : downloadlink.trim();
    }
}