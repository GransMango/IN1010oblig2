public class Lege {
    private final String navn;
    public Lege(String navn) {
        this.navn = navn;
    }
    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return "Legens navn: " + navn;
    }
}
