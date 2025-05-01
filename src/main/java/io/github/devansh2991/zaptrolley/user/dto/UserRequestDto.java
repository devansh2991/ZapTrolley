package io.github.devansh2991.zaptrolley.user.dto;

import io.github.devansh2991.zaptrolley.user.model.User;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private Long userId;
    private String username;
    private String email;
    private String address;
    private String phone;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static UserRequestDto toDto(User user) {
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setUserId(user.getUserId());
        userRequestDto.setUsername(user.getUsername());
        userRequestDto.setEmail(user.getEmail());
        userRequestDto.setAddress(user.getAddress());
        userRequestDto.setPhone(user.getPhone());

        return userRequestDto;
    }

    public static User toEntity(UserRequestDto userRequestDto) {
        User userEntity = new User();
        userEntity.setUserId(userRequestDto.getUserId());
        userEntity.setUsername(userRequestDto.getUsername());
        userEntity.setEmail(userRequestDto.getEmail());
        userEntity.setAddress(userRequestDto.getAddress());
        userEntity.setPhone(userRequestDto.getPhone());

        return userEntity;
    }
}
