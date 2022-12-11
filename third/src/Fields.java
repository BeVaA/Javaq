import java.util.Date;

public class Fields
{

    public int id;
    public String name, surname, middlename;
    public Date birthDate;
    public float averScore;
    Fields(int id, String name, String surname, String middlename, Date birthDate, float averScore)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.birthDate = birthDate;
        this.averScore = averScore;
    }
}
