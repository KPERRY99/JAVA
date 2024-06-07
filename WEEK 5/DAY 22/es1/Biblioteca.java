
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Biblioteca {
    private static Map<String, Integer> libriPrestati;
    private static Map<String, Integer> libriDisponibili = new HashMap<>();
    int copieDisponibili;
    int prestito; 

    public Biblioteca(int copieDisponibili, int prestito){
        this.copieDisponibili = copieDisponibili;
        this.prestito = prestito;
    }


    static{
        libriDisponibili = new HashMap<>();
        libriDisponibili.put("Pinocchio", 5);
        libriDisponibili.put("Cenerentola", 4);
        libriDisponibili.put("Maleficent", 3);
        libriDisponibili.put("Narnia", 4);
        libriDisponibili.put("Pannacotta", 10);
    }

    public Biblioteca(){

    }

   
    public void prestaLibro(String book){
        
        if(libriDisponibili.get(book)>0){
            
            libriDisponibili.put(book, libriDisponibili.get(book)-1);
            if(libriPrestati.containsValue(book)){
                libriPrestati.put(book, libriPrestati.get(book)+1);
            }
            else{
                libriPrestati.put(book, 1);
            }
        }else{
            System.err.println("Non ci sono più libri disponibili.");
        }
    }

    public void restituisciLibro(String book){
        if(libriPrestati.equals(book)){
            libriPrestati.put(book, libriPrestati.get(book)-1);
            if(libriDisponibili.equals(book)){
                libriDisponibili.put(book, libriDisponibili.get(book)+1);
            }else{
                System.out.println("Libro non presente");
            }
        }
    }
    
    public void aggiungiLibro(String book, int numero){
        if(libriDisponibili.equals(book)){
            System.out.println("Libro già presente!");
        }
        else{
            libriDisponibili.put(book, numero);
        }
    }
    
    public void rimuoviLibro(String book){
        if(libriDisponibili.equals(book)){
            libriDisponibili.remove(book);
        }
    }

    public void stampaLibriDisponibili(){
        System.out.println(libriDisponibili);
    }

    public void stampaLibriPresi(){
        System.out.println(libriPrestati);
    }


}



