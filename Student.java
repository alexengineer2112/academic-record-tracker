

public class Student extends Person {

    // private String name;
    // private int age;
    private int marks;

    public Student(String name,int age,int marks)
    {
        this.name = name;
        this.age = age;
        setMarks(marks);
    }

    // public String getName() { return name; }
    // public int getAge() { return age; }
    public int getMarks() { return marks; }

    // public void setName(String name)
    // {
    //     this.name = name;
    // }

    // public void setAge(int age)
    // {
    //     if(age<0 || age>25){
    //         System.out.println("Inavalide Age ");
    //         return;
    //     }
    //     this.age = age;
    // }

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
        System.out.println("Name"+name+"Age"+age+"Marks"+getMarks());
    }
}