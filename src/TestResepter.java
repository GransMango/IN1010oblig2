public class TestResepter {
    private HvitResept hvitResept;
    private BlåResept blåResept;
    private MilResept milResept;
    private PResept pResept;
    private PResept pReseptUnder100;
    private Narkotisk narkotiskLegemiddel;
    private Vanedannende vanedannendeLegemiddel;
    private Vanlig vanligLegemiddel;
    private Vanlig vanligLegemiddel2;
    private Lege lege;
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

    private boolean hvitReseptTest() {
        return hvitResept.prisAaBetale() == narkotiskLegemiddel.pris;

    }
    private boolean blåReseptTest() {
        return blåResept.prisAaBetale() == (int) Math.round(vanedannendeLegemiddel.pris / 0.25);
    }

    private boolean milReseptTest() {
        return milResept.prisAaBetale() == 0;
    }
    private boolean milReseptReitTest() {
        return milResept.reit == 3;
    }

    private boolean milReseptReitUseOnceTest() {
        if (milResept.bruk()) {
            if (milResept.reit == 2) {
                return true;
            }
        }
        return false;
    }
    private boolean milReseptReitEmpyTest() {
        milResept.reit = 3;
        milResept.bruk();
        milResept.bruk();
        milResept.bruk();
        return !milResept.bruk();
    }

    private boolean pReseptTest() {
        return pResept.prisAaBetale() == narkotiskLegemiddel.pris - 108;
    }

    private boolean pReseptOnlyPositive() {
        return pReseptUnder100.prisAaBetale() >= 0;
    }

    public void testAll() {
        int passed = 8;
        if (! hvitReseptTest()) {
            System.out.println("Hvit resept priced wrong, expected: " + narkotiskLegemiddel.pris + " got: " + hvitResept.prisAaBetale());
            passed--;
        }
        if (! blåReseptTest()) {
            System.out.println("Blå resept priced wrong, expected: " + (int) Math.round(vanedannendeLegemiddel.pris / 0.25) + " got: " + blåResept.prisAaBetale());
            passed--;
        }
        if (! milReseptTest()) {
            System.out.println("Mil resept priced wrong, expected: " + 0 + " got: " + milResept.prisAaBetale());
            passed--;
        }
        if (! milReseptReitTest()) {
            System.out.println("Mil reit is wrong, expected: " + 3 + " got: " + milResept.reit);
            passed--;
        }
        if (! pReseptTest()) {
            System.out.println("P resept priced wrong, expected: " + (narkotiskLegemiddel.pris - 108) + " got: " + pResept.prisAaBetale());
            passed--;
        }
        if (! pReseptOnlyPositive()) {
            System.out.println("P resept priced wrong, expected value above 0, got: " + pReseptUnder100.prisAaBetale());
            passed--;
        }
        if (! milReseptReitUseOnceTest()) {
            System.out.println("Mil reit returnered false with one use, expected true");
            passed--;
        }
        if (! milReseptReitEmpyTest()) {
            System.out.println("Mil reit returned true when empty, expected false");
            passed--;
        }
        System.out.println(passed + "/8 tests passed");
    }
}
