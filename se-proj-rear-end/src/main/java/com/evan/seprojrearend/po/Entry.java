/**
 * Copyright (C), 2023-03-03
 * FileName: Entry
 * Author:   Lv
 * Date:     2023/3/3 8:21
 * Description: 参赛类
 */
package com.evan.seprojrearend.po;

import java.util.Date;

public class Entry {

    private String entryid;

    private String participantid;

    private String competitionid;

    private Date entrytime;

    /*entryid*/
    public String getEntryid() {
        return entryid;
    }

    public void setEntryid(String entryid) {
        this.entryid = entryid == null ? null : entryid.trim();
    }
    /*participantid*/
    public String getParticipantid() {
        return participantid;
    }

    public void setParticipantid(String participantid) {
        this.participantid = participantid == null ? null : participantid.trim();
    }
    /*competitionid*/
    public String getCompetitionid() {
        return competitionid;
    }

    public void setCompetitionid(String competitionid) {
        this.competitionid = competitionid == null ? null : competitionid.trim();
    }
    /*entrytime*/
    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }
}
