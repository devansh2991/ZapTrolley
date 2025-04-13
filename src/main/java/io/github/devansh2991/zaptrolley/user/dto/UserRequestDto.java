package io.github.devansh2991.zaptrolley.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String username;
    private String email;
    private String address;
}
