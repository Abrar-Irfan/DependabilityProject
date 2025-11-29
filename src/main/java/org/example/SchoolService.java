package org.example;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SchoolService {

    private HashMap<String, Student> students = new HashMap<>();
    private HashMap<String, Teacher> teachers = new HashMap<>();

    public String addStudent(Student s) {
        if (s.getId() == null) return "Error: ID cannot be null";
        students.put(s.getId(), s);
        // SECURITY FIX: Static message
        return "Student added successfully";
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Student getStudentById(String id) {
        return students.get(id);
    }

    public String addTeacher(Teacher t) {
        if (t.getId() == null) return "Error: ID cannot be null";
        teachers.put(t.getId(), t);
        // SECURITY FIX: Static message
        return "Teacher added successfully";
    }

    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(teachers.values());
    }

    public int getTeacherSalary(String id) {
        Teacher t = teachers.get(id);
        if (t == null) return 0;
        return t.calculateSalary(t.getCourseCount());
    }
}