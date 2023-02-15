public class Vanedannende extends Legemiddel{
    public final int styrke;
    public Vanedannende(int styrke, double virkestoff, String navn, int pris) {
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }
}
