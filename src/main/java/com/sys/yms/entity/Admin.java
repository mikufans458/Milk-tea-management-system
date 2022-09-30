package com.sys.yms.entity;

import java.io.Serializable;

public class Admin implements Serializable {
    Integer aId;
    String aAccount;
    String aPwd;
    String aHeadphoto;
    String aName;
    String aPhone;
    String aGender;
    Integer aAge;

    public Admin(Integer aId, String aAccount, String aPwd, String aHeadphoto, String aName, String aPhone, String aGender, Integer aAge) {
        this.aId = aId;
        this.aAccount = aAccount;
        this.aPwd = aPwd;
        this.aHeadphoto = aHeadphoto;
        this.aName = aName;
        this.aPhone = aPhone;
        this.aGender = aGender;
        this.aAge = aAge;
    }

    public Admin() {
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaAccount() {
        return aAccount;
    }

    public void setaAccount(String aAccount) {
        this.aAccount = aAccount;
    }

    public String getaPwd() {
        return aPwd;
    }

    public void setaPwd(String aPwd) {
        this.aPwd = aPwd;
    }

    public String getaHeadphoto() {
        return aHeadphoto;
    }

    public void setaHeadphoto(String aHeadphoto) {
        this.aHeadphoto = aHeadphoto;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone;
    }

    public String getaGender() {
        return aGender;
    }

    public void setaGender(String aGender) {
        this.aGender = aGender;
    }

    public Integer getaAge() {
        return aAge;
    }

    public void setaAge(Integer aAge) {
        this.aAge = aAge;
    }

    @Override
    public String toString() {
        return "admin{" +
                "aId=" + aId +
                ", aAccount='" + aAccount + '\'' +
                ", aPwd='" + aPwd + '\'' +
                ", aHeadphoto='" + aHeadphoto + '\'' +
                ", aName='" + aName + '\'' +
                ", aPhone='" + aPhone + '\'' +
                ", aGender='" + aGender + '\'' +
                ", aAge=" + aAge +
                '}';
    }
}
