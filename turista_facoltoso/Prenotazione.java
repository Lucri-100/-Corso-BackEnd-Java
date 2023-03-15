package turista_facoltoso;

import java.time.LocalDate;

public class Prenotazione {
    private double costo;
    private int ID;
    private int ID_abitazione;
    private int ID_cliente;
    private LocalDate data_inizio;
    private LocalDate data_fine;

    public Prenotazione(int ID_abitazione, int ID_cliente, LocalDate data_inizio, LocalDate data_fine) {
        this.ID_abitazione = ID_abitazione;
        this.ID_cliente = ID_cliente;
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        ID = data_inizio.hashCode() + Integer.toString(ID_cliente).hashCode();

        if (ID < 0)
            ID *= -1;
        costo=30.0;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    public int getIDAbitazione() {
        return ID_abitazione;
    }

    public LocalDate getDataInizio() {
        return data_inizio;
    }

    public LocalDate getDataFine() {
        return data_fine;
    }

    public int getID_cliente() {
        return ID_cliente;
    }
    @Override
    public String toString() {
        return "ID prenotazione: " +ID+ "\nID Cliente: " +ID_cliente+ "\nID abitazione: " +ID_abitazione+ "\nPeriodo: " +data_inizio+ " - " +data_fine;
    }
}