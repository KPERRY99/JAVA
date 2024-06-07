import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     
        Biblioteca bb = new Biblioteca();
        String libro;
        int disp;

        Scanner tastiera = new Scanner(System.in);
        Scanner kk = new Scanner(System.in);
        boolean avvia = true;

        while(avvia){
            System.out.println("Benvenuto. Inserisci cosa vuoi fare: \n1.PRESITO LIBRO \n2.RESTITUIRE LIBRO \n3.Aggiungi libro \n4.Elimina libro \n5.Exit");
        int scelta = tastiera.nextInt();

        switch (scelta) {
            case 1:
                System.out.println("Inserisci il libro che vuoi prendere:");
                bb.stampaLibriDisponibili();
                libro = kk.nextLine();
                bb.prestaLibro(libro);
                System.out.println("\n");
                bb.stampaLibriDisponibili();
                System.out.println("\n");
                bb.stampaLibriPresi();
                break;
            
            case 2:
            System.out.println("Inserisci il libroche vuoi restituire:");
            bb.stampaLibriPresi();
            libro = kk.nextLine();
            bb.restituisciLibro(libro);
            System.out.println("\n");
            bb.stampaLibriPresi();
            System.out.println("\n");
            bb.stampaLibriDisponibili();
            break;

            case 3:
            System.out.println("Insersisci un libro da aggiungere: ");
            libro = kk.nextLine();
            disp = tastiera.nextInt();
            bb.aggiungiLibro(libro, disp);

            case 4:
            System.out.println("Inserisci un libro da eliminare: ");
            bb.stampaLibriDisponibili();
            libro = kk.nextLine();

            bb.rimuoviLibro(libro);
            System.out.println("\n");
            bb.stampaLibriDisponibili();
            break;

            case 5:
            avvia = false;

            default:
            System.err.println("Operazione non disponibile.");
                break;
        }
        }

        System.out.println("Arrivederci");

    }
}
