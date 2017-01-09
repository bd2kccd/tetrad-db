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
 * Dec 15, 2016 1:22:22 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
@Entity
public class HpcJobTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    
    @Column(name = "addedTime", nullable = false)
    private Date addedTime;

    @Column(name = "endedTime")
    private Date endedTime;

    @Column(name = "canceledTime")
    private Date canceledTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hpcAccountId", nullable = false)
    private HpcAccount hpcAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Date addedTime) {
        this.addedTime = addedTime;
    }

    public Date getEndedTime() {
        return endedTime;
    }

    public void setEndedTime(Date endedTime) {
        this.endedTime = endedTime;
    }

    public Date getCanceledTime() {
        return canceledTime;
    }

    public void setCanceledTime(Date canceledTime) {
        this.canceledTime = canceledTime;
    }

    public HpcAccount getHpcAccount() {
        return hpcAccount;
    }

    public void setHpcAccount(HpcAccount hpcAccount) {
        this.hpcAccount = hpcAccount;
    }

}
