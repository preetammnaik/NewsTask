package com.news.task.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role(){

    }
    public Role(String name){
        this.name = name;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Role(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }



    @Id
@Column(name = "role_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
