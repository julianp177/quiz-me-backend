package com.quiz.me.quizmebackend.Repository;

import com.quiz.me.quizmebackend.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel,String> {
    Optional<UserModel> findByUserName(String userName);

    @Query("SELECT u.userName FROM UserModel u WHERE u.userName = :userName")
    String checkUserByUserName(@Param("userName") String userName);

    @Query("SELECT u.password FROM UserModel u WHERE u.userName = :userName")
    String getPassword(@Param("userName") String userName);

    @Query("SELECT u.firstName FROM UserModel u WHERE u.userName = :userName")
    String getFirstName(@Param("userName") String userName);

    @Query("SELECT u.lastName FROM UserModel u WHERE u.userName = :userName")
    String getLastName(@Param("userName") String userName);

    @Query("SELECT u.id FROM UserModel u WHERE u.userName = :userName")
    Integer getUserId(@Param("userName") String userName);

    @Modifying
    @Query("UPDATE UserModel u SET u.password = :newPassword WHERE u.userName = :userName")
    void changePasswordByUsername(@Param("newPassword") String newPassword,@Param("userName") String userName);
}
