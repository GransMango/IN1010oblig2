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
        testIllegalPrice();
        testUniqueId();
        testSettPris();
        testHentPris();
    }

    private void testIllegalPrice() {
        try {
            narkotisk = new Narkotisk(3, 4, "testnarko", -1);
            System.out.println("testIllegalPrice wrong, object created");
        } catch (IllegalArgumentException e) {
        }
    }

    private void testSettPris() {
        Narkotisk testNarkotisk = new Narkotisk(5, 5, "testNarko", 100);
        testNarkotisk.settNyPris(150);
        assert(testNarkotisk.hentPris() == 150);
    }

    private void testHentPris() {
        Narkotisk testNarkotisk = new Narkotisk(5, 5, "testNarko", 100);
        assert(testNarkotisk.hentPris() == 100);
    }

    private void testUniqueId() {
        List<Legemiddel> legemidler = new ArrayList<>(Arrays.asList(narkotisk, vanedannende, vanlig));
        assert(legemidler.size() == legemidler.stream().map(id -> id.id).distinct().count());

    }



}
