package edu.pitt.dbmi.tetrad.db.entity;

import java.io.Serializable;

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
 * Oct 25, 2016 10:16:29 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
@Entity
public class JvmOption implements Serializable {

    private static final long serialVersionUID = 496329543903669880L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "algorithmParamRequestId", nullable = false)
    private AlgorithmParamRequest algorithmParamRequest;
    
    @Column(name = "parameter", nullable = false)
    private String parameter;
    
    @Column(name = "value", nullable = false)
    private String value;

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

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
