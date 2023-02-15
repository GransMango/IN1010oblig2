public class PResept extends HvitResept{
    public PResept(Legemiddel legemiddel, Lege lege, String pasientId, int reit) {
        super(legemiddel, lege, pasientId, reit);
    }
    @Override
    public int prisAaBetale() {
        if (legemiddel.pris >= 108) {
            return legemiddel.pris - 108;
        }
        return 0;
    }
}
