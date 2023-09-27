listinha = input().split(' ')

print("Primeiro lugar: ", max(listinha))
listinha.remove(max(listinha))
print("Segundo lugar: ", max(listinha))
listinha.remove(max(listinha))
print("Terceiro lugar: ", max(listinha))