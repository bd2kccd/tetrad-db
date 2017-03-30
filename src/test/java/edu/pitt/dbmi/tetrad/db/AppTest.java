package edu.pitt.dbmi.tetrad.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParamRequest;
import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParameter;
import edu.pitt.dbmi.tetrad.db.entity.HpcAccount;
import edu.pitt.dbmi.tetrad.db.entity.DataValidation;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobInfo;
import edu.pitt.dbmi.tetrad.db.entity.HpcParameter;
import edu.pitt.dbmi.tetrad.db.entity.JvmOption;
import edu.pitt.dbmi.tetrad.db.service.AlgorithmParamRequestService;
import edu.pitt.dbmi.tetrad.db.service.DataValidationService;
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
     * @param testName name of the test case
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
            HpcAccountService hpcAccountService = new HpcAccountService(session);

            // Add ComputingAccount
            HpcAccount hpcAccount = new HpcAccount();
            hpcAccount.setConnectionName("PSC");
            hpcAccount.setUsername("");
            hpcAccount.setPassword("");
            hpcAccount.setScheme("https");
            hpcAccount.setHostname("");
            hpcAccount.setPort(443);
            hpcAccount.setCreatedDate(new Date(System.currentTimeMillis()));
            hpcAccountService.add(hpcAccount);

            // Update ComputingAccount
            hpcAccount.setPort(1000);
            hpcAccount.setLastLoginDate(new Date());
            hpcAccountService.update(hpcAccount);

            // Retrieve ComputingAccount by Id
            long id = hpcAccount.getId();
            hpcAccount = hpcAccountService.findById(id);

            // DataValidation
            DataValidation dataValidation = new DataValidation();
            dataValidation.setNonZeroVariance(true);
            dataValidation.setUniqueVarName(true);

            DataValidationService dataValidationService = new DataValidationService(session);

            dataValidationService.add(dataValidation);

            // AlgorithmParamRequest
            AlgorithmParamRequest algorithmParamRequest = new AlgorithmParamRequest();
            algorithmParamRequest.setDatasetPath("~/dataset.txt");
            algorithmParamRequest.setDatasetMd5("");
            algorithmParamRequest.setVariableType("continuous");
            algorithmParamRequest.setFileDelimiter("tab");
            algorithmParamRequest.setDataValidation(dataValidation);
            dataValidation.setAlgorithmParamRequest(algorithmParamRequest);

            // AlgorithmParameter
            AlgorithmParameter param0 = new AlgorithmParameter();
            param0.setParameter("alpha");
            param0.setValue("0.01");
            param0.setAlgorithmParamRequest(algorithmParamRequest);

            //AlgorithmParameterService algorParamService = new AlgorithmParameterService(session);
            //algorParamService.add(param0);
            AlgorithmParameter param1 = new AlgorithmParameter();
            param1.setParameter("maxDegree");
            param1.setValue("100");
            param1.setAlgorithmParamRequest(algorithmParamRequest);

            //algorParamService.add(param1);
            List<AlgorithmParameter> algorithmParameters = new ArrayList<>();
            algorithmParameters.add(param0);
            algorithmParameters.add(param1);

            algorithmParamRequest.setAlgorithmParameters(algorithmParameters);

            // JvmOption
            JvmOption jvmOption = new JvmOption();
            jvmOption.setAlgorithmParamRequest(algorithmParamRequest);
            jvmOption.setParameter("maxHeapSize");
            jvmOption.setValue("100");

            //JvmOptionService jvmOptionService = new JvmOptionService(session);
            //jvmOptionService.add(jvmOption);
            List<JvmOption> jvmOptions = new ArrayList<>();
            jvmOptions.add(jvmOption);

            algorithmParamRequest.setJvmOptions(jvmOptions);

            // HpcParameter
            HpcParameter hpcParameter = new HpcParameter();
            hpcParameter.setKey("wallTime");
            hpcParameter.setValue("1");

            //HpcParameterService hpcParamService = new HpcParameterService(session);
            //hpcParamService.add(hpcParameter);
            List<HpcParameter> hpcParameters = new ArrayList<>();
            hpcParameters.add(hpcParameter);

            algorithmParamRequest.setHpcParameters(hpcParameters);

            AlgorithmParamRequestService algorParamReqService = new AlgorithmParamRequestService(session);

            algorParamReqService.add(algorithmParamRequest);

            //JobInfo
            String algorithmName = "GFCI";
            HpcJobInfo jobInfo = new HpcJobInfo();
            jobInfo.setAlgorithmName(algorithmName);
            jobInfo.setSubmittedTime(new Date(System.currentTimeMillis()));
            jobInfo.setAlgorithmParamRequest(algorithmParamRequest);
            jobInfo.setHpcAccount(hpcAccount);
            jobInfo.setStatus(0);

            HpcJobInfoService jobInfoService = new HpcJobInfoService(session);

            jobInfoService.add(jobInfo);

            jobInfoService.remove(jobInfo);

            // Remove ComputingAccount
            hpcAccountService.remove(hpcAccount);

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
