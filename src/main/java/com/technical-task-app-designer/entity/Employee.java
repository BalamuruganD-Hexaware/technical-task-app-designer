package com.technical-task-app-designer.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {

	@Id
	private String id;
    private String name;
    private String email;

	public Employee(String id, 
        String name, 
        String email
    ){
    this.id = id;
	this.name = name;
	this.email = email;
	}

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public String toString(){
        return "[id = " + this.id +
                "name = " + this.name +
                "email = " + this.email +
            "]";
    }

}
