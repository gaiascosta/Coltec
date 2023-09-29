# Atividade 05 - Python

lista_de_valores = input().split(',')
aux = 0

while aux < len(lista_de_valores):
    lista_de_valores[aux] = int(int(lista_de_valores[aux]) * int(lista_de_valores[aux]))
    aux = aux + 1

print(lista_de_valores)