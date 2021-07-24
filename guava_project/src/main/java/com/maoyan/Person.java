package com.maoyan;

import com.google.common.collect.ComparisonChain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chenhua11
 * @date 2021/6/10  3:53 下午
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Comparable<Person> {
    
    private String lastName;
    private String firstName;
    private int zipCode;
    
    @Override
    public int compareTo(Person that) {
        return ComparisonChain.start()
                .compare(this.lastName, that.lastName)
                .compare(this.firstName, that.firstName)
                .compare(this.zipCode, that.zipCode)
                .result();
    }
    
    public static void main(String[] args) {
        Person person1 = new Person("2", "3", 1);
        Person person2 = new Person("4", "1", 3);
        Person person3 = new Person("1", "1", 2);
        Person person4 = new Person("3", "1", 5);
        Person person5 = new Person("4", "2", 3);
        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5);
        Collections.sort(personList);
        for (Person person : personList) {
            System.out.println(person);
        }
    
    }
}