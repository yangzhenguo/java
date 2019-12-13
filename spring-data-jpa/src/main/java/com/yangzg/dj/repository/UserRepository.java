package com.yangzg.dj.repository;

import com.yangzg.dj.model.User;
import com.yangzg.dj.repository.inf.UserDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Sam on 2019/12/13.
 */
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User>, UserDao {
    Page<User> findAllByUidBefore(String uid, Pageable pageable);
}
