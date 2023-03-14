package com.evan.seprojrearend.po;

public class Scene {
    private String scenename;

    private String version;

    private String source;

    private String scenetype;

    private String targettype;

    private String roadtype;

    private Integer lanenum;

    private Float apolloscore;

    private String downloadlink;

    private String originalgif;

    private String bestgif;

    private Integer carnum;

    private Float scenetime;

    private String testtype;

    public String getScenename() {
        return scenename;
    }

    public void setScenename(String scenename) {
        this.scenename = scenename == null ? null : scenename.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
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

    public String getTargettype() {
        return targettype;
    }

    public void setTargettype(String targettype) {
        this.targettype = targettype == null ? null : targettype.trim();
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

    public String getOriginalgif() {
        return originalgif;
    }

    public void setOriginalgif(String originalgif) {
        this.originalgif = originalgif == null ? null : originalgif.trim();
    }

    public String getBestgif() {
        return bestgif;
    }

    public void setBestgif(String bestgif) {
        this.bestgif = bestgif == null ? null : bestgif.trim();
    }

    public Integer getCarnum() {
        return carnum;
    }

    public void setCarnum(Integer carnum) {
        this.carnum = carnum;
    }

    public Float getScenetime() {
        return scenetime;
    }

    public void setScenetime(Float scenetime) {
        this.scenetime = scenetime;
    }

    public String getTesttype() {
        return testtype;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype == null ? null : testtype.trim();
    }
}