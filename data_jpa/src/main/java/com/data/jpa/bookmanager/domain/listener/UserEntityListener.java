package com.data.jpa.bookmanager.domain.listener;

import com.data.jpa.bookmanager.domain.User;
import com.data.jpa.bookmanager.domain.UserHistory;
import com.data.jpa.bookmanager.repository.UserHistoryRepository;
import com.data.jpa.bookmanager.utils.BeanUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

//@Component
public class UserEntityListener {

//    @Autowired
//    private UserHistoryRepository userHistoryRepository; // spring bean 을 주입 받을 수 없음

    @PrePersist
    @PreUpdate
    public void prePersistAndPreUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) o;

        UserHistory userHistory = UserHistory.builder()
                .userId(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();

        userHistoryRepository.save(userHistory);
    }
}
