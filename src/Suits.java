public enum Suits {
    HARTEN ("rood"),
    KLAVER ("zwart"),
    SCHOPPEN(" zwart"),
    RUITEN ("rood");

    public final String kleur;

    private Suits(String kleur){
        this.kleur = kleur;
    }
}
