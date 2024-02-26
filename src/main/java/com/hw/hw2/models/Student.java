package com.hw.hw2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String firstName;

    private String lastName;

    private int age;

    private ArrayList<Integer> grades;

}
