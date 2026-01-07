import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Main {

    public static void savetofile(HashMap<Integer,Student> students)
    {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("student.txt"));
        
             for(Student s:students.values())
             {
                bw.write(s.getId() +","+s.name + ","+s.age+","+s.getMarks());
                bw.newLine();
             }

            bw.close();
            System.out.print("Successfully Saved");

            }catch(Exception e){
            System.out.print("Error"+e);
        }
        
    }

    public static int loadfromfile(HashMap<Integer,Student> students)
    {

        int Studentidcounter = 1;

        try{
            BufferedReader br = new BufferedReader(new FileReader("student.txt"));
            students.clear();

            int maxid = 0;
            String line;

            while((line = br.readLine())!=null){

                String[] parts = line.split(",");
                
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                int marks = Integer.parseInt(parts[3]);

                students.put(id,new Student(id,name,age,marks));

                if( id > maxid)
                 {
                    maxid = id;
                    }
            }

            br.close();

            Studentidcounter = maxid +1;

            }catch(FileNotFoundException e){
                System.out.println("File not found");
            } 
            catch(Exception e)
            {
                System.out.print("Error"+ e);
            }

            return Studentidcounter;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Student> students = new HashMap<>();

        int Studentidcounter = 1;


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
                    {
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

                            Student s = new Student(Studentidcounter, name, age, marks);
                            students.put(Studentidcounter,s);
                            Studentidcounter++;

                        }catch(InputMismatchException e)
                            {
                            System.out.println("Enter integer number only");
                            sc.nextLine();
                            }  

                            break;
                    }


                case 2:
                    {
                        System.out.println("\n--- All Students ---");
                        for (Student s : students.values()) {
                            s.display();
                        }
                        break;
                    }

                case 3:
                    
                    System.out.print("Enter the id to delete: ");
                    int id = sc.nextInt();

                    if(students.containsKey(id)) {
                        students.remove(id);
                        System.out.println("Student deleted!");
                    } else {
                        System.out.println("Invalid id!");
                    }
                    break;
                

                case 4:
                    {
                        System.out.print("Enter the id to search: ");
                        int key = sc.nextInt();

                        Student s = students.get(key);

                        if(s != null)
                        {
                            s.display();
                        }else {
                            System.out.println("Student not found");
                        }
                        break;
                    }

                case 5:
                    {
                        List<Student> studentlist = new ArrayList<>(students.values());
                        studentlist.sort((s1, s2) -> s1.getMarks() - s2.getMarks());
                        System.out.println("Sorted by Marks!");

                        for(Student s : studentlist)
                        {
                            s.display();
                        }
                        break;
                    }

                case 6:
                    {
                        List<Student> studentlistbyname = new ArrayList<>(students.values());
                        studentlistbyname.sort((s1, s2) -> s1.name.compareTo(s2.name));
                        System.out.println("Sorted by Name!");

                        for(Student s : studentlistbyname)
                        {
                            s.display();
                        }
                        break;
                    }   

                case 7:
                    savetofile(students);
                    break;

                case 8:
                    Studentidcounter = loadfromfile(students);
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
