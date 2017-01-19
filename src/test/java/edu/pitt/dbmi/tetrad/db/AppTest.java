package edu.pitt.dbmi.tetrad.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParamRequest;
import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParameter;
import edu.pitt.dbmi.tetrad.db.entity.HpcAccount;
import edu.pitt.dbmi.tetrad.db.entity.DataValidation;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobInfo;
import edu.pitt.dbmi.tetrad.db.entity.JvmOption;
import edu.pitt.dbmi.tetrad.db.repository.HpcJobInfoRepository;
import edu.pitt.dbmi.tetrad.db.service.HpcAccountService;
import edu.pitt.dbmi.tetrad.db.service.HpcJobInfoService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName
     *            name of the test case
     */
    public AppTest(String testName) {
	super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
	return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
	Session session = TetradDatabaseApplication.getSessionFactory()
		.openSession();

	try {
	    Transaction transaction = session.beginTransaction();

	    HpcAccountService computingAccountService = new HpcAccountService(session);
	    
	    // Add ComputingAccount
	    HpcAccount computingAccount = new HpcAccount();
	    computingAccount.setConnectionName("PSC");
	    computingAccount.setUsername("");
	    computingAccount.setPassword("");
	    computingAccount.setScheme("https");
	    computingAccount.setHostname("");
	    computingAccount.setPort(443);
	    computingAccount.setCreatedDate(new Date());
	    computingAccountService.add(computingAccount);

	    // Update ComputingAccount
	    computingAccount.setPort(1000);
	    computingAccount.setLastLoginDate(new Date());
	    computingAccountService.update(computingAccount);

	    // Retrieve ComputingAccount by Id
	    long id = computingAccount.getId();
	    computingAccount = computingAccountService.findById(id);

	    // DataValidation
	    DataValidation dataValidation = new DataValidation();
	    dataValidation.setNonZeroVariance(true);
	    dataValidation.setUniqueVarName(true);	    
	    
	    // AlgorithmParamRequest	    
	    AlgorithmParamRequest algorithmParamRequest = new AlgorithmParamRequest();
	    algorithmParamRequest.setDatasetPath("~/dataset.txt");
	    algorithmParamRequest.setVariableType("continuous");
	    algorithmParamRequest.setFileDelimiter("tab");
	    algorithmParamRequest.setDataValidation(dataValidation);
	    dataValidation.setAlgorithmParamRequest(algorithmParamRequest);

	    // AlgorithmParameter
	    AlgorithmParameter param0 = new AlgorithmParameter();
	    param0.setParameter("alpha");
	    param0.setValue("0.01");
	    param0.setAlgorithmParamRequest(algorithmParamRequest);
	    
	    AlgorithmParameter param1 = new AlgorithmParameter();
	    param1.setParameter("maxDegree");
	    param1.setValue("100");
	    param1.setAlgorithmParamRequest(algorithmParamRequest);

	    List<AlgorithmParameter> algorithmParameters = new ArrayList<>();
	    algorithmParameters.add(param0);
	    algorithmParameters.add(param1);
	    
	    algorithmParamRequest.setAlgorithmParameters(algorithmParameters);

	    // JvmOption
	    JvmOption jvmOption = new JvmOption();
	    jvmOption.setAlgorithmParamRequest(algorithmParamRequest);
	    jvmOption.setParameter("maxHeapSize");
	    jvmOption.setValue("100");
	    
	    List<JvmOption> jvmOptions = new ArrayList<>();
	    jvmOptions.add(jvmOption);
	    
	    algorithmParamRequest.setJvmOptions(jvmOptions);
	    
	    //JobInfo
	    String algorithmName = "GFCI";
	    HpcJobInfo jobInfo = new HpcJobInfo();
	    jobInfo.setAlgorithmName(algorithmName);
	    jobInfo.setSubmittedTime(new Date());
	    jobInfo.setAlgorithmParamRequest(algorithmParamRequest);
	    jobInfo.setHpcAccount(computingAccount);
	    jobInfo.setStatus(0);
	    
	    HpcJobInfoService jobInfoService = new HpcJobInfoService(session);
	    
	    jobInfoService.add(jobInfo);
	    
	    jobInfoService.remove(jobInfo);
	    
	    // Remove ComputingAccount
	    computingAccountService.remove(computingAccount);

	    transaction.commit();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    session.close();
	    TetradDatabaseApplication.shutdown();
	}

	assertTrue(true);
    }
}
