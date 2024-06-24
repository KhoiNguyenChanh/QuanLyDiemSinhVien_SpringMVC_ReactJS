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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chanh
 */
@Entity
@Table(name = "forums")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Forums.findAll", query = "SELECT f FROM Forums f"),
    @NamedQuery(name = "Forums.findById", query = "SELECT f FROM Forums f WHERE f.id = :id")})
public class Forums implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @ManyToMany(mappedBy = "forumsSet")
    @JsonIgnore

    private Set<Nguoidung> nguoidungSet;
    @JoinColumns({
        //        @JoinColumn(name = "lop_hoc_id", referencedColumnName = "id"),
        //        @JoinColumn(name = "lop_hoc_id", referencedColumnName = "id"),
        //        @JoinColumn(name = "lop_hoc_id", referencedColumnName = "id"),
        @JoinColumn(name = "lop_hoc_id", referencedColumnName = "id")})
    @ManyToOne
    @JsonIgnore

    private Lophoc lophoc;

    public Forums() {
    }

    public Forums(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlTransient
    public Set<Nguoidung> getNguoidungSet() {
        return nguoidungSet;
    }

    public void setNguoidungSet(Set<Nguoidung> nguoidungSet) {
        this.nguoidungSet = nguoidungSet;
    }

    public Lophoc getLophoc() {
        return lophoc;
    }

    public void setLophoc(Lophoc lophoc) {
        this.lophoc = lophoc;
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
        if (!(object instanceof Forums)) {
            return false;
        }
        Forums other = (Forums) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nck.pojo.Forums[ id=" + id + " ]";
    }

}
