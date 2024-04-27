package classesactivity_1;

/**
 *
 * @author Vanessa
 */
public class Student {

    private String name;
    private String studentNumber;
    private int creditHoursCompleted;
    private double gpa;

    //constructors
    public Student() {
        name = "WSU student";
        studentNumber = "XXXXX";
        creditHoursCompleted = 0;
        gpa = 0;
    }

    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        creditHoursCompleted = 0;
        gpa = 0;
    }

    public Student(String name, String studentNumber, int creditHoursCompleted, double gpa) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.creditHoursCompleted = creditHoursCompleted;
        this.gpa = gpa;
    }
    
    public Student(Student copy){
        this.name = copy.name;
        this.studentNumber = copy.studentNumber;
        this.creditHoursCompleted = copy.creditHoursCompleted;
        this.gpa = copy.gpa;
    }

    //returns stuff
    public String getName() {
        return this.name;
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }

    public int getCreditHoursCompleted() {
        return this.creditHoursCompleted;
    }

    public double getGPA() {
        return this.gpa;
    }

    //sets stuff
    public void setName(String name) {
        this.name = name;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setCreditHoursCompleted(int creditHoursCompleted) {
        this.creditHoursCompleted = creditHoursCompleted;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    //equals method
    public boolean equals(Student otherStudent){
        return (this.name.equals(otherStudent.name) && this.studentNumber.equals(otherStudent.studentNumber) && this.creditHoursCompleted == otherStudent.creditHoursCompleted && this.gpa == otherStudent.gpa);
    }
    
    //toString method
    @Override
    public String toString() {
        return "Name: " + this.name + "\nID number: " + this.studentNumber + "\nCredit Hours: " + this.creditHoursCompleted + "\nGPA: " + this.gpa + "\n";
    }
    
}
