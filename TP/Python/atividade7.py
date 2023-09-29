# Atividade 07 - Python


def the_length(the_list, valor):
    resultado = 0
    for i in the_list:
        if len(i) > int(valor):
            resultado = resultado + 1
    return resultado

def as_vogais(the_list):
    resultado = []
    aux = 0
    while aux < len(the_list):
        resultado.append(0)
        for c in the_list[aux]:
            if (c == 'a' or c== 'e' or c == 'i' or c == 'o' or c == 'u'):
                resultado[aux] = resultado[aux] + 1
        aux = aux + 1
    
    return resultado

def o_grupinho(the_list):
    tamanho_grupos = []
    for i in the_list:
        if len(i) not in tamanho_grupos:
            tamanho_grupos.append(len(i))
    
    print(tamanho_grupos)
   
#-------------------------------------------------------------------------------------------------------------------------------------------------------

def imprimeMenu():
    print()
    print("Escolha entre as opções abaixo:")
    print("[1] Qual é o maior? (Insira um número e veja quantas palavras têm comprimento superior a esse número)")
    print("[2] Quantas vogais? (Gera uma lista contando as vogais em cada elemento da lista de entrada)")
    print("[3] O Agrupamento! (Produz uma lista de conjuntos, organizando nomes de acordo com seu comprimento)")
    print("[4] A Criptografia... (Cria uma lista de nomes criptografados juntamente com uma chave de criptografia aleatória)")
    print("[0] Sair do Programa")
    scanner = input()
    if (scanner == '1' or scanner == '2' or scanner == '3' or scanner == '4' or scanner == '0'):
        return int(scanner)
    else:
        print("*** Opção inválida, tente novamente ***")
        imprimeMenu()

def chamaFuncao():
    the_list = input("Por favor, digite seu texto: ").split(' ')
    escolha = imprimeMenu()
    while escolha != 0:
        if(escolha == 1):
            print(the_length(the_list, input("Por favor, digite o número desejado: ")))
            escolha = imprimeMenu()
        elif(escolha == 2):
            print(as_vogais(the_list))
            escolha = imprimeMenu()
        elif(escolha == 3):
            o_grupinho(the_list)
            escolha = imprimeMenu()
        elif(escolha == 4):
            #
            escolha = imprimeMenu()
    print("¡Hasta la vista, Baby!")

#--------------------------------------------------------------------------------------------------------------------------------------------------------

def main():
    chamaFuncao()

main()         
