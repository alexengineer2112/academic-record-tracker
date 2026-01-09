import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n--- Academic Record ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student Marks");            
            System.out.println("4. Delete Student");            
            System.out.println("5. Search Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:
                
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                    try{
                        System.out.print("Enter age: ");
                        int age = sc.nextInt();

                        if(age<0 || age>25){
                            System.out.println("Enter Age btw 0-20");
                            break;
                            }

                        System.out.print("Enter marks: ");
                        int marks = sc.nextInt();

                        if(marks < 0 || marks >100){
                            System.out.println("Enter Marks btw 0-100");
                            break;
                        }

                            Student s = new Student(name, age, marks);
                            StudentDAO.addStudent(s);                          

                        }catch(InputMismatchException e)
                            {
                            System.out.println("Enter integer number only");
                            sc.nextLine();
                            }  

                            break;
                    

                case 2:
                    
                        System.out.println("\n--- All Students ---");
                        ArrayList<Student> list = StudentDAO.getAllStudents();
                        for (Student st : list) {
                            st.display();
                        }
                        break;
                    

                case 3:
                    
                    System.out.print("Enter the id to update: ");
                    int uid = sc.nextInt();

                    System.out.println("Enter new marks: ");
                    int m = sc.nextInt();

                    StudentDAO.updateStudentMarks(uid, m);
                    break;
                

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();

                    StudentDAO.deleteStudent(did);
                    break;


                case 5:
                    
                    System.out.print("Enter ID: ");
                    int sid = sc.nextInt();

                    Student found = StudentDAO.getStudentById(sid);
                    if (found != null)
                        System.out.println(found.getId() + " | " + found.name + " | " + found.getMarks());
                    else
                        System.out.println("Student not found");
                    break;
                    

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } 
    }
}
