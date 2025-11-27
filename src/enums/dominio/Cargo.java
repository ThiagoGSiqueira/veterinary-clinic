package enums;

public enum Cargo {
    CLIENTE,
    VETERINARIO,
    ADMIN;

    public static Cargo fromString(String cargo) {
        return Cargo.valueOf(cargo.toUpperCase());
    }
}
