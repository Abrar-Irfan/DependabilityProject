package org.example;

public class Teacher {
    // Fields are nullable
    /*@ spec_public nullable @*/ private String id;
    /*@ spec_public nullable @*/ private String name;
    /*@ spec_public nullable @*/ private String department;

    /*@ spec_public @*/ private int courseCount;

    public static final int BASE_SALARY = 50000;
    public static final int PER_COURSE_BONUS = 5000;

    public Teacher() {}

    public Teacher(String id, String name, String department, int courseCount) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.courseCount = courseCount;
    }

    // --- JML SPECIFICATION FOR SALARY ---
    /*@
      @ public normal_behavior
      @ requires courses >= 0 && courses < 100;
      @ ensures \result == BASE_SALARY + (courses * PER_COURSE_BONUS);
      @*/
    public /*@ pure @*/ int calculateSalary(int courses) {
        return BASE_SALARY + (courses * PER_COURSE_BONUS);
    }

    // --- FIX: Added 'nullable' to getters ---
    public /*@ pure nullable @*/ String getId() { return id; }
    public /*@ pure nullable @*/ String getName() { return name; }
    public /*@ pure nullable @*/ String getDepartment() { return department; }
    public /*@ pure @*/ int getCourseCount() { return courseCount; }
}