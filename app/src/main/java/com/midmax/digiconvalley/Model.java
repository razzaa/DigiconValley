package com.midmax.digiconvalley;

import java.io.Serializable;

public class Model implements Serializable {
    private  String Name,Contact,Gender,Age_Group,Fever,Head_Ache,Sour_Throat,Abdominal_Pain,Fatigue,Any_Other_Symtoms,
            High_Blood_Pressure,Diabetes,Allergies;
    int Radio_Button_Id,Spinner_Id;

    public Model(){

    }
    public Model(String name, String contact, String gender, String age_Group, String fever,
                 String head_Ache, String sour_Throat, String abdominal_Pain, String fatigue, String any_Other_Symtoms,
                 String high_Blood_Pressure, String diabetes, String allergies, int radio_Button_Id, int spinner_Id) {
        Name = name;
        Contact = contact;
        Gender = gender;
        Age_Group = age_Group;
        Fever = fever;
        Head_Ache = head_Ache;
        Sour_Throat = sour_Throat;
        Abdominal_Pain = abdominal_Pain;
        Fatigue = fatigue;
        Any_Other_Symtoms = any_Other_Symtoms;
        High_Blood_Pressure = high_Blood_Pressure;
        Diabetes = diabetes;
        Allergies = allergies;
        Radio_Button_Id = radio_Button_Id;
        Spinner_Id = spinner_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAge_Group() {
        return Age_Group;
    }

    public void setAge_Group(String age_Group) {
        Age_Group = age_Group;
    }

    public String getFever() {
        return Fever;
    }

    public void setFever(String fever) {
        Fever = fever;
    }

    public String getHead_Ache() {
        return Head_Ache;
    }

    public void setHead_Ache(String head_Ache) {
        Head_Ache = head_Ache;
    }

    public String getSour_Throat() {
        return Sour_Throat;
    }

    public void setSour_Throat(String sour_Throat) {
        Sour_Throat = sour_Throat;
    }

    public String getAbdominal_Pain() {
        return Abdominal_Pain;
    }

    public void setAbdominal_Pain(String abdominal_Pain) {
        Abdominal_Pain = abdominal_Pain;
    }

    public String getFatigue() {
        return Fatigue;
    }

    public void setFatigue(String fatigue) {
        Fatigue = fatigue;
    }

    public String getAny_Other_Symtoms() {
        return Any_Other_Symtoms;
    }

    public void setAny_Other_Symtoms(String any_Other_Symtoms) {
        Any_Other_Symtoms = any_Other_Symtoms;
    }

    public String getHigh_Blood_Pressure() {
        return High_Blood_Pressure;
    }

    public void setHigh_Blood_Pressure(String high_Blood_Pressure) {
        High_Blood_Pressure = high_Blood_Pressure;
    }

    public String getDiabetes() {
        return Diabetes;
    }

    public void setDiabetes(String diabetes) {
        Diabetes = diabetes;
    }

    public String getAllergies() {
        return Allergies;
    }

    public void setAllergies(String allergies) {
        Allergies = allergies;
    }

    public int getRadio_Button_Id() {
        return Radio_Button_Id;
    }

    public void setRadio_Button_Id(int radio_Button_Id) {
        Radio_Button_Id = radio_Button_Id;
    }

    public int getSpinner_Id() {
        return Spinner_Id;
    }

    public void setSpinner_Id(int spinner_Id) {
        Spinner_Id = spinner_Id;
    }
}
