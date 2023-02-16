public class Main {
    public static void main(String[] args) {
        Lege pål = new Lege("Pål");
        Lege kristine = new Spesialist("Kristine", "a01");
        Vanedannende stesolid = new Vanedannende(5, 30, "stesoild", 250);
        Narkotisk oxycontin = new Narkotisk(10, 30, "oxycontin", 250);
        Vanlig paracet = new Vanlig("Paracet", 40, 500);
        PResept pResept = new PResept(paracet, pål, "pip", 5);
        MilResept milResept = new MilResept(oxycontin, kristine, "kato");
        BlåResept blåResept = new BlåResept(stesolid, pål, "knut", 2);
        
    }
}