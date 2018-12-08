package ejbs;

import entities.Property;
import enums.ConfigurationState;
import org.json.simple.JSONObject;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;


@Singleton
@Startup
public class ConfigBean {

    @EJB
    private CourseBean courseBean;
    
    @EJB
    private StudentBean studentBean;

    @EJB
    private TeacherBean teacherBean;
    
    @EJB
    private SubjectBean subjectBean;

    @EJB
    private CharacteristicBean characteristicBean;

    @EJB
    private ConfigurationBean configurationBean;
    
    @PostConstruct
    public void populateBD() {

        try {
            JSONObject repositoryJSON = new JSONObject();
            repositoryJSON.put("SourceCodeURL","www.git.com");
            repositoryJSON.put("DataBaseURL","www.mysql.com");
            repositoryJSON.put("LibrariesURL","www.maven.com");
            characteristicBean.create("Repositories",repositoryJSON.toJSONString());

            JSONObject hardwareJSON = new JSONObject();
            hardwareJSON.put("CPU","Intel 3.5Ghz");
            hardwareJSON.put("RAM","64Gb 1500Mhz");
            characteristicBean.create("Hardware",hardwareJSON.toJSONString());

            JSONObject license1JSON = new JSONObject();
            license1JSON.put("Code","1337-420-360-N05C0P3");
            license1JSON.put("ExpirationDate","15 September 2045");
            characteristicBean.create("License 2045",license1JSON.toJSONString());

            JSONObject license2JSON = new JSONObject();
            license2JSON.put("Code","91857249526176-1524-UFMEOK");
            license2JSON.put("ExpirationDate","25 NOV 2015");
            license2JSON.put("Company","Sun Microsystems");
            characteristicBean.create("License SunMicro",license2JSON.toJSONString());

            configurationBean.create("javaEE2015Config","Some modern config", ConfigurationState.ACTIVE,"Java EE Developer");
            configurationBean.create("java95","An old config", ConfigurationState.SUSPENDED,"Java EE 1997 Proto");
            configurationBean.addCharacteristicToConfiguration("javaEE2015Config","Repositories");
            configurationBean.addCharacteristicToConfiguration("javaEE2015Config","Hardware");
            configurationBean.addCharacteristicToConfiguration("javaEE2015Config","License 2045");
            configurationBean.addCharacteristicToConfiguration("java95","License SunMicro");

            /*
            courseBean.create(1, "EI");            
            courseBean.create(2, "IS");
            courseBean.create(3, "JDM");
            courseBean.create(4, "SIS");
            courseBean.create(5, "MEI-CM");
            courseBean.create(6, "MGSIM");
            
            subjectBean.create(1, "DAE", 1, "2018/19", "2018/19");

            studentBean.create("foo", "foo", "Foo", "foo@ipleiria.pt", 1);
            studentBean.create("bar", "bar", "Bar", "bar@ipleiria.pt", 1);
            
            studentBean.enrollStudentInSubject("foo", 1);
            */

        } catch (Exception e) {
            System.err.println("[ERROR] @ Application bootstrap | Cause: " + e.getMessage());
        }
    }
}
