# Atividade 04 - Python

def tirarFloatDeString(stringOriginal):
    stringPalavra = ''
    stringValor = ''
    for c in stringOriginal:
        if c == '.':
            stringValor = stringValor + '.'
        elif c.isdigit():
            stringValor = stringValor + c
        else:
            stringPalavra = stringPalavra + c
    
    return stringPalavra, stringValor

    

lista_com_tudo = []
lista_de_nomes = []
lista_de_precos = []
numero_de_linhas = int(input("Digite a quantidade de produtos: "))
aux = 0

while (aux < numero_de_linhas):
    stringPalavra, stringValor = tirarFloatDeString(input())
    lista_com_tudo.append(stringPalavra)
    lista_de_nomes.append(stringPalavra)
    lista_com_tudo.append(float(stringValor))
    lista_de_precos.append(float(stringValor))
    aux = aux + 1

lista_de_nomes = sorted(lista_de_nomes)
print()

for i in lista_de_nomes:
    print(f"{i} {lista_com_tudo[lista_com_tudo.index(i) + 1]}")

