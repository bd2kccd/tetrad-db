package edu.pitt.dbmi.tetrad.db.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * Oct 24, 2016 1:32:10 PM
 *
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 *
 */
@Entity
public class HpcJobInfo implements Serializable {

    private static final long serialVersionUID = -3402084901576572432L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "pid")
    private Long pid;

    @Column(name = "algoId", nullable = false)
    private String algoId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "algorithmParamRequestId", nullable = false)
    private AlgorithmParamRequest algorithmParamRequest;

    @Column(name = "submittedTime")
    private Date submittedTime;

    @Column(name = "resultFileName")
    private String resultFileName;

    @Column(name = "resultJsonFileName")
    private String resultJsonFileName;

    @Column(name = "errorResultFileName")
    private String errorResultFileName;

    @Column(name = "status")
    private int status = -1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hpcAccountId", nullable = false)
    private HpcAccount hpcAccount;

    public HpcJobInfo() {

    }

    public HpcJobInfo(String algoId, Date submittedTime, String resultFileName, String resultJsonFileName,
            String errorResultFileName, int status) {
        this.algoId = algoId;
        this.submittedTime = submittedTime;
        this.resultFileName = resultFileName;
        this.resultJsonFileName = resultJsonFileName;
        this.errorResultFileName = errorResultFileName;
        this.status = status;
    }

    public HpcJobInfo(Long pid, String algoId, Date submittedTime, String resultFileName,
            String resultJsonFileName, String errorResultFileName, int status) {
        this.pid = pid;
        this.algoId = algoId;
        this.submittedTime = submittedTime;
        this.resultFileName = resultFileName;
        this.resultJsonFileName = resultJsonFileName;
        this.errorResultFileName = errorResultFileName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getAlgoId() {
        return algoId;
    }

    public void setAlgoId(String algoId) {
        this.algoId = algoId;
    }

    public AlgorithmParamRequest getAlgorithmParamRequest() {
        return algorithmParamRequest;
    }

    public void setAlgorithmParamRequest(AlgorithmParamRequest algorithmParamRequest) {
        this.algorithmParamRequest = algorithmParamRequest;
    }

    public Date getSubmittedTime() {
        return submittedTime;
    }

    public void setSubmittedTime(Date submittedTime) {
        this.submittedTime = submittedTime;
    }

    public String getResultFileName() {
        return resultFileName;
    }

    public void setResultFileName(String resultFileName) {
        this.resultFileName = resultFileName;
    }

    public String getResultJsonFileName() {
        return resultJsonFileName;
    }

    public void setResultJsonFileName(String resultJsonFileName) {
        this.resultJsonFileName = resultJsonFileName;
    }

    public String getErrorResultFileName() {
        return errorResultFileName;
    }

    public void setErrorResultFileName(String errorResultFileName) {
        this.errorResultFileName = errorResultFileName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public HpcAccount getHpcAccount() {
        return hpcAccount;
    }

    public void setHpcAccount(HpcAccount hpcAccount) {
        this.hpcAccount = hpcAccount;
    }

}
