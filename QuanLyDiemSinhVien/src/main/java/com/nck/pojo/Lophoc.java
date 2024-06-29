/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
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
@Table(name = "lophoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lophoc.findAll", query = "SELECT l FROM Lophoc l"),
    @NamedQuery(name = "Lophoc.findById", query = "SELECT l FROM Lophoc l WHERE l.id = :id"),
    @NamedQuery(name = "Lophoc.findByTen", query = "SELECT l FROM Lophoc l WHERE l.ten = :ten")})
public class Lophoc implements Serializable {

    @ManyToMany(mappedBy = "lophocSet")
    @JsonIgnore
    private Set<Nguoidung> nguoidungSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ten")
    private String ten;
    @OneToMany(mappedBy = "lophoc")
    private Set<Forums> forumsSet;
    @JoinColumns({
        @JoinColumn(name = "mon_hoc_id", referencedColumnName = "id")})
    @ManyToOne
    @JsonIgnore

    private Monhoc monhoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lopHocId")
    @JsonIgnore

    private Set<Dangkymonhoc> dangkymonhocSet;
    @OneToMany(mappedBy = "lophoc")
    @JsonIgnore

    private Set<ScoreSv> scoreSvSet;

    public Lophoc() {
    }

    public Lophoc(Long id) {
        this.id = id;
    }

    public Lophoc(Long id, String ten) {
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

    @XmlTransient
    public Set<Forums> getForumsSet() {
        return forumsSet;
    }

    public void setForumsSet(Set<Forums> forumsSet) {
        this.forumsSet = forumsSet;
    }

    public Monhoc getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(Monhoc monhoc) {
        this.monhoc = monhoc;
    }

    @XmlTransient
    public Set<Dangkymonhoc> getDangkymonhocSet() {
        return dangkymonhocSet;
    }

    public void setDangkymonhocSet(Set<Dangkymonhoc> dangkymonhocSet) {
        this.dangkymonhocSet = dangkymonhocSet;
    }

    @XmlTransient
    public Set<ScoreSv> getScoreSvSet() {
        return scoreSvSet;
    }

    public void setScoreSvSet(Set<ScoreSv> scoreSvSet) {
        this.scoreSvSet = scoreSvSet;
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
        if (!(object instanceof Lophoc)) {
            return false;
        }
        Lophoc other = (Lophoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nck.pojo.Lophoc[ id=" + id + " ]";
    }

    @XmlTransient
    public Set<Nguoidung> getNguoidungSet() {
        return nguoidungSet;
    }

    public void setNguoidungSet(Set<Nguoidung> nguoidungSet) {
        this.nguoidungSet = nguoidungSet;
    }

}
