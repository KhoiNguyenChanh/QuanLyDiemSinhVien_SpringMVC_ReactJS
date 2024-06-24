/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chanh
 */
@Entity
@Table(name = "dangkymonhoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dangkymonhoc.findAll", query = "SELECT d FROM Dangkymonhoc d"),
    @NamedQuery(name = "Dangkymonhoc.findById", query = "SELECT d FROM Dangkymonhoc d WHERE d.id = :id")})
public class Dangkymonhoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "lop_hoc_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore

    private Lophoc lopHocId;
    @JoinColumn(name = "sinh_vien_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore

    private Nguoidung sinhVienId;

    public Dangkymonhoc() {
    }

    public Dangkymonhoc(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lophoc getLopHocId() {
        return lopHocId;
    }

    public void setLopHocId(Lophoc lopHocId) {
        this.lopHocId = lopHocId;
    }

    public Nguoidung getSinhVienId() {
        return sinhVienId;
    }

    public void setSinhVienId(Nguoidung sinhVienId) {
        this.sinhVienId = sinhVienId;
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
        if (!(object instanceof Dangkymonhoc)) {
            return false;
        }
        Dangkymonhoc other = (Dangkymonhoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nck.pojo.Dangkymonhoc[ id=" + id + " ]";
    }

}
