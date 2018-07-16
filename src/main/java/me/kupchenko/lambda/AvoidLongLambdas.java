package me.kupchenko.lambda;

import me.kupchenko.model.QualityAnnotations.Good;
import me.kupchenko.model.QualityAnnotations.CabBeBetter;
import me.kupchenko.model.User;
import me.kupchenko.model.dto.UserDto;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class AvoidLongLambdas {
    @CabBeBetter
    class LongLambdaInPlace {
        public List<UserDto> convertToDto(List<User> users){
            return users.stream()
                    .map(user -> {
                        UserDto dto = new UserDto();
                        dto.setId(user.getId());
                        dto.setName(user.getName());
                        //it happens to be much more fields and much more logic in terms of remapping these fields
                        return dto;
                    })
                    .collect(toList());
        }
    }

    @Good("Mapping logic can be extracted and can be used in streatm().map(...) method")
    class MethodReferenceInsteadOfLambda {
        //particular toDto could be implemented as a separate class or as a lambda function
        private final Function<User, UserDto> toDto = this::convertToDto;

        public List<UserDto> convertToDto(List<User> users){
            return users.stream()
                    .map(toDto)
                    .collect(toList());
        }

        private UserDto convertToDto(User user){
            UserDto dto = new UserDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            return dto;
        }
    }
}
