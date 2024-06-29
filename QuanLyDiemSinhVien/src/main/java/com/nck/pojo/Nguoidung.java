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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author chanh
 */
@Entity
@Table(name = "nguoidung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nguoidung.findAll", query = "SELECT n FROM Nguoidung n"),
    @NamedQuery(name = "Nguoidung.findById", query = "SELECT n FROM Nguoidung n WHERE n.id = :id"),
    @NamedQuery(name = "Nguoidung.findByTen", query = "SELECT n FROM Nguoidung n WHERE n.ten = :ten"),
    @NamedQuery(name = "Nguoidung.findByEmail", query = "SELECT n FROM Nguoidung n WHERE n.email = :email"),
    @NamedQuery(name = "Nguoidung.findBySdt", query = "SELECT n FROM Nguoidung n WHERE n.sdt = :sdt"),
    @NamedQuery(name = "Nguoidung.findByUsername", query = "SELECT n FROM Nguoidung n WHERE n.username = :username"),
    @NamedQuery(name = "Nguoidung.findByPassword", query = "SELECT n FROM Nguoidung n WHERE n.password = :password"),
    @NamedQuery(name = "Nguoidung.findByActive", query = "SELECT n FROM Nguoidung n WHERE n.active = :active"),
    @NamedQuery(name = "Nguoidung.findByRole", query = "SELECT n FROM Nguoidung n WHERE n.role = :role"),
    @NamedQuery(name = "Nguoidung.findByAvatar", query = "SELECT n FROM Nguoidung n WHERE n.avatar = :avatar")})
public class Nguoidung implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)

    @NotNull//@NotNull(message = "{Nguoidung.ten.nullErr}")
    @Size(min = 1, max = 255)//@Size(min = 1, max = 255, message = "{Nguoidung.ten.minMaxErr}")
    @Column(name = "ten")
    private String ten;
//    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @Size(min = 1, max = 255)//@Size(min = 1, max = 255, message = "{Nguoidung.email.minMaxErr}")
    @Column(name = "email")
    @NotNull
    //@NotNull(message = "{Nguoidung.email.nullErr}")
    private String email;
    @Size(max = 20)
    @Column(name = "sdt")
    private String sdt;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    //@NotNull(message = "{Nguoidung.password.nullErr}")
    @Size(min = 1, max = 255)//@Size(min = 1, max = 255, message = "{Nguoidung.password.minMaxErr}")
    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "active")
    private Boolean active;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "role")
    private String role;
    @Size(max = 255)
    @Column(name = "avatar")
    private String avatar;
    @JoinTable(name = "tin_nhan_forum", joinColumns = {
        @JoinColumn(name = "tac_gia_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "forum_id", referencedColumnName = "id")})
    @ManyToMany
    @JsonIgnore
    private Set<Forums> forumsSet;
    @OneToMany(mappedBy = "nguoidung")
    @JsonIgnore
    private Set<Monhoc> monhocSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sinhVienId")
    @JsonIgnore
    private Set<Dangkymonhoc> dangkymonhocSet;
    @OneToMany(mappedBy = "nguoidung")
    @JsonIgnore
    private Set<ScoreSv> scoreSvSet;
    @JoinTable(name = "dangkymonhoc", joinColumns = {
        @JoinColumn(name = "sinh_vien_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "lop_hoc_id", referencedColumnName = "id")})
    @ManyToMany
    @JsonIgnore
    private Set<Lophoc> lophocSet;
    @Transient
    private MultipartFile file;

    public Nguoidung() {
    }

    public Nguoidung(Long id) {
        this.id = id;
    }

    public Nguoidung(Long id, String ten, String email, String username, String password, String role) {
        this.id = id;
        this.ten = ten;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Set<Forums> getForumsSet() {
        return forumsSet;
    }

    public void setForumsSet(Set<Forums> forumsSet) {
        this.forumsSet = forumsSet;
    }

    @XmlTransient
    public Set<Monhoc> getMonhocSet() {
        return monhocSet;
    }

    public void setMonhocSet(Set<Monhoc> monhocSet) {
        this.monhocSet = monhocSet;
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
        if (!(object instanceof Nguoidung)) {
            return false;
        }
        Nguoidung other = (Nguoidung) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nck.pojo.Nguoidung[ id=" + id + " ]";
    }

    @XmlTransient
    public Set<Lophoc> getLophocSet() {
        return lophocSet;
    }

    public void setLophocSet(Set<Lophoc> lophocSet) {
        this.lophocSet = lophocSet;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
