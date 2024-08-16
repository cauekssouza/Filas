public class FilaCircular {
    // Atributos
    private final FilmFila[] queue;
    private int topo;
    private int base;
    private int tamanho;
    private final int capacidade;

    // Construtor Circular
    public FilaCircular(int capacidade) {
        this.capacidade = capacidade;
        this.queue = new FilmFila[capacidade];
        this.topo = -1;
        this.base = 0;
        this.tamanho = 0;
    }

    /* Métodos */

    // Adicionar elemento na fila
    public void adicionar(FilmFila dado) {
        if (isFull()) {
            System.out.println("A fila está cheia");
            return;
        }
        topo = move(topo); // Move a posição do topo de forma circular
        queue[topo] = dado; // Adiciona o elemento na posição do topo
        tamanho++; // Aumenta o tamanho da fila
        System.out.println(dado.getTitulo() + " foi adicionado na fila");
    }

    // Remover elemento da fila
    public FilmFila remover() {
        if (isEmpty()) {
            System.out.println("A fila está vazia");
            return null;
        }
        FilmFila dado = queue[base]; // Obtém o elemento na posição da base
        base = move(base); // Move a posição da base de forma circular
        tamanho--; // Diminui o tamanho da fila
        return dado;
    }

    // Movimenta a posição de forma circular
    private int move(int posicao) {
        return (posicao + 1) % capacidade;
    }

    // Limpar a fila
    public void limpar() {
        topo = -1;
        base = 0;
        tamanho = 0;
        System.out.println("Fila foi limpa");
    }

    // Verificação se a fila está cheia
    public boolean isFull() {
        return tamanho == capacidade;
    }

    // Verificação se a fila está vazia
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Obter o elemento da frente da fila sem remover
    public FilmFila frente() {
        if (isEmpty()) {
            System.out.println("Fila está vazia");
            return null;
        }
        return queue[base]; // Retorna o elemento na posição da base
    }

    // Método para imprimir todos os elementos na fila
    public void imprimirFila() {
        if (isEmpty()) {
            System.out.println("Fila está vazia");
            return;
        }
        System.out.print("Filmes restantes na fila: ");
        for (int i = 0; i < tamanho; i++) {
            int indice = (base + i) % capacidade;
            System.out.print(queue[indice].getTitulo() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FilaCircular filaCircular = new FilaCircular(5);

        FilmFila filme1 = new FilmFila("Inception", "Christopher Nolan", 2010);
        FilmFila filme2 = new FilmFila("Matrix", "The Wachowskis", 1999);
        FilmFila filme3 = new FilmFila("Interstellar", "Christopher Nolan", 2014);
        FilmFila filme4 = new FilmFila("Blade Runner", "Ridley Scott", 1982);
        FilmFila filme5 = new FilmFila("Oppenheimer", "Christopher Nolan", 2023);

        filaCircular.adicionar(filme1);
        filaCircular.adicionar(filme2);
        filaCircular.adicionar(filme3);
        filaCircular.adicionar(filme4);
        filaCircular.adicionar(filme5); // Aqui a fila deve estar cheia

        // Tentando adicionar mais um filme quando a fila está cheia
        FilmFila filme6 = new FilmFila("Dune", "Denis Villeneuve", 2021);
        filaCircular.adicionar(filme6); // Deve indicar que a fila está cheia

        filaCircular.imprimirFila(); // Imprimir os filmes restantes na fila

        filaCircular.limpar();
        System.out.println("A fila está vazia? " + filaCircular.isEmpty()); // Deve retornar true
    }
}
