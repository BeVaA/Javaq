import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collection;

public class Main
{
    public static void main(String[] args)
    {
        Vector v1 = new Vector(1, 1, 1);
        v1.scalar(0, 0, 0);

        for (int i =3; i > 0; i--)
        {
            Scanner sc = new Scanner(System.in);
            String pin = sc.next();
            if (pin == "98765")
            {
                System.out.println("Пин код корректен");
                break;
            } else// выбрасываем исключение
            {
                try
                {
                    throw new PINCodeExeption(pin, i);
                } catch (PINCodeExeption e)
                {
                    Error err = new Error(e.getMessage());
                    System.out.println(err.Err);
                }
            }
        }
    }
}