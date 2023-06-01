package com.jmp.jmp_japan_music_player.util;

import com.jmp.jmp_japan_music_player.domain.User;

public class UserUtil {
    private final User user;
    public UserUtil(User user) {
        this.user = user;
    }
    /** 유저 회원가입 -> 데이터 체크 */
    public boolean registerCheckUser(User userData) {
        return isUserDataValid(userData) && isUserDataLengthValid(userData);
    }

    private boolean isUserDataValid(User userData) {
        return !userData.getId().isEmpty() && !userData.getUserName().isEmpty() &&
                !userData.getPassword().isEmpty() && !userData.getEmail().isEmpty();
    }

    private boolean isUserDataLengthValid(User userData) {
        return userData.getId().length() >= 5 && userData.getId().length() <= 20 &&
                userData.getPassword().length() >= 5 && userData.getPassword().length() <= 30 &&
                userData.getUserName().length() <= 10 &&
                userData.getEmail().length() >= 10 && userData.getEmail().length() <= 40;
    }
}
