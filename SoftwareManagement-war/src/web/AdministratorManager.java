package web;

import dtos.CharacteristicDTO;
import dtos.ConfigurationDTO;
import dtos.CourseDTO;
import dtos.StudentDTO;
import ejbs.CharacteristicBean;
import ejbs.ConfigurationBean;
import ejbs.CourseBean;
import ejbs.StudentBean;
import entities.Subject;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ManagedBean(name = "administratorManager")
@SessionScoped
public class AdministratorManager {
    
    @EJB
    private StudentBean studentBean;
    @EJB
    private CourseBean courseBean;
    @EJB
    private ConfigurationBean configurationBean;
    @EJB
    private CharacteristicBean characteristicBean;
    
    private static final Logger logger = Logger.getLogger("web.AdministratorManager");
    
    private UIComponent component;

    private StudentDTO newStudent;
    private StudentDTO currentStudent;

    private ConfigurationDTO newConfiguration;
    private ConfigurationDTO currentConfiguration;

    private CharacteristicDTO newCharacteristic;
    private CharacteristicDTO currentCharacteristic;

    public AdministratorManager() {
        newStudent= new StudentDTO();
        currentStudent = new StudentDTO();

        newConfiguration = new ConfigurationDTO();
        currentConfiguration = new ConfigurationDTO();

        newCharacteristic = new CharacteristicDTO();
        currentCharacteristic = new CharacteristicDTO();
    }

    /////////////// STUDENTS /////////////////
    public String createStudent() {
        try {
            studentBean.create(newStudent);
            //studentBean.create(new StudentDTO("foo new", "foo", "Foo New", "foonew@ipleiria.pt", 1,null));
            newStudent.clear();
        } catch (EJBException e) {
            FacesExceptionHandler.handleException(e, e.getMessage(), component, logger);
            return "admin_students_create";
        } catch (Exception e) {
            logger.warning("Unexpected error. Try again latter!");
            return "admin_students_create";
        }
        return "index?faces-redirect=true";
    }

    public List<StudentDTO> getAllStudents() {
        try {
            return studentBean.getAll();
        } catch (EJBException e) {
            logger.warning(e.getMessage());
            return null;
        } catch (Exception e) {
            logger.warning("Unexpected error. Try again later!");
            return null;
        }
    }

    public List<Subject> getSubjectsOfStudent() {
        return studentBean.getSubjectsOfStudent(currentStudent.getUsername());
    }

    public String updateStudent() {
        try {
            studentBean.update(currentStudent);
            currentStudent.clear();
            return "index?faces-redirect=true";
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return "admin_students_update";
    }

    public void removeStudent(ActionEvent event) {
        try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("deleteStudentId");
            String id = param.getValue().toString();
            studentBean.remove(id);
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    public String createConfiguration() {
        try {
            configurationBean.create(newConfiguration);
            newConfiguration.clear();
        } catch (EJBException e) {
            FacesExceptionHandler.handleException(e, e.getMessage(), component, logger);
            return "admin_configurations_create";
        } catch (Exception e) {
            logger.warning("Unexpected error. Try again latter!");
            return "admin_configurations_create";
        }
        return "index?faces-redirect=true";
    }

    public List<CharacteristicDTO> getAllCharacteristics(){
        try {
            return characteristicBean.getAll();
        } catch (EJBException e) {
            logger.warning(e.getMessage());
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<ConfigurationDTO> getAllConfigurations(){
        try {
            return configurationBean.getAll();
        } catch (EJBException e) {
            logger.warning(e.getMessage());
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public String updateConfiguration(){
        try {
            configurationBean.update(currentConfiguration);
            currentConfiguration.clear();
            return "index?faces-redirect=true";
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return "admin_configurations_update";
    }

    public void removeConfiguration(ActionEvent event){
        try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("deleteConfigurationId");
            Integer id = (Integer) param.getValue();
            configurationBean.remove(id);
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    public List<CourseDTO> getAllCourses() {
        try {
            return courseBean.getAll();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            return null;
        }
    }
    
    public void removeCourse(ActionEvent event){
        try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("deleteCourseId");
            Integer id = (Integer) param.getValue();
            courseBean.remove(id);
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    public StudentBean getStudentBean() {
        return studentBean;
    }

    public void setStudentBean(StudentBean studentBean) {
        this.studentBean = studentBean;
    }

    public StudentDTO getNewStudent() {
        return newStudent;
    }

    public void setNewStudent(StudentDTO newStudent) {
        this.newStudent = newStudent;
    }

    public StudentDTO getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(StudentDTO currentStudent) {
        this.currentStudent = currentStudent;
    }

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
    }

    public ConfigurationDTO getNewConfiguration() {
        return newConfiguration;
    }

    public void setNewConfiguration(ConfigurationDTO newConfiguration) {
        this.newConfiguration = newConfiguration;
    }

    public ConfigurationDTO getCurrentConfiguration() {
        return currentConfiguration;
    }

    public void setCurrentConfiguration(ConfigurationDTO currentConfiguration) {
        this.currentConfiguration = currentConfiguration;
    }

    public CharacteristicDTO getNewCharacteristic() {
        return newCharacteristic;
    }

    public void setNewCharacteristic(CharacteristicDTO newCharacteristic) {
        this.newCharacteristic = newCharacteristic;
    }

    public CharacteristicDTO getCurrentCharacteristic() {
        return currentCharacteristic;
    }

    public void setCurrentCharacteristic(CharacteristicDTO currentCharacteristic) {
        this.currentCharacteristic = currentCharacteristic;
    }
}
