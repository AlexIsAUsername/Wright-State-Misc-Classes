/**
 *  @author V. Starkey
 *  CS1180, Summer 2020
 *  Classes Activity 1
 */
package classesactivity_1;

import java.util.Scanner;

/**
 * [Project or Lab] #
 * Description
 */
public class ClassesActivity_1 {


    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        String name;
        String idNumber;
        int creditHours;
        double gpa;

        Student student1 = new Student();
        Student student2 = new Student("John", "RealIdNumber152");
        Student student3 = new Student("Cena", "RealIdNumber125", 5, 2.4);
        Student student4 = new Student(student3);
        
        //output information for student1
        System.out.println("Student1:");
        System.out.println(student1);
        
        //output information for student2
        System.out.println("Student2:");
        System.out.println(student2);
        
        //output information for student3
        System.out.println("Student3:");
        System.out.println(student3);
        
        //output information for student4
        System.out.println("Student4:");
        System.out.println(student4);
        System.out.println(student4.equals(student3));
        
    }

}
