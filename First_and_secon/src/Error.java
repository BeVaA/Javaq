import java.lang.Integer;

public class Error
{
    public String Err;
    public boolean Exist;

    Error(String Err)
    {
        if (Err != "")
        {
            this.Err = Err;
            this.Exist = true;
        }
    }
}

class PINCodeExeption extends RuntimeException {
    private String message;
    public PINCodeExeption()
    {
        super();
    }

    public PINCodeExeption(String a, Integer tries) //Проверка корректности введённого пин-кода и количества попыток
    {
            for (int i = 0; i < a.length(); i++)
            {
                if (a.charAt(i) < '0' || a.charAt(i) > '9')
                {
                    this.message = "Неправфильный формат введённого пин-кода";
                    return;
                }
            }
            if (tries-1 > 0)
            {
                this.message = "Ошибка в пин-коде, у вас осталось "+ tries.toString() +" попытки";
            } else {
                this.message = "Вам п.. конец. Попыток больше нет";
            }
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}