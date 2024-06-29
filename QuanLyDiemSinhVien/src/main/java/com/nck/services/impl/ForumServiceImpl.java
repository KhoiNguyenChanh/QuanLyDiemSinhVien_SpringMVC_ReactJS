/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services.impl;

import com.nck.pojo.Forums;
import com.nck.repositories.ForumRepository;
import com.nck.services.ForumService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chanh
 */
@Service
public class ForumServiceImpl implements ForumService{
    @Autowired
    private ForumRepository forumRepo;

    @Override
    public List<Forums> getForums() {
        return this.forumRepo.getForums();
    }
    
    
    
}
