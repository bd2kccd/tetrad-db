package edu.pitt.dbmi.tetrad.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Entity
public class HpcJobLogDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "jobState", nullable = false)
    private int jobState = -1; // -1 = Pending; 0 = Submitted;
    
    @Column(name = "progress")
    private String progress;

    @Column(name = "addedTime", nullable = false)
    private Date addedTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hpcJobLogId", nullable = false)
    private HpcJobLog hpcJobLog;

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

    public HpcJobLog getHpcJobLog() {
        return hpcJobLog;
    }

    public void setHpcJobLog(HpcJobLog hpcJobLog) {
        this.hpcJobLog = hpcJobLog;
    }


}
