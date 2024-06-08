import java.util.*;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numeroDeCursos = scanner.nextInt();
            Map<String, Curso> disciplinas = new HashMap<>();

            while (numeroDeCursos > 0) {
                String nomeDaDisciplina = scanner.next();
                double nota = scanner.nextDouble();
                int peso = scanner.nextInt();
                disciplinas.put(nomeDaDisciplina, new Curso(nomeDaDisciplina, nota, peso));
                numeroDeCursos--;
            }

            Curso cursoMenorNota = encontraCursoMenorNota(disciplinas);
            Curso cursoMaiorNota = encontraCursoMaiorNota(disciplinas);
            double media = calculaMediaPonderada(disciplinas);

            System.out.printf("Menor: %s %.1f\n", cursoMenorNota.nome, cursoMenorNota.nota);
            System.out.printf("Maior: %s %.1f\n", cursoMaiorNota.nome, cursoMaiorNota.nota);
            System.out.printf("Média: %.2f\n", media);
        }
    }

    public static Curso encontraCursoMenorNota(Map<String, Curso> disciplinas) {
        return disciplinas.values().stream().min(Comparator.comparingDouble(c -> c.nota)).orElse(null);
    }

    public static Curso encontraCursoMaiorNota(Map<String, Curso> disciplinas) {
        return disciplinas.values().stream().max(Comparator.comparingDouble(c -> c.nota)).orElse(null);
    }

    public static double calculaMediaPonderada(Map<String, Curso> disciplinas) {
        double soma = 0.0;
        int somaPesos = 0;
        for (Curso curso : disciplinas.values()) {
            soma += curso.nota * curso.peso;
            somaPesos += curso.peso;
        }
        return soma / somaPesos;
    }

    public static class Curso {
        String nome;
        double nota;
        int peso;

        Curso(String nome, double nota, int peso) {
            this.nome = nome;
            this.nota = nota;
            this.peso = peso;
        }
    }
}

