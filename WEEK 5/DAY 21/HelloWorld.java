import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
    String value();
}

// Classe principale
public class HelloWorld {
    // Utilizzo dell'annotazione
    @MyAnnotation(value = "Hello, world!")
    public void sayHello() {
        System.out.println("Questo metodo è annotato con @MyAnnotation");
    }

    public static void main(String[] args) throws Exception {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
        // Riflettiamo sulla presenza dell'annotazione
        Method method = HelloWorld.class.getMethod("sayHello");
        // Verifica se l'annotazione è presente
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            // Ottieni l'annotazione
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            // Stampa il valore dell'annotazione
            System.out.println("Valore dell'annotazione: " + annotation.value());
        }
    }
}