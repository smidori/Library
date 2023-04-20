/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.model;

/**
 * This class implements the Comparable for the binary search and merge sort
 * @2022443Maria
 */
public class Student implements Comparable<Student> {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;

    public Student() {} //necessary for comparator class, to set the property that needs to be search

    public Student(int id, String firstName, String lastName, String address,String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public String orderedDescriptionBy(String order){
        if(order.equalsIgnoreCase("name")){
            return getFullName()+ " - "  + id  +" - " + email + " - " + address+"\n";
        }else if(order.equalsIgnoreCase("id")){
           return id + " - " +getFullName() +" - "+ email +" - " + address +"\n";
        }else{
            return toString();
        }
    }
    
    @Override
    public String toString() {
        return "Name:" + getFullName() + "\nId:" + getId() + "\nEmail: " + getEmail() + "\nAddress:" + getAddress();
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(id, o.getId());
    }

}
