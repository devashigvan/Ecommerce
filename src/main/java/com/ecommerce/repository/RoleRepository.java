package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
