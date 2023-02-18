public class BlåResept extends Resept{
    public BlåResept(Legemiddel legemiddel, Lege lege, String pasientId, int reit) {
        super(legemiddel, lege, pasientId, reit);
    }

    @Override
    public String farge() {
        return "Blå";
    }

    @Override
    public int prisAaBetale() {
        return (int) Math.round(legemiddel.hentPris() / 0.25);
    }
}
