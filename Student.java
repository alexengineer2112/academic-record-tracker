

public class Student extends Person {

    private int id;
    private int marks;

    public Student(int id,String name,int age,int marks)
    {
        this.id = id;
        this.name = name;
        setAge(age);
        setMarks(marks);
    }

    public Student(String name, int age,int marks)
    {
        this.name = name;
        setAge(age);
        setMarks(marks);
    }

    public int getId() {return id;}
    public int getAge() {return age;}
    public int getMarks() { return marks; }

    public void setAge(int age)
    {
        if(age < 0 || age > 25)
        {
            System.out.println("Invalid Age ");
            return;
        }
        this.age = age;
    }

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