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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chanh
 */
@Entity
@Table(name = "score_sv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScoreSv.findAll", query = "SELECT s FROM ScoreSv s"),
    @NamedQuery(name = "ScoreSv.findById", query = "SELECT s FROM ScoreSv s WHERE s.id = :id"),
    @NamedQuery(name = "ScoreSv.findByGiuaKy", query = "SELECT s FROM ScoreSv s WHERE s.giuaKy = :giuaKy"),
    @NamedQuery(name = "ScoreSv.findByCuoiKy", query = "SELECT s FROM ScoreSv s WHERE s.cuoiKy = :cuoiKy")})
public class ScoreSv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "giua_ky")
    private Double giuaKy;
    @Column(name = "cuoi_ky")
    private Double cuoiKy;
    @OneToMany(mappedBy = "scoreSv")
    @JsonIgnore

    private Set<CotDiemThem> cotDiemThemSet;
    @JoinColumns({
        @JoinColumn(name = "lop_hoc_id", referencedColumnName = "id")})
    @ManyToOne
    @JsonIgnore

    private Lophoc lophoc;
    @JoinColumns({
        @JoinColumn(name = "sinh_vien_id", referencedColumnName = "id")})
    @ManyToOne
    @JsonIgnore

    private Nguoidung nguoidung;

    public ScoreSv() {
    }

    public ScoreSv(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGiuaKy() {
        return giuaKy;
    }

    public void setGiuaKy(Double giuaKy) {
        this.giuaKy = giuaKy;
    }

    public Double getCuoiKy() {
        return cuoiKy;
    }

    public void setCuoiKy(Double cuoiKy) {
        this.cuoiKy = cuoiKy;
    }

    @XmlTransient
    public Set<CotDiemThem> getCotDiemThemSet() {
        return cotDiemThemSet;
    }

    public void setCotDiemThemSet(Set<CotDiemThem> cotDiemThemSet) {
        this.cotDiemThemSet = cotDiemThemSet;
    }

    public Lophoc getLophoc() {
        return lophoc;
    }

    public void setLophoc(Lophoc lophoc) {
        this.lophoc = lophoc;
    }

    public Nguoidung getNguoidung() {
        return nguoidung;
    }

    public void setNguoidung(Nguoidung nguoidung) {
        this.nguoidung = nguoidung;
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
        if (!(object instanceof ScoreSv)) {
            return false;
        }
        ScoreSv other = (ScoreSv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nck.pojo.ScoreSv[ id=" + id + " ]";
    }

}
