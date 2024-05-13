package com.PFE.booknetwork.dto;



import com.PFE.booknetwork.role.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class RoleDto {

    private Integer id;
    private String name;
    @JsonIgnore
    private List<UserDto> users;

    public RoleDto fromEntity(Role role){
        if (role == null){
            return null;
        }

       return RoleDto.builder()
               .id(role.getId())
               .name(role.getName())
               .build();
    }

    public Role toEntity(RoleDto roleDto){
        if (roleDto == null) {
            return null;
        }
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setName(roleDto.getName());

        return role;
    }


}
