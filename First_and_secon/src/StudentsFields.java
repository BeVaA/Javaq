import java.util.Date;

public class StudentsFields
{
    public int id;
    public String surname, name, middlename;
    public Date birthDate;
    public float middleScore;

    StudentsFields(int id, String surname, String name, String middlename, Date birthDate, float middleScore) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.birthDate = birthDate;
        this.middleScore = middleScore;
    }
}
