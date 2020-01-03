package com.yangzg.java.mybatis.mapper;

import com.yangzg.java.mybatis.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    Optional<User> selectUser(int id);

    /**
     * listAll
     * @return
     */
    @Select("SELECT * FROM user")
    List<User> listAll();

    /**
     * insert
     * @param user
     * @return
     */
    boolean insert(final User user);

    /**
     * delete
     * @param id
     */
    @Delete("DELETE FROM user WHERE id = #{id}")
    boolean delete(int id);

    /**
     * update
     * @param user
     */
    @Update("UPDATE user SET username = #{username} WHERE id = #{id}")
    boolean update(final User user);
}
