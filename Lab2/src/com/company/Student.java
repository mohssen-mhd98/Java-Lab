package com.company;
import java.util.Random;

/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * @author Mohsen
 * @version 0.0
 */
public class Student {

    //the student's first name
    private String firstName;

    //the student's last name
    private String lastName;

    //the student ID
    private String id;

    //the grade
    private int grade;

    //an object of class Random
    private Random random = new Random();

    /**
     * @param fName first name of student
     * @param lName last name of student
     * @param sID student ID
     */
    public Student(String fName, String lName, String sID){
        firstName = fName;
        lastName = lName;
        id = sID;
        grade = random.nextInt(20);
    }

    /**
     * get the first name of student
     * @return firstName field
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName set the first name of student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * get the last name of student
     * @return lastName field
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName set the last name of student
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * get the id of student
     * @return id field
     */
    public String getId() {
        return id;
    }

    /**
     * @param id set the ID of student
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * get the grade of student
     * @return grade field
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param grade set the grade of student
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * Print the student's Last name and ID number to the output terminal.
     */
    public void print(){
        System.out.println(lastName + ", student ID " + id + ", grade: " + grade);
    }

}
