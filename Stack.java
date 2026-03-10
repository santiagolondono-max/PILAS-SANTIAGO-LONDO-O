public class Stack {

    private String[] elementos;
    private int tope;
    private int capacidad;

    public Stack(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new String[capacidad];
        this.tope = -1;
    }

    public void push(String valor) {
        if (tope == capacidad - 1) {
            System.out.println("La pila está llena.");
            return;
        }
        tope++;
        elementos[tope] = valor;
    }

    public String pop() {
        if (isEmpty()) return null;
        String valor = elementos[tope];
        elementos[tope] = null;
        tope--;
        return valor;
    }

    public String peek() {
        if (isEmpty()) return null;
        return elementos[tope];
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public void mostrarPila() {
        if (isEmpty()) {
            System.out.println("  (vacía)");
            return;
        }
        for (int i = tope; i >= 0; i--) {
            System.out.println("  " + elementos[i]);
        }
    }
}