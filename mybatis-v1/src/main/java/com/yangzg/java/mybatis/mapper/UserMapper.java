package com.yangzg.java.mybatis.mapper;

import com.yangzg.java.mybatis.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2020/1/1.
 * @author Sam
 */
public interface UserMapper {
    /**
     * selectUser
     * @param id
     * @return
     */
    @Select("SELECT * FROM user WHERE id = #{ID}")
    Optional<User> selectUser(@Param("ID") int id);

    /**
     * listAll
     * @return
     */
    @Select("SELECT * FROM user")
    List<User> listAll();
}
