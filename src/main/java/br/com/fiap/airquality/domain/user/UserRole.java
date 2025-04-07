package br.com.fiap.airquality.domain.user;

public enum UserRole {

    ADMIN("admin"),
    MONITOR("monitor");

    private String role;


    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
