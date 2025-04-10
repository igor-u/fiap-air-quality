package br.com.fiap.airquality.domain.user.dto;

import br.com.fiap.airquality.domain.user.User;
import br.com.fiap.airquality.domain.user.UserRole;

import java.util.UUID;

public record ShowUserDTO(
        UUID id,

        String name,

        String email,

        UserRole role) {
    public ShowUserDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getRole());
    }
}
