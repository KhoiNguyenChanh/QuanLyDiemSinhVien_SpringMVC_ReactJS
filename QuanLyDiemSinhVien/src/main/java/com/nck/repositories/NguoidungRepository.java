/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.repositories;

import com.nck.pojo.Nguoidung;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author chanh
 */
//public interface NguoidungRepository extends JpaRepository<Nguoidung, Long> {
public interface NguoidungRepository {

    List<Nguoidung> findByRole(String role);

    boolean authUser(String username, String password);

    Nguoidung getUserByUsername(String username);

    Nguoidung getUserById(long id);

    void addUser(Nguoidung user);

    void deleteUser(long id);

    List<Nguoidung> getUser();

    List<Nguoidung> getUser(Map<String, String> params);
    
    Optional<Nguoidung> findById(Long id); // Thêm phương thức findById

//    Nguoidung getMonhocById(Long id);
}
