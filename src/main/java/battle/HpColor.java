package battle;

public enum HpColor {
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    ORANGE("\u001B[38;5;208m"),
    RED("\u001B[31m"),
    RESET("\u001B[0m");

    private String ansiCode;

    HpColor(String ansiCode) {
        this.ansiCode = ansiCode.toString();
    }

    @Override
    public String toString() {
        return ansiCode;
    }

}
