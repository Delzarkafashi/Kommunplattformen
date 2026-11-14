public class Main {
    public static void main(String[] args) {
        Enhet bibliotek = new Enhet("Biblioteket");
        Medarbetare medarbetare = new Medarbetare("Kim");
        Medarbetare ansvarig = new Handlaggare("Sam");
        Avvikelse forsta = new Avvikelse("Trasig lampa", "Öppen", bibliotek, medarbetare);
        Avvikelse andra = new Avvikelse("Trasig dörr", "Avslutad", bibliotek, ansvarig);

        AvvikelseService service = new AvvikelseService();
        System.out.println("Antal från start: " + service.antal());
        service.skrivOversikt();
        service.laggTill(forsta);
        System.out.println("Efter första: " + service.antal());
        service.laggTill(andra);
        System.out.println("Efter andra: " + service.antal());
        service.skrivOversikt();
        service.skrivMedStatus("Öppen");
        System.out.println("Öppna: " + service.antalMedStatus("Öppen"));
        System.out.println("Avslutade: " + service.antalMedStatus("Avslutad"));
        System.out.println("Alla: " + service.antal());

        System.out.println(forsta.getBeskrivning());
        System.out.println(forsta.getStatus());

        forsta.uppdateraStatus("Okänd");
        System.out.println(forsta.getStatus());

        forsta.uppdateraStatus("Avslutad");
        System.out.println(forsta.hamtaText());
        System.out.println(andra.hamtaText());

        System.out.println(medarbetare.presentera());
        System.out.println(ansvarig.presentera());
    }
}

class Medarbetare {
    private String namn;

    public Medarbetare(String namn) {
        this.namn = namn;
    }

    public String getNamn() {
        return namn;
    }

    public String presentera() {
        return "Medarbetare: " + getNamn();
    }
}

class Handlaggare extends Medarbetare {
    public Handlaggare(String namn) {
        super(namn);
    }

    @Override
    public String presentera() {
        return "Handläggare: " + getNamn();
    }
}
