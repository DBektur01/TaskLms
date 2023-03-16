import java.util.*;

public class Admin implements  InputInterface {
    private Map<String, List<Student>> groups = new HashMap<>();
    private Map<String, Lesson> lessons = new HashMap<>();
    Student student = new Student();
    Lesson lesson = new Lesson();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void addNewGroup() {
        System.out.print("Жаны группага ат жазыныз: ");
        String groupName = scanner.nextLine();
        if (!groups.containsKey(groupName)) {
            groups.put(groupName, new ArrayList<Student>());
            System.out.print("Группанын сүрөттөмөсүн жазыныз: ");
            String description = scanner.nextLine();
            byte id = 1;
            Group group = new Group(id, groupName, description);

            System.out.println(group + "\n" + groupName + " атту группа ийгиликтүү сакталды ! ");
        } else {
            System.out.println(groupName + " мындай ат менен группа бар!");
        }


    }

    @Override
    public void getGroupByName() {
        System.out.print("Группанын атын жазыныз: ");
        String groupName = scanner.nextLine();
        if (groups.containsKey(groupName)) {
            List<Student> students = groups.get(groupName);
            System.out.println(groupName + ":");
            for (Student student : students) {
                System.out.println(" группадагы студенттер: " + student);
            }
        } else {
            System.out.println(groupName + " мындай ат менен группа табылган жок ");
        }
    }

    @Override
    public void updateGroupByName() {
        System.out.println("Группанын атын жазыныз:");
        String groupName = scanner.nextLine();
        System.out.println("Группага жаны ат жазыныз:");
        String newGroupName = scanner.nextLine();
        if (groups.containsKey(groupName)) {
            List<Student> students = groups.remove(groupName);
            groups.put(newGroupName, students);
            System.out.println(groupName + "Группанын аты " + newGroupName + " өзгөрүлдүү ");
        } else {
            System.out.println(groupName + " мындай ат менен группа табылган жок ");
        }
    }

    @Override
    public void getAllGroups() {
        System.out.println("Группанын тизмеси:");
        for (String groupName : groups.keySet()) {
            System.out.println(groupName);
        }
    }

    @Override
    public void addNewStudentToGroup() {
        ArrayList<Student>students=new ArrayList<>();
        System.out.print("Кайсы группага студент кошосуз, ошол группанын атын жазыныз: ");
        String groupName = scanner.nextLine();
        System.out.print("Студенттин аты жазыныз: ");
        String firstName = scanner.nextLine();
        System.out.print("Фамилиясын жазыныз: ");
        String lastName = scanner.nextLine();
        System.out.print("Электрондук почтасын жазыныз: ");
        try {
            String email = scanner.nextLine();
            if (!email.contains("@")) {
                throw new InputMismatchException("Электрондук почта туура эмес ");
            }
            System.out.print("Пароль ойлоп табыныз (узундугу 7 символдон аз болбосун) ");
            String password = scanner.nextLine();
            if (password.length() < 7) {
                throw new InputMismatchException("Парольдун узунду 7 символдон аз болбосун!");
            }
            System.out.print("Жынысын жазыныз (male/female): ");
            String gender = scanner.nextLine();
            if (groups.containsKey(groupName)) {
                List<Student> students1 = groups.get(groupName);
                if (!students1.contains(student)) {
                    students.add(student);
                    System.out.println(" Жаны студент ийгиликтүү  кошулду!");
                } else {
                    System.out.println("Студент: " + student + "\n" + groupName + "  группасында бар");
                }
            } else {
                System.out.println(groupName + " мындай ат менен группа табылган жок ");
                Student student1 = new Student(firstName, lastName, email, password, gender);
            }
        } catch (InputMismatchException e) {
            System.out.println("Электрондук почта туура эмес! ");
        }
    }



    @Override
    public void updateStudent() {


    }

    @Override
    public void findStudentByFirstName() {
        System.out.print("Студенттин аттын жазыныз: ");
        String firstName=scanner.nextLine();
        System.out.println("жыйынтык : " + firstName);
        for (List<Student> students : groups.values()) {
            for (Student student : students) {
                if (student.getFirstName().equals(firstName)) {
                    System.out.println(student);
                }
            }
        }
    }
    @Override
    public void getAllStudentsByGroupName() {
        System.out.print("Группаынын атын жазыныз: ");
        String groupName=scanner.nextLine();
        if(groups.containsKey(groupName)) {
            List<Student> students = groups.get(groupName);
            System.out.println("Группадагы стунденттер " + groupName + ":");
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println(  groupName + " мындай ат менен группа табылган жок ");
        }
    }

    @Override
    public void getAllStudentsLesson() {

    }

    @Override
    public void deleteStudent() {


    }

    @Override
    public void addNewLessonToGroup() {

    }

    @Override
    public void getLessonByName() {

    }

    @Override
    public void getAllLessonByGroupName() {

    }

    @Override
    public void deleteLesson() {

    }

    @Override
    public void deleteGroups() {

    }
}
