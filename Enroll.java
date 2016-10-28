import java.io.*;
import java.util.*;

public class Enroll {
  public static int Register(List<Student> l){
    Student a = new Student();
    Scanner sc = new Scanner(System.in);
    //String ans;
   // System.out.println(l.get(1).getStudentNum());
    System.out.println("STUDENT INFORMATION SYSTEM");
    System.out.println("Enter Student Number: ");
    a.setStudentNum(sc.nextLine());
    if(isEqual(a.getStudentNum(),l) == true){
      System.out.println("Student already exists!");
    }
    System.out.println("Enter First Name: ");
    a.setFname(sc.nextLine());
    System.out.println("Enter Middle Initial: ");
    a.setMidInitial(sc.nextLine().charAt(0));
    System.out.println("Enter Last Name: ");
    a.setLname(sc.nextLine());
    System.out.println("Enter Course: ");
    a.setCourse(sc.nextLine());
    System.out.println("Enter Year Level: ");
    a.setYearLevel(sc.nextInt());
    l.add(a);
    System.out.println("Student added!");
    return 0;
  }
  
  public static void Retrieve(List<Student> l){
    Scanner sc = new Scanner(System.in);
    System.out.println("Search student: ");
    boolean i = isEqual(sc.next(), l);
    if(i == false) System.out.println("Student does not exist");
    else{
      System.out.println((Student)l.get(1));
    }
  }

  public static void Delete(List<Student> l){
    Scanner sc = new Scanner(System.in);
    System.out.println("Remove student: ");
    boolean i = isEqual(sc.next(), l);
    if(i == false) System.out.println("Student does not exist");
    else{
      System.out.println("Search Student: " + l.get(1).getStudentNum());
      l.remove(1);
    }
  }
  
  public static void Save(List<Student> l){
    try {

            File file = new File("C:/Users/hp/Documents/student database/student database.txt");
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Student stud : l) {
              bw.write(stud.getStudentNum());
              bw.newLine();
              bw.write(stud.getFname());
              bw.newLine();
              bw.write(stud.getMidInitial());
              bw.newLine();
              bw.write(stud.getLname());
              bw.newLine();
              bw.write(stud.getCourse());
              bw.newLine();
              bw.write(stud.getYearLevel());
              bw.newLine();
            }
            
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
  }
  
  public static void Search(String s, List<Student> l) {
      if(isEqual(s,l) == true) {
          //
      }
  }
  
  public static boolean isEqual(String s, List<Student> l) {
    for (Student stud : l) {
      if(stud.getStudentNum().equals(s)){
        return true;
      }
    }
    return false;
  }
  
  public static void main(String[] args) {
        BufferedReader br = null;
        int ctr = 1;
        List<Student> myList = new ArrayList<Student>();
        Student a = new Student();
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("C:/Users/hp/Documents/student database/student database.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
              
              //System.out.println(sCurrentLine);
              if(ctr%6 == 1) a.setStudentNum(sCurrentLine);  
              if(ctr%6 == 2) a.setFname(sCurrentLine);
              if(ctr%6 == 3) a.setMidInitial(sCurrentLine.charAt(0));
              if(ctr%6 == 4) a.setLname(sCurrentLine);
              if(ctr%6 == 5) a.setCourse(sCurrentLine);
              if(ctr%6 == 0) a.setYearLevel(Integer.parseInt(sCurrentLine));
              ctr++;
              if(ctr > 1 && ctr % 6 == 1){
                myList.add(a);
                a = new Student();
              }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        Scanner sc = new Scanner(System.in);
  
        int choice, x=1;
    
        while(x==1) {
            System.out.println("----------------");
            System.out.println("|   MAIN MENU   |");
            System.out.println("|---------------|");
            System.out.println("| [1] Register  |");
            System.out.println("| [2] Retrieve  |");
            System.out.println("| [3] Delete    |");
            System.out.println("| [4] Save     |");          
            System.out.println("| [5] Search    |");
            System.out.println("| [6] Exit      |");
            do{
                System.out.println("Enter number of choice: ");
                choice = sc.nextInt();
                if(choice <1 || choice > 6) 
                    System.out.println("INVALID INPUT!");

          }while(choice < 1 || choice > 6);
          switch (choice){
          case 1:
            Register(myList);
            break;
          case 2:
            if(myList.isEmpty() == true) {
             //   throw new IllegalArgumentException("There are still no students enrolled!");
                }
            Retrieve(myList);
            break;
          case 3:
            if(myList.isEmpty() == true) {
             //   throw new IllegalArgumentException("There are still no students enrolled!");
               }
            Delete(myList);
            break;
          case 4:
            if(myList.isEmpty() == true) {
              //   throw new IllegalArgumentException("There are still no students enrolled!");
               } 
            Save(myList);
            break;
          case 5:
            if(myList.isEmpty() == true) {
            //   throw new IllegalArgumentException("There are still no students enrolled!");
               }
          //  Search(myList);
            break;
          case 6:
            System.out.println("Goodbye!");
            break;
           }
        }
    }     
}