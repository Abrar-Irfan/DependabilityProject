package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    @Test
    void testTeacherMathStrict() {
        Teacher t0 = new Teacher("T0", "Base", "Math", 0);
        assertEquals(50000, t0.calculateSalary(0));
        Teacher t5 = new Teacher("T5", "Five", "Math", 5);
        assertEquals(75000, t5.calculateSalary(5));
    }

    @Test
    void testTeacherFields() {
        Teacher t = new Teacher("ID", "Name", "Dept", 10);
        assertEquals("ID", t.getId());
    }

    @Test
    void testStudentFields() {
        Student s = new Student("S1", "First", "Last", 2022, "CSE");
        assertEquals("S1", s.getId());
    }

    @Test
    void testStudentEmptyConstructor() {
        Student s = new Student();
        assertNull(s.getId());
    }

    @Test
    void testAddAndRetrieveStudentStrict() {
        SchoolService service = new SchoolService();
        Student s = new Student("S1", "Alice", "Smith", 2023, "Bio");

        String response = service.addStudent(s);
        // UPDATE THIS LINE:
        assertEquals("Student added successfully", response);

        Student retrieved = service.getStudentById("S1");
        assertNotNull(retrieved);
        assertEquals("Alice", retrieved.getFirstName());
    }

    @Test
    void testAddAndRetrieveTeacherStrict() {
        SchoolService service = new SchoolService();
        Teacher t = new Teacher("T1", "Bob", "Physics", 2);

        String response = service.addTeacher(t);
        // UPDATE THIS LINE:
        assertEquals("Teacher added successfully", response);

        int salary = service.getTeacherSalary("T1");
        assertEquals(60000, salary);
    }

    @Test
    void testEdgeCases() {
        SchoolService service = new SchoolService();
        Student badStudent = new Student(null, "No", "ID", 0, "N/A");
        assertEquals("Error: ID cannot be null", service.addStudent(badStudent));

        Teacher badTeacher = new Teacher(null, "No", "ID", 0);
        assertEquals("Error: ID cannot be null", service.addTeacher(badTeacher));
    }
}