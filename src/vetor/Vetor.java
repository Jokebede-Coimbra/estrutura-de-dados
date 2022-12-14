package vetor;

import java.util.Arrays;

public class Vetor {

    private String[] elementos;
    private int tamanho = 0; // vai controlar o tamanho real do vetor

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
    }

    /* public void adiciona(String elemento) {
         for (int i = 0; i < this.elementos.length; i++) {
             if (this.elementos[i] == null) {
                 this.elementos[i] = elemento;
             }
         }
     }*/

    // Melhorando o método adciona
    /*public void adiciona(String elemento) {
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento; // adicinando o elemento no vetor
            this.tamanho++; // incrementando no valor também
        } else {
            try {
                throw new Exception("Não é possível adicionar elementos no vetor cheio");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }*/
    // Melhorando o método adciona 2
    public boolean adiciona(String elemento) {
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento; // adicinando o elemento no vetor
            this.tamanho++; // incrementando no valor também
            return true;
        }
        return false;
    }

    public boolean adiciona(int posicao, String elemento) {
        // Verificando se a posição é valida
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        this.aumentaCapacidade();
        // iterando de tras p/ frente
        // mover todos os elemenentos
        for (int i = this.tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;

        return false;
    }

    //Só será executado quando atingir acapacidade
    private void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            String[] elementosNovos = new String[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    public String busca(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return this.elementos[posicao];
    }

    public int busca(String elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    // B G D E F > Posição a ser removida é 1 (G)
    // 0 1 2 3 4 > tamanho é 5
    // vetor[1] =  vetor[2]
    // vetor[2]= vetort[3]
    // vetor[3]= vetort[4]
    public void remove(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.tamanho--;
    }

    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            sb.append(elementos[i]);
            sb.append("]");
        }
        if (this.tamanho > 0) {
            sb.append(elementos[this.tamanho - 1]);
        }
        sb.append("]");
        return Arrays.toString(elementos);
    }
}
