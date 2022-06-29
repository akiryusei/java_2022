package test01;

public class Course {
    private String id;
    private String name;
    private double credit;

    public Course(String id, String name,double credit)
    {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }

    @Override
    public String toString()
    {
        return id+": " +name + ", "+credit;
    }

    //public print
}
