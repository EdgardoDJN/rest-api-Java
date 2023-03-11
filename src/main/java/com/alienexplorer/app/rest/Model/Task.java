package com.alienexplorer.app.rest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//To save data in the database using the Spring JPA, 
//we need to create an entity model. Let’s create a User 
//entity which will store the data in the database.This is 
//how our entity will look like:
@Entity //// This tells Hibernate to make a table out of this class
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")

    private String title;
    private String description;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    //Hibernate automatically translates the entity into a table.
}
