public class HvitResept extends Resept{
    public HvitResept(Legemiddel legemiddel, Lege lege, String pasientId, int reit) {
        super(legemiddel, lege, pasientId, reit);
    }

    @Override
    public String farge() {
        return "Hvit";
    }

    @Override
    public int prisAaBetale() {
        return legemiddel.hentPris();
    }
}
