public class BlåResept extends Resept{
    public BlåResept(Legemiddel legemiddel, Lege lege, String pasientId, int reit) {
        super(legemiddel, lege, pasientId, reit);
    }

    @Override
    public String farge() {
        return "Blå";
    }

    // Velger å gjøre prislogikken i prisAaBetale, fremfor å endre legemiddelet sin pris variabel.
    // Grunnen er at man må lage like mange legemidler som man har resept klasser, selvom innholdet er helt likt utenom pris.
    @Override
    public int prisAaBetale() {
        return (int) Math.round(legemiddel.hentPris() * 0.25);
    }

}
