import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CustomQueue<T> {
    
    private LinkedList<T> queue;

    
    public CustomQueue() {
        queue = new LinkedList<>();
    }

    
    public void enqueue(T element) {
        queue.addLast(element);
    }

    
    public T dequeue() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("La cola esta vacia.");
        }
        return queue.removeFirst();
    }

    
    public T peek() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("La cola esta vacia.");
        }
        return queue.getFirst();
    }

    
    public int count() {
        return queue.size();
    }

   
    public void clear() {
        queue.clear();
    }

    
    public T getFirst() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("La cola esta vacia.");
        }
        return queue.getFirst();
    }

    
    public T getLast() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("La cola esta vacía.");
        }
        return queue.getLast();
    }

    
    public LinkedList<T> getAll() {
        return new LinkedList<>(queue);
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomQueue<Object> queue = new CustomQueue<>();

        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("\nQué te gustaria hacer?");
            System.out.println("1. Enqueue (Agregar a la cola)");
            System.out.println("2. Dequeue (Remover de la cola)");
            System.out.println("3. Peek (Ver el primer elemento)");
            System.out.println("4. Mostrar todos los elementos");
            System.out.println("5. Limpiar la cola");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción (1-6): ");
            
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Ingresa el valor (puede ser String, numero entero o decimal): ");
                    String input = scanner.nextLine();
                    

                    try {
                        if (input.contains(".")) {
                            queue.enqueue(Double.parseDouble(input));  
                        } else {
                            queue.enqueue(Integer.parseInt(input));  
                        }
                    } catch (NumberFormatException e) {
                        queue.enqueue(input); 
                    }
                    System.out.println("Elemento agregado a la cola.");
                    break;

                case 2:
                    try {
                        Object removedElement = queue.dequeue();
                        System.out.println("Elemento removido: " + removedElement);
                    } catch (NoSuchElementException e) {
                        System.out.println("La cola esta vacia, no se puede remover ningun elemento.");
                    }
                    break;

                case 3:
                    try {
                        System.out.println("El primer elemento es: " + queue.peek());
                    } catch (NoSuchElementException e) {
                        System.out.println("La cola esta vacia.");
                    }
                    break;

                case 4:
                    System.out.println("Elementos en la cola: " + queue.getAll());
                    break;

                case 5:
                    queue.clear();
                    System.out.println("Cola vaciada.");
                    break;

                case 6:
                    continueProgram = false;
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no valida. Intentalo de nuevo.");
            }

            
            System.out.println("Estado actual de la cola: " + queue.getAll());
        }

        scanner.close();
    }
}
