
class Student {
    private String name;
    private int age;
    public void setStudentInfo(String name , int age)
    {
        this.name=name;
        this.age = age;
    }
    public String getStudentInfo()
    {
        return "Name : "+name+", Age : "+age;
    }
    
}
public class prac {
    public static void main(String[] args)
    {
        int stuTotal = 0 ; 
        Student[] stus = new Student[99];

        Student stu1 = new Student();
        stu1.setStudentInfo("John",20);
        Student stu2 = new Student();
        stu2.setStudentInfo("Alice", 22);
        Student stu3 = new Student();
        stu3.setStudentInfo("Bob", 21);
        Student stu4 = new Student();
        stu4.setStudentInfo("Eva", 19);

        stus[0] = stu1 ;
        stuTotal++;
        stus[1] = stu2;
        stuTotal++;
        stus[2]=stu3;
        stuTotal++;
        stus[3] =stu4;
        stuTotal++;
        Student newStu = new Student();
        newStu.setStudentInfo("Tola", 18);
        System.out.println("\tOrigin :");
        for (int i = 0; i<stuTotal;i++)
        {
            System.out.println(stus[i].getStudentInfo());
        }
        //1
        // for (int i = 0;i< stuTotal;i++)
        // {
        //     if (stus[i].getStudentInfo().equals("Name : Bob, Age : 21"))
        //     {
        //         stus[i] = newStu;
        //     }
        // }
        //2
        // for(int i = stuTotal-1 ; i >= 0 ;i--)
        // {
        //     stus[i+1]=stus[i];
            
        // }
        // stus[0]=newStu;
        // stuTotal++;
        //3
        // System.out.println("\tAfter deleted");
        // for (int i = 0;i< stuTotal;i++)
        // {
        //     if (stus[i].getStudentInfo().equals("Name : Alice, Age : 22"))
        //     {
        //         stus[i] =stus[i+1] ;
        //         stus[i+1]=stus[i+2];
        //         stuTotal--;
        //     }
        // }
        //4
        int index = 2;
        for (int i = stuTotal - 1; i >= index; i--) {
            stus[i + 1] = stus[i];
        }

        // insert
        stus[index] = newStu;
        stuTotal++;
        
        
        for (int i = 0; i<stuTotal;i++)
        {
            System.out.println(stus[i].getStudentInfo());
        }
    }
}
