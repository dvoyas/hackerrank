public enum Direction {
    EAST("E"),
    WEST("W");

    Direction(String code){
        this.shortCode = code;
    }

    private final String shortCode;
}
