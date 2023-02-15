public class MilResept extends HvitResept{
    public MilResept(Legemiddel legemiddel, Lege lege, String pasientId) {
        super(legemiddel, lege, pasientId, 3);
    }

    @Override
    public int prisAaBetale() {
        return 0;
    }
}
