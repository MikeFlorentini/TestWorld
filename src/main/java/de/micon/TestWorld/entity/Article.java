/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.micon.TestWorld.entity;

import de.micon.TestWorld.model.AuditModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mike
 */
@Entity
public class Article extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Float price;
    @Column(name = "units")
    private Integer units;

    public Article() {
    }

    public Article(Long uid, String name, String description, Float price, Integer units) {
        this.uid = uid;
        this.name = name;
        this.description = description;
        this.price = price;
        this.units = units;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }
    
    @Override
    public String toString() {
        return "uid: " + this.uid + ", name: " + this.name;
    }
    
    
}
