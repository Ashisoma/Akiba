package com.ashisoma.akiba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Table(name = "branch")
@Entity
public class Branch {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String branch_name;

//    private List<Loan>

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}