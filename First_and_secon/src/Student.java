import java.util.Date;

public class Student
{
    private int id;
    private String surname, name, middlename;
    private Date birthDate;
    private float middleScore;

    public StudentsFields getStudentData()//возвращение знаяения полей
    {
        return new StudentsFields(id, surname, name, middlename, birthDate, middleScore);
    }
}
