package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    // --- 1. Teacher Logic (Math & Fields) ---
    @Test
    void testTeacherMathStrict() {
        // Base case (0 courses)
        Teacher t0 = new Teacher("T0", "Base", "Math", 0);
        assertEquals(50000, t0.calculateSalary(0), "Base salary should be 50,000");

        // Single course case (1 course) - Kills "Off by one" mutants
        Teacher t1 = new Teacher("T1", "One", "Math", 1);
        assertEquals(55000, t1.calculateSalary(1), "1 course should add 5,000");

        // Multiple courses
        Teacher t5 = new Teacher("T5", "Five", "Math", 5);
        assertEquals(75000, t5.calculateSalary(5));
    }

    @Test
    void testTeacherFields() {
        // This kills mutants that might delete constructor lines
        Teacher t = new Teacher("ID", "Name", "Dept", 10);
        assertEquals("ID", t.getId());
        assertEquals("Name", t.getName());
        assertEquals("Dept", t.getDepartment());
        assertEquals(10, t.getCourseCount());
    }

    // --- 2. Student Logic (Fields) ---
    @Test
    void testStudentFields() {
        Student s = new Student("S1", "First", "Last", 2022, "CSE");
        assertEquals("S1", s.getId());
        assertEquals("First", s.getFirstName());
        assertEquals("Last", s.getLastName());
        assertEquals(2022, s.getYear());
        assertEquals("CSE", s.getProgramme());
    }

    @Test
    void testStudentEmptyConstructor() {
        // Kills mutants that mess with default constructors
        Student s = new Student();
        assertNull(s.getId());
    }

    // --- 3. Service Logic (Integrity) ---
    @Test
    void testAddAndRetrieveStudentStrict() {
        SchoolService service = new SchoolService();
        Student s = new Student("S1", "Alice", "Smith", 2023, "Bio");

        // 1. Check Return Message
        String response = service.addStudent(s);
        assertEquals("Student added: Alice", response);

        // 2. Check Retrieval by ID
        Student retrieved = service.getStudentById("S1");
        assertNotNull(retrieved, "Student should exist in map");
        assertEquals("Alice", retrieved.getFirstName(), "Name should match exactly");

        // 3. Check Retrieval via List
        List<Student> all = service.getAllStudents();
        assertEquals(1, all.size());
        assertEquals("S1", all.get(0).getId());
    }

    @Test
    void testAddAndRetrieveTeacherStrict() {
        SchoolService service = new SchoolService();
        Teacher t = new Teacher("T1", "Bob", "Physics", 2);

        // 1. Check Add
        String response = service.addTeacher(t);
        assertEquals("Teacher added: Bob", response);

        // 2. Check Salary Calculation through Service
        // This ensures the service is actually calling the teacher's math method
        int salary = service.getTeacherSalary("T1");
        assertEquals(60000, salary); // 50k + 10k

        // 3. Check List
        List<Teacher> all = service.getAllTeachers();
        assertEquals(1, all.size());
    }

    @Test
    void testEdgeCases() {
        SchoolService service = new SchoolService();

        // Null ID Checks
        Student badStudent = new Student(null, "No", "ID", 0, "N/A");
        assertEquals("Error: ID cannot be null", service.addStudent(badStudent));

        Teacher badTeacher = new Teacher(null, "No", "ID", 0);
        assertEquals("Error: ID cannot be null", service.addTeacher(badTeacher));

        // Missing Data Check
        assertNull(service.getStudentById("GHOST"));
        assertEquals(0, service.getTeacherSalary("GHOST"));
    }
}