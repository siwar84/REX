package com.PFE.booknetwork.dto;




import com.PFE.booknetwork.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class UserDto {

    private Integer id;
    private String matricule;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;

    private String email;
    private String password;
    private boolean accountLocked;
    private boolean enabled;
    @JsonIgnore
    private List<RoleDto> roles;

    public UserDto fromEntity(User user){
        if (user == null){
            return null;
        }
        return UserDto.builder()
                .id(user.getId())
                .matricule(user.getMatricule())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .dateOfBirth(user.getDateOfBirth())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public User toEntity(UserDto userDto){
        if (userDto == null){
            return null;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setMatricule(userDto.getMatricule());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }

}
