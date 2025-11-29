package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SchoolController.class)
class SchoolControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SchoolService service;

    @Test
    void testAddStudent() throws Exception {
        // UPDATE MOCK RETURN VALUE:
        given(service.addStudent(any(Student.class))).willReturn("Student added successfully");

        mockMvc.perform(post("/api/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"S1\", \"firstName\":\"John\", \"lastName\":\"Doe\", \"year\":2023, \"programme\":\"CSE\"}"))
                .andExpect(status().isOk())
                // UPDATE EXPECTATION:
                .andExpect(content().string("Student added successfully"));
    }

    @Test
    void testGetAllStudents() throws Exception {
        Student s = new Student("S1", "John", "Doe", 2023, "CSE");
        given(service.getAllStudents()).willReturn(Collections.singletonList(s));

        mockMvc.perform(get("/api/students"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':'S1'}]"));
    }

    @Test
    void testGetStudentById() throws Exception {
        Student s = new Student("S1", "John", "Doe", 2023, "CSE");
        given(service.getStudentById("S1")).willReturn(s);

        mockMvc.perform(get("/api/student/S1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':'S1'}"));
    }

    @Test
    void testAddTeacher() throws Exception {
        // UPDATE MOCK RETURN VALUE:
        given(service.addTeacher(any(Teacher.class))).willReturn("Teacher added successfully");

        mockMvc.perform(post("/api/teacher")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"T1\", \"name\":\"Snape\", \"department\":\"Potions\", \"courseCount\":5}"))
                .andExpect(status().isOk())
                // UPDATE EXPECTATION:
                .andExpect(content().string("Teacher added successfully"));
    }

    @Test
    void testGetAllTeachers() throws Exception {
        Teacher t = new Teacher("T1", "Snape", "Potions", 5);
        given(service.getAllTeachers()).willReturn(Collections.singletonList(t));

        mockMvc.perform(get("/api/teachers"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':'T1'}]"));
    }

    @Test
    void testGetTeacherSalary() throws Exception {
        given(service.getTeacherSalary("T1")).willReturn(75000);

        mockMvc.perform(get("/api/teacher/T1/salary"))
                .andExpect(status().isOk())
                .andExpect(content().string("75000"));
    }
}