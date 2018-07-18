package me.kupchenko.lambda;

import me.kupchenko.model.QualityAnnotations.Good;
import me.kupchenko.model.QualityAnnotations.Ugly;
import me.kupchenko.model.User;

import java.util.Set;
import java.util.function.Supplier;

public class LazyCalculationsImprovePerformance {
    @Ugly
    static class LoggingWithAdditionalCheckToAvoidCalculations {
        private static final Log LOG = null; // init logger with factory

        public void sendWelcomeEmailToUsers(Set<User> users) {
            // send email
            if (LOG.isDebugEnabled()) {
                LOG.debug("Emails have been sent for users: " + users);
            }
        }

        interface Log {
            void debug(String message);

            boolean isDebugEnabled();
        }
    }

    @Good
    static class PassLambdaToLazyCalculateValueForLogMessage {
        private static final Log LOG = null; // init logger with factory

        public void sendWelcomeEmailToUsers(Set<User> users) {
            // send email
            LOG.debug(() -> "Emails have been sent for users: " + users);
        }

        interface Log {
            void debug(String message);

            boolean isDebugEnabled();

            default void debug(Supplier<String> message) {
                if (isDebugEnabled()) {
                    debug(message.get());
                }
            }
        }

        String getUserString(Set<User> users) {
            System.out.println("Converting users to string ");
            return users.toString();
        }
    }
}
