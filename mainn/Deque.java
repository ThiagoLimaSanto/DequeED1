package com.mycompany.mainn;

public class Deque {

    private Pessoa[] deque;
    private int frente;
    private int fim;
    private int tamanho;
    private int capacidade;

    public Deque(int capacidade) {
        this.capacidade = capacidade;
        deque = new Pessoa[capacidade];
        frente = -1;
        fim = -1;
        tamanho = 0;
    }

    public boolean isFull() {
        return tamanho == capacidade;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void insertFrente(Pessoa valor) {
        if (isFull()) {
            System.out.println("Deque esta cheio!");
            return;
        }

        if (isEmpty()) {
            frente = 0;
            fim = 0;
        } else {
            frente = (frente - 1 + capacidade) % capacidade;
        }

        deque[frente] = valor;
        tamanho++;
    }

    public void insertFim(Pessoa value) {
        if (isFull()) {
            System.out.println("Deque esta cheio!");
            return;
        }

        if (isEmpty()) {
            frente = 0;
            fim = 0;
        } else {
            fim = (fim + 1) % capacidade;
        }

        deque[fim] = value;
        tamanho++;
    }

    public void deleteFrente() {
        if (isEmpty()) {
            System.out.println("Deque esta vazio!");
            return;
        }

        if (frente == fim) {
            frente = -1;
            fim = -1;
        } else {
            frente = (frente + 1) % capacidade;
        }

        tamanho--;
    }

    public void deleteFim() {
        if (isEmpty()) {
            System.out.println("Deque esta vazio!");
            return;
        }

        if (frente == fim) {
            frente = -1;
            fim = -1;
        } else {
            fim = (fim - 1 + capacidade) % capacidade;
        }

        tamanho--;
    }

    public Pessoa getFrente() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque esta Vazio!");
        }
        return deque[frente];
    }

    public Pessoa getFim() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque esta Vazio!");
        }
        return deque[fim];
    }

    public void printDeque() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque esta vazio!");
        }

        System.out.println("Pessoa na fila:");

        int i = frente;
        int ordem = 1;

        while (true) {
            System.out.println(ordem + "° Pessoa: ");
            System.out.println("ID: " + deque[i].getId() + " ");
            System.out.println("Idade: " + deque[i].getIdade() + " ");
            System.out.println("Sexo: " + deque[i].getSexo() + " ");
            System.out.println("E gestante: " + deque[i].isGestante() + " ");
            System.out.println("E lactante: " + deque[i].isLactante() + " ");
            System.out.println("E especial: " + deque[i].isNecessidadeEspecial() + " ");
            if (i == fim) {
                break;
            }
            i = (i + 1) % capacidade;
            ordem++;
        }
        System.out.println("");
    }

    public int prioridade(int idade, boolean necessidadeEspecial, boolean gestante, boolean lactante) {
        if (gestante || lactante) {
            return 3;
        } else if (necessidadeEspecial) {
            return 2;
        } else if (idade > 60) {
            return 1;
        }
        return 0;
    }

    public void clearDeque() {
        frente = -1;
        fim = -1;
        tamanho = 0;
    }

    public Pessoa[] getDeque() {
        return deque;
    }
}
