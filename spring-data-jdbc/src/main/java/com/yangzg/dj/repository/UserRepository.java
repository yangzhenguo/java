package com.yangzg.dj.repository;

import com.yangzg.dj.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Sam on 2019/12/12.
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {
    List<User> findUsersByUid(String uid);
}
