package org.example;

public class Student {
    // Fields from your PDF logic
    private String id;
    private String firstName;
    private String lastName;
    private int year;
    private String programme;

    // Empty constructor (Required by Spring Boot)
    public Student() {}

    // Constructor with all fields
    public Student(String id, String firstName, String lastName, int year, String programme) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.programme = programme;
    }

    // Getters (So the Web API can read the data)
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getYear() { return year; }
    public String getProgramme() { return programme; }
}