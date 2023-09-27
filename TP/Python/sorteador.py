import random

lista = input("Digite os nomes desejados para o sorteio(apenas 1 sera escolhido): ").split( ' ')

liste = ['Gabi', 'Iza']

print("A pessoa sorteada foi: ", random.choice(liste), "!")
