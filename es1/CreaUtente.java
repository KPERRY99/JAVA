import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import java.util.Scanner;

public class CreaUtente implements Utente {
    static String nome;
    static String cognome;
    static String email;
    static int age;
    

    public CreaUtente(String nome, String cognome, String email, int age){
        
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.age = age;
    }

    public String toString(){
        String info;
        info = "DATI PERSONALI:\nNome: " + nome + "\tCognome: " +  cognome +"\tEmail: "+ email +"\tEtà: " + age;

        return info;
    }

    public static CreaUtente createUser(Scanner stringa, Scanner numero){
        boolean run = false;
        String nome;
        do {
            System.out.print("Inserisci il nome:");
            nome = stringa.nextLine();
            
            if(nome.isEmpty()){
                run = true;
            }
            else{
                run = false;
            }

        } while (run);

        boolean run2 = false;
        String cognome;
        do {
            System.out.print("Inserisci il cognome:");
            cognome = stringa.nextLine();
            
            if(cognome.isEmpty()){
                run2 = true;
            }
            else{
                run2 = false;
            }

        } while (run2);

        boolean run3 = false;
        String email;
        do {
            System.out.print("Inserisci il email:");
            email = stringa.nextLine();
            
            if(email.isEmpty()){
                run3 = true;
            }
            else{
                run3 = false;
            }

        } while (run3);

        boolean run4 = false;
        int eta = 0;
        do {
            System.out.print("Inserisci l'età:");
            eta = numero.nextInt();
            if(eta<=0){
                run4 = true;
            }
            else{
                run4 = false;
            }

        } while (run4);

    
        CreaUtente nuovoUtente = new CreaUtente(nome, cognome, email, eta);
        return nuovoUtente;
    }

    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);

        CreaUtente nuovo = createUser(tastiera, keyboard);
        
        String info = nuovo.toString();
        System.out.println(info);

        SerializeXML(nuovo);

        tastiera.close();
        keyboard.close();
    }

    public static void SerializeXML(CreaUtente user) {
        try {
            // Creare una fabbrica di costruttori di documenti
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            // Creare un costruttore di documenti
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            // Definire un nuovo documento
            Document document = documentBuilder.newDocument();

            // Creare l'elemento radice
            Element root = document.createElement("company");
            document.appendChild(root);

            // Creare un elemento figlio
            Element employee = document.createElement("employee");

            root.appendChild(employee);

            // Aggiungere un attributo all'elemento employee
            employee.setAttribute("id", "1");

            // Creare e aggiungere i sotto-elementi a employee
            Element firstName = document.createElement("firstname");
            firstName.appendChild(document.createTextNode(CreaUtente.nome));
            employee.appendChild(firstName);

            Element lastName = document.createElement("lastname");
            lastName.appendChild(document.createTextNode(CreaUtente.cognome));
            employee.appendChild(lastName);

            Element email = document.createElement("email");
            email.appendChild(document.createTextNode(CreaUtente.email));
            employee.appendChild(email);

            // Element eta = document.createElement("età");
            // eta.appendChild(document.createTextNode(CreaUtente.age));
            // employee.appendChild(email);

            // Creare l'istanza di TransformerFactory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);

            // Creare il file XML
            StreamResult streamResult = new StreamResult(new File("employees.xml"));

            // Trasformare il DOM in un file XML
            transformer.transform(domSource, streamResult);

            System.out.println("File XML creato con successo!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
        
    }

}
