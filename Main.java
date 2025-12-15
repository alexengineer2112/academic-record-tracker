import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Main {

    public static void savetofile(ArrayList<Student> students)
    {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("student.txt"));
        
             for(Student s:students)
             {
                bw.write(s.name + ","+s.age+","+s.getMarks());
                bw.newLine();
             }
            bw.close();
            System.out.print("Successfully Saved");

            }catch(Exception e){
            System.out.print("Error"+e);
        }
        
    }

    public static void loadtofile(ArrayList<Student> students)
    {
        try{
            BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
            students.clear();
            String line;

            while((line = br.readLine())!=null){
                String[] parts = line.split(",");
                
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                int marks = Integer.parseInt(parts[2]);

                students.add(new Student(name,age,marks));
            }

            br.close();
            System.out.println("Loaded successfully!");

            }catch(FileNotFoundException e){
                System.out.println("File not found");
            } 
            catch(Exception e)
            {
                System.out.print("Error"+ e);
            }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- STUDENT MANAGEMENT ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Sort by Name");
            System.out.println("7. Save Student Details to File");
            System.out.println("8. Load Student Details from File");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
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
                        students.add(new Student(name, age, marks));
                        System.out.println("Student added!");
                        break;

                    }catch(InputMismatchException e)
                        {
                        System.out.println("Enter integer number only");
                        sc.nextLine();
                        break;
                        }  


                case 2:
                    System.out.println("\n--- All Students ---");
                    for (Student s : students) {
                        s.display();
                    }
                    break;

                case 3:
                    System.out.print("Enter index to delete: ");
                    int index = sc.nextInt();
                    if(index >= 0 && index < students.size()) {
                        students.remove(index);
                        System.out.println("Student deleted!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 4:
                    System.out.print("Enter name to search: ");
                    String key = sc.nextLine();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.name.equalsIgnoreCase(key)) {
                            System.out.println("Found: " + s.name + " | " + s.age + " | " + s.getMarks());
                            found = true;
                        }
                    }

                    if (!found) System.out.println("Student not found!");
                    break;

                case 5:
                    students.sort((s1, s2) -> s1.getMarks() - s2.getMarks());
                    System.out.println("Sorted by Marks!");
                    break;

                case 6:
                    students.sort((s1, s2) -> s1.name.compareTo(s2.name));
                    System.out.println("Sorted by Name!");
                    break;

                case 7:
                    savetofile(students);
                    break;

                case 8:
                    loadtofile(students);
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while(choice != 9);

        sc.close();
    }
}
