# Atividade 02 - Python

lista = input("Digite suas palavras: ").split( ' ')
copia_lista = lista.copy()

indice = [copia_lista.index(j) for j in lista]

print(sorted(lista), indice)