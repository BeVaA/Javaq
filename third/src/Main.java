import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.lang.String;
import java.util.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Student> studentsList = new ArrayList<Student>(5);
        studentsList.add(new Student
                (
                1111,
                "Матвей",
                "Барышев",
                "Александрович",
                new Date(Date.UTC(2005, 12, 1, 0, 0, 0)),
                4.5f
        ));
        studentsList.add(new Student
                (
                1112,
                "Василий",
                "Беляков",
                "Алексеевич",
                new Date(Date.UTC(2002, 02, 12, 0, 0, 0)),
                3.45f
        ));
        studentsList.add(new Student
                (
                1113,
                "Дмитрий",
                "Чеколаев",
                "Алексеевич",
                new Date(Date.UTC(2002, 05, 31, 0, 0, 0)),
                5f
        ));
        studentsList.add(new Student
                (
                1114,
                "Иван",
                "Иванов",
                "Иванович",
                new Date(Date.UTC(2012, 05, 31, 0, 0, 0)),
                4.26f
        ));
        studentsList.add(new Student
                (
                1115,
                "Абрам",
                "Абрамов",
                "Обрамович",
                new Date(2001, 05, 31, 0, 0, 0),
                4.5f
        ));

        System.out.println("Первое задание");
        for(Student el : studentsList)
        {
            el.printData();
        }

        System.out.println("------------------------");

        try{
            studentsList.get(2).setID(9999);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("вылет размер");
        } catch (RuntimeException e) {
            System.out.println(e.toString());
        }finally {
            studentsList.get(2).printData();
        }

        System.out.println("------------------------");

        studentsList.remove(studentsList.size()-1);

        for(Student el : studentsList) {
            el.printData();
        }

        System.out.println("------------------------");

        studentsList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2)
            {
                return o1.getBirthDate().compareTo(o2.getBirthDate());
            }
        });

        for (Student el : studentsList)
        {
            el.printData();
        }

        System.out.println("------------------------");

        studentsList.removeAll(studentsList);

        for (Student el : studentsList)
        {
            el.printData();
        }

        System.out.println("задание 2");

        ArrayDeque<Student> studentAD = new ArrayDeque<Student>();
        studentAD.offer(new Student
                (
                1111,
                "Матвей",
                "Барышев",
                "Александрович",
                new Date(Date.UTC(2001, 12, 1, 0, 0, 0)),
                4.5f
        ));
        studentAD.offer(new Student
                (
                1112,
                "Василий",
                "Беляков",
                "Алексеевич",
                new Date(Date.UTC(2001, 02, 12, 0, 0, 0)),
                3.45f
        ));
        studentAD.offer(new Student
                (
                1113,
                "Дмитрий",
                "Чеколаев",
                "Алексеевич",
                new Date(Date.UTC(2001, 05, 31, 0, 0, 0)),
                5f
        ));
        studentAD.offer(new Student
                (
                1114,
                "Иван",
                "Иванов",
                "Иванович",
                new Date(Date.UTC(2001, 05, 31, 0, 0, 0)),
                4.26f
        ));
        studentAD.offer(new Student
                (
                1115,
                "Абрам",
                "Абрамов",
                "Обрамович",
                new Date(2001, 05, 31, 0, 0, 0),
                4.5f
        ));

        for (Student el : studentAD)
        {
            el.printData();
            System.out.printf("Кол-во записей: %d\n", studentAD.size());
        }

        for (;studentAD.size() != 0;)
        {
            studentAD.poll().printData();
            System.out.printf("Длина очередь: %d\n", studentAD.size());
        }

        System.out.println("задание 3");

        HashMap<String, Float> studentsHM = new HashMap<String, Float>();
        Student st1 = new Student(1111, "Иван", "Грозный",
                "Васильевич", new Date(Date.UTC(2012, 05, 31, 0, 0, 0)), 2.6f);
        Student st2 = new Student(1112, "Пётр", "Первый",
                "Алексеевич", new Date(Date.UTC(2012, 05, 31, 0, 0, 0)), 4.23f);
        Student st3 = new Student(1113, "Egor", "Krukov",
                "Alecseevich", new Date(Date.UTC(2012, 05, 31, 0, 0, 0)), 4.23f);
        studentsHM.put(st1.GetFIO(), st1.GetScore());
        studentsHM.put(st2.GetFIO(), st2.GetScore());
        studentsHM.put(st3.GetFIO(), st3.GetScore());

        printHashMap(studentsHM);

        System.out.println("------------------------");
        printCategorisedStudents(studentsHM);

        System.out.println("------------------------");

        frequencyAnalysis("Но что же делать мне, скажи мой верный друг".toLowerCase().toString());
    }

    static private void frequencyAnalysis(String text) {
        HashMap<Character, Integer> frequencySymbols = new HashMap<Character, Integer>();
        for(char el : text.toCharArray()) {
            if (frequencySymbols.containsKey(el)) {
                frequencySymbols.put(el, frequencySymbols.get(el)+1);
            } else {
                frequencySymbols.put(el, 1);
            }
        }

        System.out.println("Сортировка по ключ.знач\n");

        frequencySymbols.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByKey().reversed())
                .forEach(System.out::println);

        System.out.println("Сортировка по знач\n");

        frequencySymbols.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }

    static private void printCategorisedStudents(HashMap<String, Float> hm)
    {
        ArrayList<String> toOut = new ArrayList<String>();
        ArrayList<String> toNext = new ArrayList<String>();

        for (Map.Entry<String, Float> me : hm.entrySet()) {
            if (me.getValue() < 3) {
                toOut.add(me.getKey());
            } else {
                toNext.add(me.getKey());
            }
        }

        System.out.println("\nКандидаты на отчисление:\n");

        for (String el : toOut)
        {
            System.out.printf("%s\n", el);
        }

        System.out.println("\nКандидаты на перевод:\n");

        for (String el : toNext)
        {
            System.out.printf("%s\n", el);
        }

        System.out.println();
    }

    static private void printHashMap(HashMap<String, Float> hm)
    {
            for(Map.Entry<String, Float> me : hm.entrySet()) {
                System.out.printf("Ключ: %s, Значение: %s\n", me.getKey(), me.getValue().toString());
        }
    }
}