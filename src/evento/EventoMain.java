package evento;


import java.time.LocalDate;
import java.util.Scanner;

// Step 2
// Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento con tutti i parametri.

// Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle, implementando opportuni controlli
// Stampare a video il numero di posti prenotati e quelli disponibili
// Chiedere all’utente se e quanti posti vuole disdire
// Provare ad effettuare le disdette, implementando opportuni controlli
// Stampare a video il numero di posti prenotati e quelli disponibili



public class EventoMain {
    public static void main(String[] args) {
        

        Scanner scan = new Scanner(System.in);

        // Chiediamo all'utente i dati da inserire per creare il nuovo Evento
        System.out.println("Inserisci in titolo dell'evento: ");
        String titolo = scan.nextLine();

        System.out.println("Inserisci la data dell'evento (gg/mm/aaaa): ");
        String dataInput = scan.nextLine();
        String[] array = dataInput.split("/");
        int giorno = Integer.parseInt(array[0]);
        int mese = Integer.parseInt(array[1]);
        int anno = Integer.parseInt(array[2]);
        LocalDate dataEvento = LocalDate.of(anno, mese, giorno);
        
        System.out.println("Inserisci il numero di posti totali all'evento: ");
        int postiTotali = scan.nextInt();

        // Creiamo l'oggetto Evento
        Evento e1 = new Evento(titolo, dataEvento, postiTotali);


        // Prenotazioni
        System.out.println("Inserisci il numero di posti da prenotare: ");
        int quantiPrenotare = scan.nextInt();

        for (int i = 0; i < quantiPrenotare; i++) {
            e1.prenota();
        }
        System.out.println("Posti prenotati: " + e1.getNumeroPostiPrenotati());
        System.out.println("Posti disponibili: " + (e1.getNumeroPostiTotali() - e1.getNumeroPostiPrenotati()));


        // Disdici
        System.out.println("Quanti posti desideri disdire: ");
        int quanteDisdette = scan.nextInt();

        for (int i = 0; i < quanteDisdette; i++) {
            e1.disdici();
        }
        System.out.println("Posti prenotati: " + e1.getNumeroPostiPrenotati());
        System.out.println("Posti disponibili: " + (e1.getNumeroPostiTotali() - e1.getNumeroPostiPrenotati()));


        // Evento
        System.out.println("Evento: " + e1.toString());







    }
}
