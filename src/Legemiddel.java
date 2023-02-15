public abstract class Legemiddel {
    public final String navn;
    // revise can't be right
    public static int amountOfObjects = 0;
    public int id;
    public int pris;
    public final double virkestoff;
    public Legemiddel(String navn, int pris, double virkestoff) {
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
        return "Navn: " + navn + " pris: " + pris + " virkestoff: " + virkestoff + " id: " + id;
    }
}