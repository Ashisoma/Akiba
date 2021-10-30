package com.ashisoma.akiba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "branch")
@Entity
public class Branch {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String branch_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}