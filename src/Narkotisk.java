public class Narkotisk extends Legemiddel{
    public final int styrke;
    public Narkotisk(int styrke, double virkestoff, String navn, int pris) {
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }
}
