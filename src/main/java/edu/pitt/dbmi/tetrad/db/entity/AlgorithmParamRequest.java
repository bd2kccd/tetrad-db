package edu.pitt.dbmi.tetrad.db.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * Oct 25, 2016 9:25:46 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
@Entity
public class AlgorithmParamRequest implements Serializable {

    private static final long serialVersionUID = 4951671667628471413L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "datasetFileId", nullable = false)
    private long datasetFileId;
   
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dataValidationId", nullable = false, updatable = false)
    private DataValidation dataValidation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "algorithmParamRequest")
    List<AlgorithmParameter> algorithmParameters = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "algorithmParamRequest")
    List<JvmOption> jvmOptions = new ArrayList<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getDatasetFileId() {
        return datasetFileId;
    }

    public void setDatasetFileId(long datasetFileId) {
        this.datasetFileId = datasetFileId;
    }

    public DataValidation getDataValidation() {
        return dataValidation;
    }

    public void setDataValidation(DataValidation dataValidation) {
        this.dataValidation = dataValidation;
    }

    public List<AlgorithmParameter> getAlgorithmParameters() {
        return algorithmParameters;
    }

    public void setAlgorithmParameters(List<AlgorithmParameter> algorithmParameters) {
        this.algorithmParameters = algorithmParameters;
    }

    public List<JvmOption> getJvmOptions() {
        return jvmOptions;
    }

    public void setJvmOptions(List<JvmOption> jvmOptions) {
        this.jvmOptions = jvmOptions;
    }
    
    
}
