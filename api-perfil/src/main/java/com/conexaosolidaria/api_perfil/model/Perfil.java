package com.conexaosolidaria.api_perfil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    private String nickname;

    @NotBlank
    @Size(max = 5)
    @Pattern(
            regexp = "^(A\\+|A-|B\\+|B-|AB\\+|AB-|O\\+|O-)$",
            message = "Tipo sanguíneo deve ser um dos seguintes: A+, A-, B+, B-, AB+, AB-, O+, O-"
    )
    @Column(name = "blood_type")
    private String bloodType;

    private String allergies;

    @Size(max = 200)
    @Column(name = "medical_conditions")
    private String medicalConditions;

    @Size(max = 200)
    @Column(name = "continuous_medication")
    private String continuousMedication;

    private String observations;

    @Column(name = "avatar_uri")
    private String avatarUrl;

    @Column(name = "emergency_contact_name")
    private String emergencyContactName;

    @Column(name = "emergency_contact_phone")
    private String emergencyContactPhone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public String getContinuousMedication() {
        return continuousMedication;
    }

    public void setContinuousMedication(String continuousMedication) {
        this.continuousMedication = continuousMedication;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }
}
