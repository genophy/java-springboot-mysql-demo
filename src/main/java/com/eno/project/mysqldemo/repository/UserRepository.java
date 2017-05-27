package com.eno.project.mysqldemo.repository;

import com.eno.project.mysqldemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by eno on 2017/05/27.
 */
public interface UserRepository  extends JpaRepository<User,Integer>{

}
