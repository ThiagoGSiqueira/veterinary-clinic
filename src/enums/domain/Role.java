package enums.domain;

public enum Role {
    CLIENT,
    VETERINARIAN,
    ADMIN;

    public static Role fromString(String role) {
        return Role.valueOf(role.toUpperCase());
    }

    public static Role fromOption(int roleOption) {
        switch (roleOption) {
            case 1:
                return Role.CLIENT;
            case 2:
                return Role.VETERINARIAN;
            case 3:
                return Role.ADMIN;
            default:
                return null;
        }
    }
}
