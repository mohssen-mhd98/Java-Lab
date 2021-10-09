package com.company;

/**
 * The Lab class represents a lab course in a education system.
 * It holds the lab details and some student characteristics.
 * @author Mohsen
 * @version 0.0
 */
public class Lab {

    // the students list.
    private Student[] students;

    // the average of student grades.
    private float avg;

    //the day.
    private String day;

    //the capacity of lab.
    private int capacity;

    //number of students in lab for now.
    private int currentSize;

    /**
     * @param cap capacity of lab
     * @param d day in lab
     */
    public Lab(int cap, String d) {
        capacity = cap;
        day = d;
        students = new Student[cap];
        currentSize = 0;
    }

    /**
     * add a new student to list of students registered in this lab.
     * @param std a student object
     */
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        } else {
            System.out.println("Lab is full!!!");
        }
    }

    /**
     * Print the students information and average of their grades.
     */
    public void print() {
        for (int i=0; i<currentSize; i++){
            System.out.println("std fname: " + students[i].getFirstName()
                    + " std id:" + students[i].getId()
                    + " std grade:"+ students[i].getGrade());

        }
        calculateAvg();
        System.out.println("Lab AVG:" + avg);
    }

    /**
     * get the list of student objects
     * @return students filed
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * @param students set the list of students
     */
    public void setStudents(Student[] students) {
        this.students = students;
    }

    /**
     * get the average of student grades
     * @return avg filed
     */
    public float getAvg() {
        return avg;
    }

    /**
     * calculates the average of student grades
     */
    public void calculateAvg() {
        int sum = 0;
        for (int i=0; i<currentSize; i++){
            sum += students[i].getGrade();
        }
        avg = sum/currentSize;
    }

    /**
     * get the day of lab
     * @return day field
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day set the day of lab
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * get the person capacity of lab
     * @return capacity field
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity set the capacity of lab
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * get the currentSize of lab
     * @return currentSize field
     */
    public int getCurrentSize() {
        return currentSize;
    }

    /**
     * @param currentSize set the currentSize of lab
     */
    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }
}

