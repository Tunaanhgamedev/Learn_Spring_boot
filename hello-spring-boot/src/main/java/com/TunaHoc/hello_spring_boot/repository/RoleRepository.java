package com.TunaHoc.hello_spring_boot.repository;

import com.TunaHoc.hello_spring_boot.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
