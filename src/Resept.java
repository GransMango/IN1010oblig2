public abstract class Resept {
    public static int amountOfObjects = 0;
    public Legemiddel legemiddel;
    public Lege lege;
    public String pasientId;
    public int reit;
    public int id;
    public Resept(Legemiddel legemiddel, Lege lege, String pasientId, int reit) {
        this.legemiddel = legemiddel;
        this.lege = lege;
        this.pasientId = pasientId;
        this.reit = reit;
        id = amountOfObjects;
        amountOfObjects++;
    }

    public boolean bruk() {
        if (0 < reit) {
            reit--;
            return true;
        }
        return false;
    }

    abstract public String farge();

    abstract public int prisAaBetale();

}
