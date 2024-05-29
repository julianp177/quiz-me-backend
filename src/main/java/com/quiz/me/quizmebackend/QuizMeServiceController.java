package com.quiz.me.quizmebackend;

import com.quiz.me.quizmebackend.Model.*;
import com.quiz.me.quizmebackend.Services.AuthService;
import com.quiz.me.quizmebackend.Services.CardsService;
import com.quiz.me.quizmebackend.Services.FriendsService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class QuizMeServiceController {
    private final AuthService authService;
    private final CardsService cardsService;
    private final FriendsService friendsService;

    //test

    public QuizMeServiceController(AuthService authService, CardsService cardsService, FriendsService friendsService) {
        this.authService = authService;
        this.cardsService = cardsService;
        this.friendsService = friendsService;
    }

    @GetMapping("/user") //Gibt alle Daten aus
    public List<UserModel> getUser() {
        return this.authService.getUser();
    }

    @GetMapping("/usercheck/{userName}") //Gibt den Text der angegebenen Message aus
    public boolean checkUser(@PathVariable String userName) {
        return this.authService.checkUser(userName);
    }
    @GetMapping("/passwordcheck/{password}/{userName}") //Gibt den Text der angegebenen Message aus
    public boolean checkPassword(@PathVariable String password,@PathVariable String userName) {
        return this.authService.checkPassword(password,userName);
    }
    @GetMapping("/get/firstname/{username}")
    public String getFirstName(@PathVariable String username){
        return this.authService.getFirstName(username);
    }
    @GetMapping("/get/lastname/{username}")
    public String getLastName(@PathVariable String username){
        return this.authService.getLastName(username);
    }
    @GetMapping("/get/userid/{username}")
    public Integer getUserId(@PathVariable String username){
        return this.authService.getUserId(username);
    }
    //------------------------------------
    @PostMapping("/adduser")
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody String newUserData) {
        return authService.addUser(newUserData);
    }
    @PostMapping("/change/password")
    @ResponseStatus(HttpStatus.CREATED)
    public String changePassword(@RequestBody String newPasswordData) {
        return authService.changePassword(newPasswordData);
    }


    //AB HIER CARDSSERVICE

    @GetMapping("/sets") //Gibt alle Daten aus
    public List<SetModel> getSets() {
        return this.cardsService.getSets();
    }
    @GetMapping("/cards") //Gibt alle Daten aus
    public List<CardModel> getCards() {
        return this.cardsService.getCards();
    }
    @GetMapping("/marks") //Gibt alle Daten aus
    public List<MarkModel> getMarks() {
        return this.cardsService.getMarks();
    }

    //AB HIER FRIENDSSERVICE

    @GetMapping("/friends") //Gibt alle Daten aus
    public List<FriendModel> getFriends() {
        return this.friendsService.getFriends();
    }
    @GetMapping("/duels") //Gibt alle Daten aus
    public List<DuelModel> getDuels() {
        return this.friendsService.getDuels();
    }


    @PostMapping("/addfriend")
    @ResponseStatus(HttpStatus.CREATED)
    public String addFriend(@RequestBody String newFriendData) {
        return friendsService.addFriend(newFriendData);
    }


}
