public class ListaEstatica {
    private int[] listaestatica;
    private int tamanho;

    private int capacidade;

    ListaEstatica(int capacidade){
        this.listaestatica= new int[capacidade];
        this.tamanho = 0;
        this.capacidade=capacidade;
    }

    public void clear(){
        for (int i = 0; i < capacidade; i++) { //percorre toda a lista
            listaestatica[i] = 0; // Atribui 0 a cada elemento da lista
        }
        tamanho = 0; // Redefine tamanho para 0
    }

    public void add(int dado){ //adicionar no final da lista
        if (!isFull()){ //verifica se está cheia
            listaestatica[tamanho] = dado; //o indice tamanho agora tem o valor do dado
            tamanho ++; //incrementa o tamanho
        }
        System.out.println("Não há espaço disponível na lista"); //se estiver cheia nao adiciona na lista
    }

    public void add(int dado, int posicao){ //adicionar em posição específica
        if (!isFull() && posicao >= 0 && posicao <= tamanho) { // Verifica se há espaço na lista e se a posição é válida
            for (int i = tamanho; i > posicao; i--) { // Move elementos para a direita a partir da posição
                listaestatica[i] = listaestatica[i - 1];
            }
            listaestatica[posicao] = dado; // Insere o dado na posição especificada
            tamanho++; // Incrementa o tamanho após adicionar
        } else {
            System.out.println("Não há espaço disponível na lista ou posição inválida"); // Se estiver cheia ou posição inválida, exibe a mensagem
        }
    }

    public int remover(int posicao){
        if (posicao >= 0 && posicao < tamanho) { // Verifica se a posição inserida é válida
            int valorRemovido = listaestatica[posicao]; // Armazena o valor removido para poder dar o return do dado
            for (int i = posicao; i < tamanho - 1; i++) { // Move elementos para a esquerda // pra cobrir o espaço
                listaestatica[i] = listaestatica[i + 1];
            }
            tamanho--; // diminui o tamanho após remover
            return valorRemovido; // Retorna o valor removido
        } else {
            System.out.println("Posição inválida"); // Se a posição for inválida, exibe a mensagem
            return -1; // retorna -1 como "erro"
        }
    }

    public boolean isEmpty(){
        return tamanho==0;
    }

    public boolean isFull(){
        return tamanho>=capacidade;
    }

    public void setData(int dado, int posicao){
        if (posicao >= 0 && posicao < tamanho){ //se a posicao for valida
            listaestatica[posicao] = dado; //o valor no índice posicao agora é o novo dado
        }
        System.out.println("Posição inválida");
    }

    public int getData(int posicao){
        if (posicao >= 0 && posicao < tamanho){ //se a posicao for valida
            int valor = 0; //cria uma variavel para armazenar o valor
            listaestatica[posicao] = valor; // coloca o valor que esta no indice da posição na variável
            return valor;

        }
        System.out.println("Posição inválida"); //se a posição for inválida
        return -1;
    }

    public int getSize(){
        return tamanho; //retorna o tamanho da lista, que foi incrementado e ou decrementado ao longo do tempo
    }

    public int find(int dado){
        int posicaoDado = 0; //variavel da posicao
        for (int i = 0; i < tamanho; i++) { //percorre a lista em busca do dado
            if (listaestatica[i] == dado){
                posicaoDado = i; //atribui o indice à variavel da posição
                return posicaoDado; //retorna a posicao
            }
    }
        System.out.println("Valor nao encontrado"); //se nao achar o valor
        return -1; //valor de erro
    }}
