package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

//instaciando um objeto Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
