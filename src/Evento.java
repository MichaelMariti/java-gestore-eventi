// Step 1
// Creare una classe Evento che abbia le seguenti proprietà:
//  - titolo
//  - data
//  - numero di posti in totale
//  - numero di posti prenotati

// Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore, tranne posti prenotati che va inizializzato a 0.

// Inserire il controllo che la data non sia già passata e che il numero di posti totali sia positivo. In caso contrario sollevare eccezione.

// Aggiungere metodi getter e setter in modo che:
// titolo sia in lettura e in scrittura
// data sia in lettura e scrittura
// numero di posti totale sia solo in lettura
// numero di posti prenotati sia solo in lettura

// Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:
// prenota: aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha posti disponibili deve sollevare eccezione.
// disdici: riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono prenotazioni solleva eccezione.

// l’override del metodo toString() in modo che venga restituita una stringa contenente: data formattata - titolo
// Aggiungete eventuali metodi (public e private) che vi aiutino a svolgere le funzioni richieste.



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    // Attributi di istanza della classe Evento
    private String titolo;

    private LocalDate data;

    private int numeroPostiTotali;

    private int numeroPostiPrenotati;



    // Costruttore (o metodo speciale)
    public Evento (String titolo, LocalDate data, int numeroPostiTotali) {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data non può essere nel passato.");
        }

        if (numeroPostiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }

        this.titolo = titolo;
        this.data = data;
        this.numeroPostiTotali = numeroPostiTotali;
        numeroPostiPrenotati = 0;
    }



    // Getters
    public String getTitolo() {
        return titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public int getNumeroPostiTotali() {
        return numeroPostiTotali;
    }

    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;
    }


    // Setters
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setData(LocalDate data) {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data non può essere nel passato");
        }
        this.data = data;
    }

    


    // Metodi
    public void prenota() {
        if (LocalDate.now().isAfter(data)) {
            throw new IllegalArgumentException("L'evento è già finito. Non si possono prenotare più i posti.");
        } else if (numeroPostiPrenotati >= numeroPostiTotali) {
            throw new IllegalArgumentException("Non ci sono più posti disponibili.");
        }
        numeroPostiPrenotati++;
    }

    public void disdici() {
        if (LocalDate.now().isAfter(data)) {
            throw new IllegalArgumentException("L'evento è terminato, non puoi più disdire.");
        } else if (numeroPostiPrenotati <= 0) {
            throw new IllegalArgumentException("Non c'è nessuna prenotazione da disdire.");
        }
        numeroPostiPrenotati--;
    }



    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        return data.format(formatter) + " - " + titolo;
    }
    



}
