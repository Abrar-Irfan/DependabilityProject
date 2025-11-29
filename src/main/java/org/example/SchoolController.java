package org.example;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolController {

    private final SchoolService service;

    public SchoolController(SchoolService service) {
        this.service = service;
    }

    // --- Student Endpoints ---
    @PostMapping("/student")
    public String addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable String id) {
        return service.getStudentById(id);
    }

    // --- Teacher Endpoints ---
    @PostMapping("/teacher")
    public String addTeacher(@RequestBody Teacher teacher) {
        return service.addTeacher(teacher);
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return service.getAllTeachers();
    }

    @GetMapping("/teacher/{id}/salary")
    public int getTeacherSalary(@PathVariable String id) {
        return service.getTeacherSalary(id);
    }
}