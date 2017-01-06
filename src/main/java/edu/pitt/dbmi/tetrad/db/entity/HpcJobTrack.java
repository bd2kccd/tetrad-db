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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hpcAccountId", nullable = false)
    private HpcAccount hpcAccount;

    protected Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    protected Date getAddedTime() {
        return addedTime;
    }

    protected void setAddedTime(Date addedTime) {
        this.addedTime = addedTime;
    }

    protected HpcAccount getHpcAccount() {
        return hpcAccount;
    }

    protected void setHpcAccount(HpcAccount hpcAccount) {
        this.hpcAccount = hpcAccount;
    }

}
