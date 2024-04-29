package com.javalab.School;

public class Department {

    private String id;			// 학과 코드
    private String name;		// 학과명
    private String office;		// 학과 사무실

    public Department() {
    }
    public Department(String id, String name, String office) {
        this.id = id;
        this.name = name;
        this.office = office;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOffice() {
        return office;
    }
    public void setOffice(String office) {
        this.office = office;
    }
    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + ", office=" + office + "]";
    }
}