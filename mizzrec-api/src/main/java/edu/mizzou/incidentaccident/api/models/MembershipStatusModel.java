package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MembershipStatusModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(MembershipStatusModel.class);
    private Integer id;
    private String student;
    private String studentId;
    private String facultyStaff;
    private String alumni;
    private String guest;
    private String tigerXpress;
    private String stopOutStudent;
    private String houseHoldAdult;
    private String other;
    private String otherExplain;

	
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getStudent() {
        return this.student;
    }

    public void setStudent(String student) {
        this.student = student;
    }


    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    public String getFacultyStaff() {
        return this.facultyStaff;
    }

    public void setFacultyStaff(String facultyStaff) {
        this.facultyStaff = facultyStaff;
    }


    public String getAlumni() {
        return this.alumni;
    }

    public void setAlumni(String alumni) {
        this.alumni = alumni;
    }


    public String getGuest() {
        return this.guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }


    public String getTigerXpress() {
        return this.tigerXpress;
    }

    public void setTigerXpress(String tigerXpress) {
        this.tigerXpress = tigerXpress;
    }


    public String getStopOutStudent() {
        return this.stopOutStudent;
    }

    public void setStopOutStudent(String stopOutStudent) {
        this.stopOutStudent = stopOutStudent;
    }


    public String getHouseHoldAdult() {
        return this.houseHoldAdult;
    }

    public void setHouseHoldAdult(String houseHoldAdult) {
        this.houseHoldAdult = houseHoldAdult;
    }


    public String getOther() {
        return this.other;
    }

    public void setOther(String other) {
        this.other = other;
    }


    public String getOtherExplain() {
        return this.otherExplain;
    }

    public void setOtherExplain(String otherExplain) {
        this.otherExplain = otherExplain;
    }



	
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                Method getter = this.getClass().getMethod("get"+StringUtils.capitalize(field.getName()), null);
                sb.append(field.getName()+": ");
                sb.append(getter.invoke(this, null)).append("");
            } catch (Exception e) {
                log.error("Exception outputting toString: " + e.getMessage(), e);
            }
        }
        return sb.toString();
    }

}
