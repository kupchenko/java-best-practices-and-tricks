package me.kupchenko.stream;

import me.kupchenko.model.User;

import java.util.List;

import static me.kupchenko.model.QualityAnnotations.Good;
import static me.kupchenko.model.QualityAnnotations.Ugly;

public class SkipAndLimitOnListIsWaste {
    @Ugly
    class SkipSomeElementsAndThenTakeSomeForProcessing {
        public void registerUsers(List<User> users) {
            users.stream().skip(5).limit(10)
                    .forEach(SkipAndLimitOnListIsWaste.this::registerUser);
        }
    }

    @Good
    class SublistDoNotWasteProcessingTime {
        public void registerUsers(List<User> users) {
            users.subList(5, 15)
                    .forEach(SkipAndLimitOnListIsWaste.this::registerUser);
        }
    }

    private void registerUser(User user) {
        //register user
    }
}
