/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chanh
 */
@Entity
@Table(name = "cot_diem_them")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CotDiemThem.findAll", query = "SELECT c FROM CotDiemThem c"),
    @NamedQuery(name = "CotDiemThem.findById", query = "SELECT c FROM CotDiemThem c WHERE c.id = :id"),
    @NamedQuery(name = "CotDiemThem.findByName", query = "SELECT c FROM CotDiemThem c WHERE c.name = :name"),
    @NamedQuery(name = "CotDiemThem.findByDiem", query = "SELECT c FROM CotDiemThem c WHERE c.diem = :diem")})
public class CotDiemThem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "diem")
    private Double diem;
    @JoinColumns({
        //@JoinColumn(name = "cotdiem_id", referencedColumnName = "id"),
        @JoinColumn(name = "cotdiem_id", referencedColumnName = "id")})
    @ManyToOne
    private ScoreSv scoreSv;

    public CotDiemThem() {
    }

    public CotDiemThem(Long id) {
        this.id = id;
    }

    public CotDiemThem(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDiem() {
        return diem;
    }

    public void setDiem(Double diem) {
        this.diem = diem;
    }

    public ScoreSv getScoreSv() {
        return scoreSv;
    }

    public void setScoreSv(ScoreSv scoreSv) {
        this.scoreSv = scoreSv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CotDiemThem)) {
            return false;
        }
        CotDiemThem other = (CotDiemThem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nck.pojo.CotDiemThem[ id=" + id + " ]";
    }
    
}
