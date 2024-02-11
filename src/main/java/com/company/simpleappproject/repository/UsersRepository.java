package com.company.simpleappproject.repository;

import com.company.simpleappproject.module.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    Optional<Users> findByIdAndDeletedAtIsNull(Integer userId);

    List<Users>findAllByDeletedAtIsNull();
    Boolean existsByEmailAndDeletedAtIsNull(String email);

    Boolean existsByIdAndDeletedAtIsNull(Integer userId);
}
