package com.quiz.me.quizmebackend.Services;

import com.quiz.me.quizmebackend.Model.UserModel;
import com.quiz.me.quizmebackend.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getUser(){
        return this.userRepository.findAll();
    }

    public boolean checkUser(String userName) {
        if(userRepository.checkUserByUserName(userName)!=null){
            return true;
        }else{
            return false;
        }
    }
    public String getPassword(String userName) {
        return userRepository.getPassword(userName);
    }
    public boolean checkPassword(String requestedPassword, String userName) {
        String password = getPassword(userName);
        return requestedPassword.equals(password);
    }

    public String getFirstName(String userName){
        return this.userRepository.getFirstName(userName);
    }

    public String getLastName(String userName){
        return this.userRepository.getLastName(userName);
    }

    public Integer getUserId(String userName){
        return this.userRepository.getUserId(userName);
    }

    public String addUser(String newUserData){

        UserModel newUser = new UserModel();

        String[] parts = newUserData.split(";");

        System.out.println(parts[0]);
        System.out.println(parts[1]);
        System.out.println(parts[2]);
        System.out.println(parts[3]);

        newUser.setUserName(parts[0]);
        newUser.setPassword(parts[1]);
        newUser.setFirstName(parts[2]);
        newUser.setLastName(parts[3]);

        userRepository.save(newUser);

        return "User wurde hinzugefügt";
    }
    @Transactional
    public String changePassword(String newPasswordData) {

        String[] parts = newPasswordData.split(";");
        userRepository.changePasswordByUsername(parts[0],parts[1]);

        return "Passwort wurde geändert";
    }


    //Passwort hashen
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // Methode zum Hashen des Passworts mit dem gegebenen Salz
    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        String saltedPassword = salt + password;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedPassword = md.digest(saltedPassword.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }
}
