public class Vanedannende extends Legemiddel{
    public final int vanedannende;
    public Vanedannende(int vanedannende, double virkestoff, String navn, int pris) {
        super(navn, pris, virkestoff);
        this.vanedannende = vanedannende;
    }
}
