package edu.pitt.dbmi.tetrad.db.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    @Column(name = "datasetPath", nullable = false)
    private String datasetPath;
    
    @Column(name = "datasetMd5", nullable = false)
    private String datasetMd5;
    
    @Column(name = "priorKnowledgePath")
    private String priorKnowledgePath = null;
    
    @Column(name = "priorKnowledgeMd5")
    private String priorKnowledgeMd5 = null;
    
    @Column(name = "variableType", nullable = false)
    private String variableType;
    
    @Column(name = "fileDelimiter", nullable = false)
    private String fileDelimiter;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dataValidationId", nullable = false, updatable = false)
    private DataValidation dataValidation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "algorithmParamRequest")
    List<AlgorithmParameter> algorithmParameters = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "algorithmParamRequest")
    List<JvmOption> jvmOptions = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "hpcParameterAlgorParamRel", joinColumns = {
        @JoinColumn(name = "algorParamReqId", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "hpcParameterId", nullable = false, updatable = false)})
    private Set<HpcParameter> hpcParameters = new HashSet<>(0);
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatasetPath() {
        return datasetPath;
    }

    public void setDatasetPath(String datasetPath) {
        this.datasetPath = datasetPath;
    }

    public String getDatasetMd5() {
        return datasetMd5;
    }

    public void setDatasetMd5(String datasetMd5) {
        this.datasetMd5 = datasetMd5;
    }

    public String getPriorKnowledgePath() {
        return priorKnowledgePath;
    }

    public void setPriorKnowledgePath(String priorKnowledgePath) {
        this.priorKnowledgePath = priorKnowledgePath;
    }

    public String getPriorKnowledgeMd5() {
        return priorKnowledgeMd5;
    }

    public void setPriorKnowledgeMd5(String priorKnowledgeMd5) {
        this.priorKnowledgeMd5 = priorKnowledgeMd5;
    }

    public String getVariableType() {
        return variableType;
    }

    public void setVariableType(String variableType) {
        this.variableType = variableType;
    }

    public String getFileDelimiter() {
        return fileDelimiter;
    }

    public void setFileDelimiter(String fileDelimiter) {
        this.fileDelimiter = fileDelimiter;
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
	if(algorithmParameters != null){
	    for(AlgorithmParameter algorithmParameter : algorithmParameters){
	        this.algorithmParameters.add(algorithmParameter);
	    }
	}
    }

    public List<JvmOption> getJvmOptions() {
        return jvmOptions;
    }

    public void setJvmOptions(List<JvmOption> jvmOptions) {
	if(jvmOptions != null){
	    for(JvmOption jvmOption : jvmOptions){
		this.jvmOptions.add(jvmOption);
	    }
	}
    }

	public Set<HpcParameter> getHpcParameters() {
		return hpcParameters;
	}

	public void setHpcParameters(Set<HpcParameter> hpcParameters) {
		this.hpcParameters = hpcParameters;
	}
    
    
}
