import java.util.Date;

public class Student
{
    private int id;
    private String name, surname, middlename;
    private Date birthDate;
    private float averScore;

    Student(int id, String name, String surname, String middlename, Date birthDate, float middleScore)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.birthDate = birthDate;
        this.averScore = middleScore;
    }
    public Fields getStudentData()
    {
        return new Fields(id, name, surname, middlename, birthDate, averScore);
    }
    public String GetFIO() {
        String res = this.name + " " + this.surname + " " + this.middlename;
        return res;
    }

    public Float GetScore()
    {
        return this.averScore;
    }

    public Date getBirthDate()
    {
        return this.birthDate;
    }

    public void printData(){
        System.out.printf("ID: %s\nName: %s\nSurname: %s\nMiddlename: %s\nBirth Date: %s\nMiddle Score: %s\n\n",
                id, name, surname, middlename, birthDate.toString(), averScore);
    }

    public void setID(int id)
    {
        if (id < 1000 || id >= 9999)
        {

            throw new RuntimeException("Неверный номер id");
        }
        this.id = id;
    }
}
