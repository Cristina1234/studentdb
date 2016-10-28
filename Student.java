public class Student extends Enroll {
    private String studentNum;
    private String fname;
    private char midInitial;
    private String lname;
    private String course;
    private int yearLevel;


    public Student(){
    }

    public Student(String studentNum, String fname, char midInitial, String lname, String course, int yearLevel) {
        this.studentNum = studentNum;
        this.fname = fname;
        this.midInitial = midInitial;
        this.lname = lname;
        this.course = course;
        this.yearLevel = yearLevel;
    }
    
    public String getStudentNum() {
        return studentNum;
    }
    
    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public char getMidInitial() {
        return midInitial;
    }

    public void setMidInitial(char midInitial) {
        this.midInitial = midInitial;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }
    
   public String toString() {
       return "Student Number: " + studentNum + "\nName: " + lname + "," + fname + midInitial + "\nProgram: " + course + "\nYear Level: " + yearLevel;
   }
}