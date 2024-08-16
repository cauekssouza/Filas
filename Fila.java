public class Fila {
    // Atributos
    private final FilmFila[] fila;
    private final int capacidade;
    private int frente, traseira, tamanho;

    // Construtor
    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.fila = new FilmFila[capacidade]; // Array para armazenar FilmFila
        this.frente = 0;
        this.traseira = -1;
        this.tamanho = 0;
    }

    /* Métodos */

    // Verificar se a fila está vazia
    public boolean Vazia() {
        return tamanho == 0;
    }

    // Verificar se a fila está cheia
    public boolean Cheia() {
        return tamanho == capacidade;
    }

    // Enfileirar um item
    public void enfileirar(FilmFila item) {
        if (Cheia()) {
            System.out.println("A fila está cheia!");
            return;
        }
        traseira = (traseira + 1) % capacidade; // Incremento da traseira
        fila[traseira] = item; // Adiciona o novo item à fila
        tamanho++; // Incrementa o tamanho da fila
        System.out.println(item.getTitulo() + " foi enfileirado.");
    }

    // Desenfileirar um item
    public FilmFila desenfileirar() {
        if (Vazia()) {
            System.out.println("A fila está vazia");
            return null; // Retorna null se a fila estiver vazia
        }
        FilmFila item = fila[frente]; // Obtém o item na frente da fila
        frente = (frente + 1) % capacidade; // Incremento da frente
        tamanho--; // Diminui o tamanho da fila
        return item;
    }

    // Obter o item da frente sem removê-lo
    public FilmFila frente() {
        if (Vazia()) {
            System.out.println("A fila está vazia");
            return null;
        }
        return fila[frente]; // Retorna o item da frente sem removê-lo
    }

    // Obter o tamanho atual da fila
    public int tamanho() {
        return tamanho;
    }

    // Menu principal
    public static void main(String[] args) {
        Fila fila = new Fila(5); // Capacidade da fila é 5

        FilmFila filme1 = new FilmFila("Inception", "Christopher Nolan", 2010);
        FilmFila filme2 = new FilmFila("Matrix", "The Wachowskis", 1999);
        FilmFila filme3 = new FilmFila("Interstellar", "Christopher Nolan", 2014);
        FilmFila filme4 = new FilmFila("Blade Runner", "Ridley Scott", 1982);
        FilmFila filme5 = new FilmFila("Oppenheimer", "Christopher Nolan", 2023);

        fila.enfileirar(filme1);
        fila.enfileirar(filme2);
        fila.enfileirar(filme3);
        fila.enfileirar(filme4);
        fila.enfileirar(filme5);

        System.out.println("Frente da fila é: " + fila.frente().getTitulo());

        FilmFila desenfileirado = fila.desenfileirar();
        System.out.println("Filme que foi desenfileirado: " + desenfileirado.getTitulo());

        System.out.println("Nova frente da fila é: " + fila.frente().getTitulo());

        System.out.println("Filmes restantes na fila:");
        for (int i = 0; i < fila.tamanho(); i++) {
            int indice = (fila.frente + i) % fila.capacidade;
            System.out.println(fila.fila[indice].getTitulo());
        }
    }
}
