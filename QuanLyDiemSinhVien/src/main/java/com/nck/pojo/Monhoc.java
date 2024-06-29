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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "monhoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monhoc.findAll", query = "SELECT m FROM Monhoc m"),
    @NamedQuery(name = "Monhoc.findById", query = "SELECT m FROM Monhoc m WHERE m.id = :id"),
    @NamedQuery(name = "Monhoc.findByTen", query = "SELECT m FROM Monhoc m WHERE m.ten = :ten"),
    @NamedQuery(name = "Monhoc.findByTenGiangVien", query = "SELECT m FROM Monhoc m WHERE m.tenGiangVien = :tenGiangVien")})
public class Monhoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull(message = "{monhoc.ten.nullErr}")
    @Size(min = 1, max = 255, message = "{monhoc.ten.minMaxErr}")
    @Column(name = "ten")
    private String ten;
    @Lob
    @Size(max = 65535)
    @Column(name = "mo_ta_mon_hoc")
    private String moTaMonHoc;
    @Size(max = 255)
    @Column(name = "ten_giang_vien")
    private String tenGiangVien;
    @JoinColumns({
        @JoinColumn(name = "danh_muc_id", referencedColumnName = "id")})
    @ManyToOne
    @JsonIgnore

    private DanhMucMonHoc danhMucMonHoc;
    @JoinColumns({
        @JoinColumn(name = "giang_vien_id", referencedColumnName = "id")})
    @ManyToOne
    @JsonIgnore

    private Nguoidung nguoidung;
    @OneToMany(mappedBy = "monhoc")
    @JsonIgnore
    private Set<Lophoc> lophocSet;

    public Monhoc() {
    }

    public Monhoc(Long id) {
        this.id = id;
    }

    public Monhoc(Long id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTaMonHoc() {
        return moTaMonHoc;
    }

    public void setMoTaMonHoc(String moTaMonHoc) {
        this.moTaMonHoc = moTaMonHoc;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public DanhMucMonHoc getDanhMucMonHoc() {
        return danhMucMonHoc;
    }

    public void setDanhMucMonHoc(DanhMucMonHoc danhMucMonHoc) {
        this.danhMucMonHoc = danhMucMonHoc;
    }

    public Nguoidung getNguoidung() {
        return nguoidung;
    }

    public void setNguoidung(Nguoidung nguoidung) {
        this.nguoidung = nguoidung;
    }

    @XmlTransient
    public Set<Lophoc> getLophocSet() {
        return lophocSet;
    }

    public void setLophocSet(Set<Lophoc> lophocSet) {
        this.lophocSet = lophocSet;
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
        if (!(object instanceof Monhoc)) {
            return false;
        }
        Monhoc other = (Monhoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nck.pojo.Monhoc[ id=" + id + " ]";
    }

}
