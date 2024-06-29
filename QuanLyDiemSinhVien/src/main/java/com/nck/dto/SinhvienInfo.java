/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.dto;

/**
 *
 * @author chanh
 */
public class SinhvienInfo {
     private Long studentId;
    private String studentName;
    private String courseName;
    private Double midtermScore;
    private Double finalScore;

    /**
     * @return the studentId
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the midtermScore
     */
    public Double getMidtermScore() {
        return midtermScore;
    }

    /**
     * @param midtermScore the midtermScore to set
     */
    public void setMidtermScore(Double midtermScore) {
        this.midtermScore = midtermScore;
    }

    /**
     * @return the finalScore
     */
    public Double getFinalScore() {
        return finalScore;
    }

    /**
     * @param finalScore the finalScore to set
     */
    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }
}
