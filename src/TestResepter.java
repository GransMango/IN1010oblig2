public class TestResepter {
    private final HvitResept hvitResept;
    private final BlåResept blåResept;
    private final MilResept milResept;
    private final PResept pResept;
    private final PResept pReseptUnder100;
    private final Narkotisk narkotiskLegemiddel;
    private final Vanedannende vanedannendeLegemiddel;
    private final Vanlig vanligLegemiddel;
    private final Vanlig vanligLegemiddel2;
    private final Lege lege;
    public TestResepter() {
        lege = new Lege("Pål");
        narkotiskLegemiddel = new Narkotisk(3, 3, "testnarko", 200);
        vanedannendeLegemiddel = new Vanedannende(3, 3, "testvane", 300);
        vanligLegemiddel = new Vanlig("Vanlig", 3, 400);
        vanligLegemiddel2 = new Vanlig("Under 100kr", 3, 100);
        hvitResept = new HvitResept(narkotiskLegemiddel, lege, "p32", 3);
        blåResept = new BlåResept(vanedannendeLegemiddel, lege, "p12", 2);
        milResept = new MilResept(vanligLegemiddel, lege, "p1");
        pResept = new PResept(narkotiskLegemiddel, lege, "p003", 4);
        pReseptUnder100 = new PResept(vanligLegemiddel2, lege, "p003", 4);

    }

    private boolean testHvitResept() {
        return hvitResept.prisAaBetale() == narkotiskLegemiddel.hentPris();

    }
    private boolean testBlåResept() {
        return blåResept.prisAaBetale() == (int) Math.round(vanedannendeLegemiddel.hentPris() / 0.25);
    }

    private boolean testMilResept() {
        return milResept.prisAaBetale() == 0;
    }
    private boolean testMilReseptReit() {
        return milResept.reit == 3;
    }

    private boolean testMilReseptReitUseOnce() {
        if (milResept.bruk()) {
            return milResept.reit == 2;
            }
        return false;
    }
    private boolean testMilReseptReitEmpy() {
        milResept.reit = 3;
        milResept.bruk();
        milResept.bruk();
        milResept.bruk();
        return !milResept.bruk();
    }

    private boolean testPResept() {
        return pResept.prisAaBetale() == narkotiskLegemiddel.hentPris() - 108;
    }

    private boolean testPReseptOnlyPositive() {
        return pReseptUnder100.prisAaBetale() >= 0;
    }

    public void testAll() {
        int passed = 8;
        if (! testHvitResept()) {
            System.out.println("Hvit resept priced wrong, expected: " + narkotiskLegemiddel.hentPris() + " got: " + hvitResept.prisAaBetale());
            passed--;
        }
        if (! testBlåResept()) {
            System.out.println("Blå resept priced wrong, expected: " + (int) Math.round(vanedannendeLegemiddel.hentPris() * 0.25) + " got: " + blåResept.prisAaBetale());
            passed--;
        }
        if (! testMilResept()) {
            System.out.println("Mil resept priced wrong, expected: " + 0 + " got: " + milResept.prisAaBetale());
            passed--;
        }
        if (! testMilReseptReit()) {
            System.out.println("Mil reit is wrong, expected: " + 3 + " got: " + milResept.reit);
            passed--;
        }
        if (! testPResept()) {
            System.out.println("P resept priced wrong, expected: " + (narkotiskLegemiddel.hentPris() - 108) + " got: " + pResept.prisAaBetale());
            passed--;
        }
        if (! testPReseptOnlyPositive()) {
            System.out.println("P resept priced wrong, expected value above 0, got: " + pReseptUnder100.prisAaBetale());
            passed--;
        }
        if (! testMilReseptReitUseOnce()) {
            System.out.println("Mil reit returnered false with one use, expected true");
            passed--;
        }
        if (! testMilReseptReitEmpy()) {
            System.out.println("Mil reit returned true when empty, expected false");
            passed--;
        }
        System.out.println(passed + "/8 tests passed");
    }
}
