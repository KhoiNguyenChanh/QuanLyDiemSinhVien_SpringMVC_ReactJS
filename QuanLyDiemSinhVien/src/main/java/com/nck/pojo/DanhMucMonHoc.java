/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chanh
 */
@Entity
@Table(name = "danh_muc_mon_hoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DanhMucMonHoc.findAll", query = "SELECT d FROM DanhMucMonHoc d"),
    @NamedQuery(name = "DanhMucMonHoc.findById", query = "SELECT d FROM DanhMucMonHoc d WHERE d.id = :id"),
    @NamedQuery(name = "DanhMucMonHoc.findByTenDanhMuc", query = "SELECT d FROM DanhMucMonHoc d WHERE d.tenDanhMuc = :tenDanhMuc")})
public class DanhMucMonHoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ten_danh_muc")
    private String tenDanhMuc;
    @Lob
    @Size(max = 65535)
    @Column(name = "mo_ta")
    private String moTa;
    @OneToMany(mappedBy = "danhMucMonHoc")
    @JsonIgnore
    private Set<Monhoc> monhocSet;

    public DanhMucMonHoc() {
    }

    public DanhMucMonHoc(Long id) {
        this.id = id;
    }

    public DanhMucMonHoc(Long id, String tenDanhMuc) {
        this.id = id;
        this.tenDanhMuc = tenDanhMuc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @XmlTransient
    public Set<Monhoc> getMonhocSet() {
        return monhocSet;
    }

    public void setMonhocSet(Set<Monhoc> monhocSet) {
        this.monhocSet = monhocSet;
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
        if (!(object instanceof DanhMucMonHoc)) {
            return false;
        }
        DanhMucMonHoc other = (DanhMucMonHoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nck.pojo.DanhMucMonHoc[ id=" + id + " ]";
    }
    
}
