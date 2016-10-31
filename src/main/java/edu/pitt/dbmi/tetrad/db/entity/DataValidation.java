package edu.pitt.dbmi.tetrad.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 
 * Oct 25, 2016 7:57:56 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
@Entity
public class DataValidation implements Serializable {

    private static final long serialVersionUID = 8674106444920091695L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "dataValidation")
    private AlgorithmParamRequest algorithmParamRequest;
    
    @Column(name = "nonZeroVariance", nullable = false)
    private boolean nonZeroVariance;
    
    @Column(name = "uniqueVarName", nullable = false)
    private boolean uniqueVarName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AlgorithmParamRequest getAlgorithmParamRequest() {
        return algorithmParamRequest;
    }

    public void setAlgorithmParamRequest(AlgorithmParamRequest algorithmParamRequest) {
        this.algorithmParamRequest = algorithmParamRequest;
    }

    public boolean isNonZeroVariance() {
        return nonZeroVariance;
    }

    public void setNonZeroVariance(boolean nonZeroVariance) {
        this.nonZeroVariance = nonZeroVariance;
    }

    public boolean isUniqueVarName() {
        return uniqueVarName;
    }

    public void setUniqueVarName(boolean uniqueVarName) {
        this.uniqueVarName = uniqueVarName;
    }
    
}
