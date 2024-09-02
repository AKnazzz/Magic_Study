import org.db.students.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StudentTest {

    @Test
    public void testStudentCreation() {
        Student student = new Student();
        student.setSurname("Ivanov");
        student.setName("Ivan");
        student.setCourse("Computer Science");
        student.setCity("Moscow");
        student.setAge(20);

        assertEquals("Ivanov", student.getSurname());
        assertEquals("Ivan", student.getName());
        assertEquals("Computer Science", student.getCourse());
        assertEquals("Moscow", student.getCity());
        assertEquals(20, student.getAge());
    }

    @Test
    public void testToString() {
        Student student = new Student();
        student.setSurname("Ivanov");
        student.setName("Ivan");
        student.setCourse("Computer Science");
        student.setCity("Moscow");
        student.setAge(20);

        String expected = "Student Details:\n" +
                "-----------------------------\n" +
                "Фамилия: Ivanov\n" +
                "Имя: Ivan\n" +
                "Курс: Computer Science\n" +
                "Город: Moscow\n" +
                "Возраст: 20\n";
        assertEquals(expected, student.toString());
    }
}
