public class TestLegemiddel {
    Narkotisk narkotisk;
    Vanedannende vanedannende;
    Vanlig vanlig;
    public TestLegemiddel() {
        narkotisk = new Narkotisk(3, 3, "testnarko", 4);
        vanedannende = new Vanedannende(3, 3, "testvane", 4);
        vanlig = new Vanlig("Vanlig", 3, 3);
        UniqueId();
    }

    public void UniqueId() {
        boolean result = true;
        if (narkotisk.id == vanedannende.id) {
            result = false;
            System.out.println("Narkotisk id should not equal vanedannende id");
        } else if (narkotisk.id == vanlig.id) {
            result = false;
            System.out.println("Narkotisk id should not equal vanlig id");
        } else if (vanedannende.id == vanlig.id) {
            result = false;
            System.out.println("Vanedannende id should not equal vanlig id");
        }
        if (result) {
            System.out.println("Test passed!");
        }
    }



}
