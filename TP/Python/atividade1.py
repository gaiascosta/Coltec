# Atividade 01 - Python

from statistics import mean

num_linhas = int(input())
listinha = []
while(num_linhas>0):
    listinha.append(int(input()))
    num_linhas = num_linhas - 1

print(sum(listinha), mean(listinha), max(listinha), min(listinha), listinha.count(0))