import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Stack pilaAcciones = new Stack(50);
        Stack pilaDeshechas = new Stack(50);

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar texto actual");
            System.out.println("5. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el texto: ");
                    String texto = scanner.nextLine();
                    pilaAcciones.push(texto);
                    pilaDeshechas = new Stack(50);
                    System.out.println("Texto agregado: \"" + texto + "\"");
                    break;
                case 2:
                    if (pilaAcciones.isEmpty()) {
                        System.out.println("No hay acciones para deshacer.");
                    } else {
                        String deshecho = pilaAcciones.pop();
                        pilaDeshechas.push(deshecho);
                        System.out.println("Deshecho: \"" + deshecho + "\"");
                    }
                    break;
                case 3:
                    if (pilaDeshechas.isEmpty()) {
                        System.out.println("No hay acciones para rehacer.");
                    } else {
                        String rehecho = pilaDeshechas.pop();
                        pilaAcciones.push(rehecho);
                        System.out.println("Rehecho: \"" + rehecho + "\"");
                    }
                    break;
                case 4:
                    System.out.println("Texto actual en el editor:");
                    pilaAcciones.mostrarPila();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}