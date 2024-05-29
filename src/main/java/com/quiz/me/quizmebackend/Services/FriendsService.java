package com.quiz.me.quizmebackend.Services;

import com.quiz.me.quizmebackend.Model.*;
import com.quiz.me.quizmebackend.Repository.*;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class FriendsService {

    private final FriendRepository friendRepository;
    private final DuelRepository duelRepository;
    private final UserRepository userRepository;

    public FriendsService(FriendRepository friendRepository, DuelRepository duelRepository, UserRepository userRepository) {
        this.friendRepository = friendRepository;
        this.duelRepository = duelRepository;
        this.userRepository = userRepository;
    }

    public List<FriendModel> getFriends(){
        return this.friendRepository.findAll();
    }
    public List<DuelModel> getDuels() { return this.duelRepository.findAll(); }
    public String addFriend(String newFriendData) {
        String[] parts = newFriendData.split(";");
        Long userId = Long.parseLong(parts[0]);
        Long friendId = Long.parseLong(parts[1]);

        UserModel user = userRepository.findById(String.valueOf(userId))
                .orElseThrow(() -> new RuntimeException("User not found: " + userId));
        UserModel friend = userRepository.findById(String.valueOf(friendId))
                .orElseThrow(() -> new RuntimeException("Friend not found: " + friendId));

        FriendModel newFriend = new FriendModel();
        newFriend.setUser(user);
        newFriend.setFriend(friend);

        friendRepository.save(newFriend);

        return "Nachricht wurde übermittelt";
    }

}
