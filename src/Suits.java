public enum Suits {
    HARTEN ("rood"),
    KLAVER ("zwart"),
    SCHOPPEN("zwart"),
    RUITEN ("rood");

    public final String colour;

    private Suits(String colour){
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }
}
