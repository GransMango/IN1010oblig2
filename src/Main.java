public class Main {
    public static void main(String[] args) {
        TestLegemiddel test = new TestLegemiddel();

        Lege pål = new Lege("Pål");
        Lege kristine = new Spesialist("Kristine", "a01");
        Vanedannende stesolid = new Vanedannende(5, 30, "stesoild", 250);
        Narkotisk oxycontin = new Narkotisk(10, 30, "oxycontin", 250);
        Vanlig paracet = new Vanlig("Paracet", 40, 500);
        PResept pResept = new PResept(paracet, pål, "pip", 5);
        MilResept milResept = new MilResept(oxycontin, kristine, "kato");
        BlåResept blåResept = new BlåResept(stesolid, pål, "knut", 2);

        System.out.println(pål +"\n");
        System.out.println(kristine +"\n");
        System.out.println(stesolid +"\n");
        System.out.println(oxycontin +"\n");
        System.out.println(paracet +"\n");
        System.out.println("pResept\n" + pResept);
        System.out.println("milresept\n" + milResept);
        System.out.println("Blå resept\n" + blåResept);
        System.out.println("Blå resept pris: " + blåResept.prisAaBetale() + "\n");
        System.out.println("pResept pris: " + pResept.prisAaBetale() + "\n");
        System.out.println("milresept pris: " + milResept.prisAaBetale() + "\n");

    }
}