package evento;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestConcerto {
    public static void main(String[] args) {
        

        Concerto c = new Concerto("Concerto dei Coldplay ", LocalDate.of(2026, 12, 10), 500, LocalTime.of(20, 30), 59.99);



        // Testiamo i metodi
        System.out.println("Data e ora formattati: " + c.getDataOraFormattata());
        System.out.println("Titolo: " + c.getTitolo());
        System.out.println("Prezzo formattato: " + c.getPrezzoFormattato());

        System.out.println("Concerto: " + c.toString());

        // Modifichiamo con i setter per testare
        c.setOra(LocalTime.of(21, 00));
        c.setPrezzo(124.99);
        c.setData(LocalDate.of(2030, 01, 03));
        c.setTitolo("Corso di Uncinetto ");

        System.out.println("\nDati aggiornati dopo le modifiche: \n");
        System.out.println("Data e ora: " + c.getDataOraFormattata());
        System.out.println("Prezzo: " + c.getPrezzoFormattato());
        System.out.println("Nuovo evento: " + c.getTitolo());

        System.out.println("Evento modificato: " + c.toString());


    }
}
