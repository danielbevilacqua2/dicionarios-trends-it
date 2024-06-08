import math

def encontra_curso_menor_nota(disciplinas):
   #passa por todas as disciplinas do dicionário e compara as notas
   # se a nota que eu estiver lendo no momento for menor do que
  # o valor que eu tenho, essa é a nova menor nota (e a menor disciplina)
nota_menor = math.inf
nome_menor = “ “
for nome, (nota, _) in disciplina.items(): 
   if nota < nota_menor:
         nota_menor = nota
         nome_menor = nome

return nome_menor, nota_menor

def encontra_curso_maior_nota(disciplinas):
    nota_menor = math.inf
nome_menor = “ “
for nome, (nota, _) in disciplina.items(): 
   if nota < nota_menor:
         nota_menor = nota
         nome_menor = nome

return nome_menor, nota_menor





def calcula_media_ponderada(disciplinas):
   soma = 0.0
  soma_pesos = 0
 for _, (nota, peso) in disciplinas.items():
        soma += nota * peso
        soma_pesos += peso

media = soma / soma_pesos
return media





numero_de_cursos = int(input())

disciplinas = {}
while numero_de_cursos >0:
     linha = input().split()

   nome_da_disciplina = linha[0]
   nota = float(linha[1])
   peso = int(linha[2])
   disciplinas[nome_da_disciplina] = (nota,peso)

      numero_de_cursos  -= 1

(nome_menor, nota_menor) = encontra_curso_menor_nota(disciplinas)
(nome_maior, nota_maior) = encontra_curso_maior_nota(disciplinas)
media = calcula_media_ponderada(disciplinas)

print(“Menor: %s %.1f”  % (nome_menor, nota_menor))
print(“Maior: %s %.1f”   % (nome_maior, nota_maior))
print(“Média: %.2f” % media)

