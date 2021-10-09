package com.company;

public class Run {

    public static void main(String[] args) {

        Student[] students = new Student[5];
        Lab[] labs = new Lab[3];

//        Student std1 = new Student("Ehsan", "Edalat", "9031066");
//        Student std2 = new Student("Seyed", "Ahmadpanah", "9031806");
//        Student std3 = new Student("Ahmad", "Asadi", "9031054");
//        Student std4 = new Student("Kimia", "saeedi", "9831065");
//        Student std5 = new Student("Mohsen", "Mohammadian", "9831502");

        students[0] = new Student("Ehsan", "Edalat", "9031066");
        students[1] = new Student("Seyed", "Ahmadpanah", "9031806");
        students[2] = new Student("Ahmad", "Asadi", "9031054");
        students[3] = new Student("Kimia", "saeedi", "9831065");
        students[4] = new Student("Mohsen", "Mohammadian", "9831502");

        labs[0] = new Lab(20, "Monday");
        labs[1] = new Lab(10, "Saturday");
        labs[2] = new Lab(5, "Thursday");

//        std1.print();
//        std2.print();
//        std3.print();

//        Lab lab = new Lab(20, "Monday");
        labs[0].enrollStudent(students[0]);
        labs[0].enrollStudent(students[1]);
        labs[0].enrollStudent(students[2]);

        labs[0].print();

        Faculty faculty = new Faculty("dr.Zarandi", "dr.Fallah","64542719",
                labs, students);

        faculty.print();

    }
}
