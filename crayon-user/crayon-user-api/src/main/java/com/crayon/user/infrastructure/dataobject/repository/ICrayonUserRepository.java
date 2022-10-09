package com.crayon.user.infrastructure.dataobject.repository;

import com.crayon.user.infrastructure.dataobject.CrayonUserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrayonUserRepository extends JpaRepository<CrayonUserDO, Long> {

    CrayonUserDO findByUsername(String username);

}
