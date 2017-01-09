package edu.pitt.dbmi.tetrad.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * Dec 16, 2016 1:35:27 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public class HpcJobTrackState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "jobState", nullable = false)
    private int jobState;
    
    @Column(name = "progress")
    private String progress;

    @Column(name = "addedTime", nullable = false)
    private Date addedTime;

    @Column(name = "lastUpdatedTime")
    private Date lastUpdatedTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hpcJobTrackId", nullable = false)
    private HpcJobTrack hpcJobTrack;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getJobState() {
        return jobState;
    }

    public void setJobState(int jobState) {
        this.jobState = jobState;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Date getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Date addedTime) {
        this.addedTime = addedTime;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public HpcJobTrack getHpcJobTrack() {
        return hpcJobTrack;
    }

    public void setHpcJobTrack(HpcJobTrack hpcJobTrack) {
        this.hpcJobTrack = hpcJobTrack;
    }


}
