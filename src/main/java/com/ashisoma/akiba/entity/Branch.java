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

    @Column(name = "branch_name", nullable = false)
    private String branch_name;

//    private List<Loan>


    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", branch_name='" + branch_name + '\'' +
                '}';
    }
}