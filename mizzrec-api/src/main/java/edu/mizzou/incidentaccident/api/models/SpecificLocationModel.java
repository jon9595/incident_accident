package edu.mizzou.incidentaccident.api.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SpecificLocationModel implements Serializable {

    private static Logger log = LoggerFactory.getLogger(SpecificLocationModel.class);
    private Integer id;
    private boolean specEquipPiece;
    private String specEquipPieceDesc;
    private boolean other;
    private String otherDesc;

	
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public boolean isSpecEquipPiece() {
        return this.specEquipPiece;
    }

    public void setSpecEquipPiece(boolean specEquipPiece) {
        this.specEquipPiece = specEquipPiece;
    }


    public String getSpecEquipPieceDesc() {
        return this.specEquipPieceDesc;
    }

    public void setSpecEquipPieceDesc(String specEquipPieceDesc) {
        this.specEquipPieceDesc = specEquipPieceDesc;
    }


    public boolean isOther() {
        return this.other;
    }

    public void setOther(boolean other) {
        this.other = other;
    }


    public String getOtherDesc() {
        return this.otherDesc;
    }

    public void setOtherDesc(String otherDesc) {
        this.otherDesc = otherDesc;
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
