package com.example.demo1spring.Model;

public class Boss {
    private int id;
    private String name;
    private int age;

    public Boss(int id, String name, int age){
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

   /* public void setName(String name) {
        this.name = name;
    }*/

    public int getAge() {
        return age;
    }

   /* public void setAge(int age) {
        this.age = age;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Creating empty constructor
    public Boss(){}

    //creating a parameterized constructor



}
