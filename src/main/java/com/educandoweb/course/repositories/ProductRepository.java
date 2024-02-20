package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.entities.Product;

@Repository
//instaciando um objeto Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
