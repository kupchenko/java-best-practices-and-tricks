package me.kupchenko.lambda.collections;

import me.kupchenko.model.QualityAnnotations.Good;
import me.kupchenko.model.QualityAnnotations.CabBeBetter;
import me.kupchenko.model.Permission;
import me.kupchenko.model.User;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveElementFromCollection {
    private final Set<User> users = new HashSet<>();

    @CabBeBetter
    class ManuallyRemoveElementWithIteratorRemove {
        public void removeUsersWithPermission(Permission permission) {
            Iterator<User> iterator = users.iterator();
            while (iterator.hasNext()) {
                User user = iterator.next();
                if (user.getRoles().stream()
                        .anyMatch(r -> r.getPermissions().contains(permission))) {
                    iterator.remove();
                }
            }
        }
    }

    @Good("Better: say what to do (e.g. removeIf()) and set the Predicate (condition)" +
            "not just loop over the list, perform check and then remove")
    class RemoveWithPredicate {
        public void removeUsersWithPermission(Permission permission) {
            users.removeIf(user -> user.getRoles().stream()
                    .anyMatch(r -> r.getPermissions().contains(permission)));
        }
    }
}