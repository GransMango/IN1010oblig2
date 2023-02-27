public abstract class Legemiddel {
    public final String navn;
    public static int amountOfObjects = 0;
    public final int id;
    private int pris;
    public final double virkestoff;
    public Legemiddel(String navn, int pris, double virkestoff) throws IllegalArgumentException {
        // legemidler kan ikke koste mindre enn 0.
        if (pris < 0) {
            throw new IllegalArgumentException("Pris kan ikke være negativ");
        }
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        id = amountOfObjects;
        amountOfObjects++;
    }

    public int hentPris() {
        return pris;
    }

    public void settNyPris(int nyPris) {
        pris = nyPris;
    }

    @Override
    public String toString() {
        return "Navn: " + navn + ", pris: " + pris + ", virkestoff: " + virkestoff + ", id: " + id;
    }
}
