package com.company;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
	Course Calculus = new Course("Calculus 2 ");

    Calculus.addStudent("Hassan");
    Calculus.addStudent("Mohamed");
    Calculus.addStudent("Ali");
    Calculus.dropStudent("Hassan");

        System.out.println("\nStudents in the course " + Calculus.getCourseName() + " are: ");
        for (String s : Calculus.getStudents()) {
            if (Objects.nonNull(s)) {
                System.out.print(s + ", ");
            }
        }
    }
}
 class Course {
   private String courseName;
   private String students[] = new String[100];
   private int numberOfStudents;

    Course (String courseName) {
        this.courseName = courseName;
    }

     public String getCourseName() {
         return courseName;
     }

     public void addStudent(String student) {
         if (student.length() < (numberOfStudents + 1)) {
             students = Arrays.copyOf(students, students.length * 2);
         }
         students[numberOfStudents] = student;
         numberOfStudents++;
         System.out.println("Added student: " + student + " is to the course " + getCourseName());
     }

     public String[] getStudents() {
         return students;
     }

     public int getNumberOfStudents() {
         return numberOfStudents;
     }

     public void dropStudent(String student) {
         for (int i = 0; i < numberOfStudents; i++) {
             if (students[i].equals(student)) {
                 students[i] = null;
                 break;
             }
         }
         System.out.println("\nDropped student: " + student + " has been dropped from " + getCourseName());
     }

     protected void clear() {
         Arrays.fill(students, null);
     }

 }