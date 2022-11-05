package com.psuti.lab.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "Role")
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    private String name;
}
