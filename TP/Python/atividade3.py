# Atividade 03 - Python

listinhaBase = input("Por favor, digite as pontuações dos participantes: ").split(' ')
listinha = []
i = 0
while i < len(listinhaBase):
    listinha.append(int(listinhaBase[i]))
    i = i + 1

print()

print(f"Primeiro lugar: índice[{listinha.index(max(listinha)) + 1}]")
listinha[listinha.index(max(listinha))] = 0
print(f"Segundo lugar: índice[{listinha.index(max(listinha)) + 1}]")
listinha[listinha.index(max(listinha))] = 0
print(f"Terceiro lugar: índice[{listinha.index(max(listinha)) + 1}]")