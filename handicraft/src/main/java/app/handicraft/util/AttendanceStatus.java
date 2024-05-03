package app.handicraft.util;

public enum AttendanceStatus {
    ATTENDING("attending"),
    WILL_ATTEND("will attend"),
    PREVIOUSLY_ATTENDED("previously attended");

    private final String description;

    AttendanceStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
