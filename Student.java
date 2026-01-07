

public class Student extends Person {

    private int id;
    private int marks;

    public Student(int id,String name,int age,int marks)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        setMarks(marks);
    }

    public int getId() {return id;}
    public int getMarks() { return marks; }

   

    public void setMarks(int marks)
    {
        if(marks<0 || marks>100)
        {
            System.out.println("Invalid Marks ");
            return;
        }
        this.marks=marks;
    }

    @Override
    public void display()
    {
        System.out.println("ID: "+id+
                           "| Name "+name+
                           "| Age "+age+
                           "| Marks"+getMarks()
                          );
    }
}