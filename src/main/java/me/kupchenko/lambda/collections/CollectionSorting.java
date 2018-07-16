package me.kupchenko.lambda.collections;

import me.kupchenko.model.QualityAnnotations.Good;
import me.kupchenko.model.QualityAnnotations.CabBeBetter;
import me.kupchenko.model.User;

import java.util.List;

import static java.util.Comparator.comparing;

public class CollectionSorting {

    @CabBeBetter("Can be simplified with 'comparing' method and method reference")
    class UsingLegacyComparator {
        public void sortUsers(List<User> users) {
            users.sort((x, y) -> Long.compare(x.getId(), y.getId()));
        }
    }

    @Good("It looks shorted and more readable")
    class UsingExistingPredefinedComparator {
        public void sortUsersById(List<User> users) {
            //Can be used 'comparingLong(User::getId)'
            users.sort(comparing(User::getId));
        }
    }
}
