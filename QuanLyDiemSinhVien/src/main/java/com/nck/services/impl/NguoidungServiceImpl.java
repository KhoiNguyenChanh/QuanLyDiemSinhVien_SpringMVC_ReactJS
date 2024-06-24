/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nck.pojo.Nguoidung;
import com.nck.repositories.NguoidungRepository;
import com.nck.services.NguoidungService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author chanh
 */
@Service("userDetailsService")
public class NguoidungServiceImpl implements NguoidungService {

    @Autowired
    private NguoidungRepository nguoidungRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Nguoidung> getGiangVien() {
        return nguoidungRepository.findByRole("giangvien");
    }

    @Override
    public List<Nguoidung> getUser() {
        return this.nguoidungRepository.getUser();
    }

    @Override
    public Nguoidung getUserByUsername(String username) {
        return this.nguoidungRepository.getUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Nguoidung u = this.nguoidungRepository.getUserByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Không tồn tại!");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getRole()));
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }

    @Override
    public void addUser(Nguoidung user) {
        if (!user.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                user.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(NguoidungServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.nguoidungRepository.addUser(user);
    }

    @Override
    public void deleteUser(long id) {
        this.nguoidungRepository.deleteUser(id);

    }
}
