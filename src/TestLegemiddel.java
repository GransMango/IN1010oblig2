import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestLegemiddel {
    Narkotisk narkotisk;
    Vanedannende vanedannende;
    Vanlig vanlig;
    public TestLegemiddel() {
        narkotisk = new Narkotisk(3, 3, "testnarko", 4);
        vanedannende = new Vanedannende(3, 3, "testvane", 4);
        vanlig = new Vanlig("Vanlig", 3, 3);
    }

    private boolean testIllegalPrice() {
        try {
            narkotisk = new Narkotisk(3, 4, "testnarko", -1);
            System.out.println("testIllegalPrice wrong, object created");
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private boolean testSettPris() {
        Narkotisk testNarkotisk = new Narkotisk(5, 5, "testNarko", 100);
        testNarkotisk.settNyPris(150);
        return testNarkotisk.hentPris() == 150;
    }

    private boolean testHentPris() {
        Narkotisk testNarkotisk = new Narkotisk(5, 5, "testNarko", 100);
        return testNarkotisk.hentPris() == 100;
    }

    private boolean testUniqueId() {
        List<Legemiddel> legemidler = new ArrayList<>(Arrays.asList(narkotisk, vanedannende, vanlig));
        System.out.println();
        return legemidler.size() == legemidler.stream().map(id -> id.id).distinct().count();

    }

    public void testAll() {
        int passed = 4;
        if (!testUniqueId()) {
            System.out.println("Unique id not achieved");
            passed--;
        }
        if (!testHentPris()) {
            System.out.println("HentPris unexpected behaviour");
            passed--;
        }
        if (!testSettPris()) {
            System.out.println("SettPris unexpected behaviour");
            passed--;
        }
        if (!testIllegalPrice()) {
            System.out.println("Illegal price");
            passed--;
        }
        System.out.println(passed + "/4 Legemiddel tests passed ");

    }



}
