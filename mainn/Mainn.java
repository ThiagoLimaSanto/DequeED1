package com.mycompany.mainn;

import java.util.Random;

public class Mainn {

    public static void main(String[] args) {
        String sexo = "";
        int idade = 0;
        String gestante = "";
        boolean isGestante = false;
        String lactante = "";
        boolean isLactante = false;
        String necessidadeEspecial = "";
        boolean isEspecial = false;
        int id = -1;
        int totalAtendido = 0;
        int grupo = 1;

        Random random = new Random();
        Deque deque = new Deque(10);
        Deque dequePrioridade = new Deque(100);
        Deque dequeAtendimento = new Deque(100);

        while (totalAtendido < 100) {
            for (int i = 0; i < 10; i++) {
                sexo = random.nextBoolean() ? "M" : "F";
                idade = random.nextInt(85);
                isGestante = sexo.equals("F") && random.nextBoolean();
                isLactante = sexo.equals("F") && random.nextBoolean();
                isEspecial = random.nextInt(10) == 0;
                
                id = deque.prioridade(idade, isEspecial, isGestante, isLactante);

                Pessoa pessoa = new Pessoa(id, sexo, idade, isGestante, isLactante, isEspecial);

                deque.insertFim(pessoa);

                isEspecial = false;
                isGestante = false;
                isLactante = false;
            }

            for (Pessoa c : deque.getDeque()) {
                if (c.getId() == 0) {
                    dequePrioridade.insertFim(c);
                } else if (c.getId() == 1) {
                    dequePrioridade.insertFrente(c);
                }
            }

            for (Pessoa c : deque.getDeque()) {
                if (c.getId() == 2) {
                    dequePrioridade.insertFrente(c);
                }
            }

            for (Pessoa c : deque.getDeque()) {
                if (c.getId() == 3) {
                    dequePrioridade.insertFrente(c);
                }
            }

            int pessoasParaAtender = Math.min(grupo, 100 - totalAtendido);
            for (int i = 0; i < pessoasParaAtender; i++) {
                try {
                    if (!deque.isEmpty()) {
                        dequeAtendimento.insertFim(dequePrioridade.getFrente());
                        dequePrioridade.deleteFrente();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            totalAtendido += pessoasParaAtender;
            grupo++;
            deque.clearDeque();
        }

        try {
            System.out.println("Pessoas atendidas: ");
            dequeAtendimento.printDeque();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Pessoas nao atendidas: ");
        try {
            dequePrioridade.printDeque();
        } catch (Exception e) {
        }
    }
}
