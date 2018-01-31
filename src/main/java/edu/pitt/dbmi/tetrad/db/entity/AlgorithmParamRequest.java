package edu.pitt.dbmi.tetrad.db.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

    @Column(name = "testId")
    private String testId = null;

    @Column(name = "scoreId")
    private String scoreId = null;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "algorithmParamRequest")
    private Set<AlgorithmParameter> algorithmParameters = new HashSet<>();

    @Column(name = "jvmOptions")
    private JvmOptions jvmOptions = null;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "algorithmParamRequest")
    private Set<HpcParameter> hpcParameters = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getScoreId() {
		return scoreId;
	}

	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
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

	public Set<AlgorithmParameter> getAlgorithmParameters() {
		return algorithmParameters;
	}

	public void setAlgorithmParameters(Set<AlgorithmParameter> algorithmParameters) {
		this.algorithmParameters = algorithmParameters;
	}

	public JvmOptions getJvmOptions() {
		return jvmOptions;
	}

	public void setJvmOptions(JvmOptions jvmOptions) {
		this.jvmOptions = jvmOptions;
	}

	public Set<HpcParameter> getHpcParameters() {
		return hpcParameters;
	}

	public void setHpcParameters(Set<HpcParameter> hpcParameters) {
		this.hpcParameters = hpcParameters;
	}

}
