# Atividade 06 - Python

resultado = 0

listinha = []
listinhaBase = input().split(' ')
listinha.append(listinhaBase)
aux = 1
while aux < len(listinhaBase):
    listinha.append(input().split(' '))
    aux = aux + 1

aux = 0

while aux < len(listinhaBase):
    resultado = resultado + int(listinha[aux][aux])
    aux = aux + 1

print("O resultado é:", resultado)