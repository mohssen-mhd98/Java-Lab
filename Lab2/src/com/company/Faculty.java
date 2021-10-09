package com.company;

/**
 * The Faculty class represents a computer engineering major in AUT
 * It holds the Faculty details
 */
public class Faculty {

    // the students list of faculty
    private Student[] students;

    // the labs exists in faculty
    private Lab[] labs;

    // the manager name of faculty
    private String managerName;

    // the deputy name of faculty
    private String deputyName;

    // number of educational office
    private String officeNumber;

    public Faculty(String managerName, String deputyName, String officeNumber, Lab[] labs, Student[] students) {
        this.managerName = managerName;
        this.deputyName = deputyName;
        this.officeNumber = officeNumber;
        this.labs = labs;
        this.students = students;
    }

    /**
     * get a list of faculty students
     * @return students field
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * @param students set the faculty students list
     */
    public void setStudents(Student[] students) {
        this.students = students;
    }

    /**
     * get the list of faculty labs
     * @return labs field
     */
    public Lab[] getLabs() {
        return labs;
    }

    /**
     * @param labs set the faculty labs
     */
    public void setLabs(Lab[] labs) {
        this.labs = labs;
    }

    /**
     * get the name of faculty manager
     * @return managerName field
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * @param managerName set the manager name
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * get the name of faculty deputy
     * @return deputyName field
     */
    public String getDeputyName() {
        return deputyName;
    }

    /**
     * @param deputyName set the deputy name
     */
    public void setDeputyName(String deputyName) {
        this.deputyName = deputyName;
    }

    /**
     * get the office phone number
     * @return officeNumber field
     */
    public String getOfficeNumber() {
        return officeNumber;
    }

    /**
     * @param officeNumber set the office phone number
     */
    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public void print(){
        for (Student student : students) {
            System.out.println("std fname: " + student.getFirstName()
                    + " std id:" + student.getId()
                    + " std grade:" + student.getGrade());

        }
        for (Lab lab : labs) {
            System.out.println("Day of lab: " + lab.getDay()
                    + " current capacity of lab:" + lab.getCurrentSize()
                    + " total capacity:" + lab.getCapacity());

        }
    }

}
