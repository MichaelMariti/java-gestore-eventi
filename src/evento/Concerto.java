package evento;

// Step 3
// Creare una classe Concerto che estende Evento, che ha anche gli attributi :
//  - ora (LocalTime)
//  - prezzo

// Aggiungere questi attributi nel costruttore e implementarne getter e setter.

// Aggiungere i metodi per restituire data e ora formattata e prezzo formattato (##,##€) Fare l’ override del metodo toString() in modo che venga restituita una stringa del tipo: data e ora formattata - titolo - prezzo formattato

// Testare la classe Concerto, utilizzando TUTTI i suoi metodi.

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

    private double prezzo;

    private LocalTime ora;

    public Concerto(String titolo, LocalDate data, int numeroPostiTotali, LocalTime ora, double prezzo) {
        super(titolo, data, numeroPostiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }



    // Getters & Setters
    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }



    // Metodo per restituire data e ora formattata
    public String getDataOraFormattata() {
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterOra = DateTimeFormatter.ofPattern("HH:mm");
        return getData().format(formatterData) + " - " + ora.format(formatterOra);
    }

    // Metodo per restituire il prezzo formattato
    public String getPrezzoFormattato() {
        return String.format("%.2fEuro", prezzo);
    }


    @Override
    public String toString() {
        return getDataOraFormattata() + " - " + getTitolo() + getPrezzoFormattato();
    }
}
