package com.yangzg.java.mybatis.mapper;

import com.yangzg.java.mybatis.model.User;
import com.yangzg.java.mybatis.to.UserCondition;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
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
    Optional<User> selectUserById(final int id);

    /**
     * selectUserWithGroupById
     * @param id
     * @return
     */
    Optional<User> selectUserWithGroupById(final int id);

    /**
     * selectAllUserLazy
     * @return
     */
    List<User> selectAllUserLazy();

    /**
     * selectAllUserWithGroup
     * @return
     */
    List<User> selectAllUserWithGroup();

    /**
     * selectUser
     * @param table
     * @param user
     * @return
     */
    @Select("SELECT * FROM `${table}` WHERE username = #{user.username} LIMIT 1")
    Optional<User> selectUser(@Param("table") final String table, @Param("user") final User user);

    /**
     * selectUserByCondition
     * @param condition
     * @return
     */
    @Select("SELECT * FROM `user` WHERE username = #{username} LIMIT 1")
    Optional<User> selectUserByCondition(final UserCondition condition);

    /**
     * selectUserByIdAndUsername
     * @param id
     * @param username
     * @return
     */
    @Select("SELECT * FROM `user` WHERE id = #{param1} AND username = #{param2} LIMIT 1")
    Optional<User> selectUserByIdAndUsername(@Param("id") final int id, @Param("username") final String username);

    /**
     * listAll
     * @return
     */
    @Select("SELECT * FROM user")
    List<User> listAll();

    /**
     * 通过id查询单条结果
     * @param id
     * @return Optional
     */
    Optional<Map<String, Object>> selectMapById(final int id);

    /**
     * 查询List of map
     * @return Optional
     */
    List<Map<String, Object>> selectAllListOfMap();

    /**
     * selectAllMap
     * @return
     */
    @MapKey("id")
    @Select("SELECT * FROM `user`")
    Map<Integer, User> selectAllMap();

    /**
     * insert
     * @param user
     * @return
     */
    boolean insert(final User user);

    /**
     * delete by id
     * @param id
     * @return Boolean
     */
    @Delete("DELETE FROM user WHERE id = #{id}")
    boolean delete(final int id);

    /**
     * update by id
     * @param user
     * @return Boolean
     */
    @Update("UPDATE user SET username = #{username} WHERE id = #{id}")
    boolean update(final User user);
}
