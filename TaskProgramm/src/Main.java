import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);

        LocalTime now = LocalTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
//        String formattedTime = now.format(formatter);
        if (now.getHour()>=4&&now.getHour()<=10) {
            System.out.println("Кутман тан! Саат -> " + now.getHour()+":"+ now.getMinute());
        }else if (now.getHour()>=11&&now.getHour()<18){
            System.out.println("Кутман күн! Саат -> " + now.getHour()+":"+ now.getMinute());
        }
        else {
            System.out.println("Кутман  кеч! Саат -> " + now.getHour() + ":" + now.getMinute());
        }
            System.out.println("Катталган болсонуз 1 басыныз, пароль унутуп калып, озгорту учун 2 басыныз!");
            int number = scanner.nextInt();
            if (number == 1) {
                systemIn();
                System.out.println("Кош келиниз! ");
                while (true) {
                    System.out.println("""
                            *** Бир команда танданыз! ***
                             1  -> Add new group
                             2  -> Get group by name
                             3  -> Update group name
                             4  -> Get all groups
                             5  -> Add new student to group
                             6  -> Update student
                             7  -> Find student by first name
                             8  -> Get all students by group name
                             9  -> Get all student's lesson
                             10 -> Delete student
                             11 -> Add new lesson to group
                             12 -> Get lesson by name
                             13 -> Get all lesson by group name
                             14 -> Delete lesson
                             15 -> Delete group
                            """);
                    try {
                        int variant = scanner.nextInt();
                        switch (variant) {
                            case 1 -> admin.addNewGroup();
                            case 2 -> admin.getGroupByName();
                            case 3 -> admin.updateGroupByName();
                            case 4 -> admin.getAllGroups();
                            case 5 -> admin.addNewStudentToGroup();
                            case 6 -> admin.updateStudent();
                            case 7 -> admin.findStudentByFirstName();
                            case 8 -> admin.getAllStudentsByGroupName();
                            case 9 -> admin.getAllStudentsLesson();
                            case 10 -> admin.deleteStudent();
                            case 11 -> admin.addNewLessonToGroup();
                            case 12 -> admin.getLessonByName();
                            case 13 -> admin.getAllLessonByGroupName();
                            case 14 -> admin.deleteLesson();
                            case 15 -> admin.deleteGroups();
                            default -> System.out.println("1-15");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Сан жазыныз!");
                    }
                }
            }
    }
    public static void systemIn() {
        Scanner scanner = new Scanner(System.in);
         final  String password="admin";
        System.out.println("Кируу учун электрондук почтанызды жана парольунузду жазыныз!");
        try {
            System.out.print("Электрондук почтанызды жазыныз!: ");
            String emailIn = scanner.nextLine();
            if(!emailIn.contains("@")){
                throw new InputMismatchException("Электрондук почта туура эмес!");
            }
            System.out.print("Пароль жазыныз!");
            String passwordIn = scanner.nextLine();
            if(!Objects.equals(passwordIn, password)) {
                throw new InputMismatchException("Пароль туура эмес!");
            }
        }catch (InputMismatchException e){
            System.out.println("Электрондук почта же праоль туура эмес!");
        }
    }
}