#include <iostream>
#include <string>
#include <cmath>
#define SUCESSO 0
 
using namespace std;

int valorJogada(string pessoa){
    int valor = 0;
    
    if(pessoa == "pedra") {
        valor = 0;
    }
    else if(pessoa == "lagarto") {
        valor = 1;
    }
    else if(pessoa == "Spock") {
        valor = 2;
    }
    else if(pessoa == "tesoura") {
        valor = 3;
    }
    else if(pessoa == "papel") {
        valor = 4;
    }
    return valor;
}
 
int main() 
{
    string sheldon, raj;
    int numeroBat, nSheldon, nRaj, combate[5][5] = {{0, 1, -1, 1, -1},
        {-1, 0, 1, -1, 1},
        {1, -1, 0, 1, -1},
        {-1, 1, -1, 0, 1},
        {1, -1, 1, -1, 0}
    };

    std::cin >> numeroBat;

    for(int i = 0; i < numeroBat; i++)
    {
        std::cin >> sheldon;
        std::cin >> raj;
        
        nSheldon = valorJogada(sheldon);
        nRaj = valorJogada(raj);

        if(combate[nSheldon][nRaj] == 1){
            std::cout << "Caso #" << (i+1) << ": Bazinga!\n";
        }
        else if(combate[nSheldon][nRaj] == -1){
            std::cout << "Caso #" << (i+1) << ": Raj trapaceou!\n";
        }
        else{
            std::cout << "Caso #" << (i+1) << ": De novo!\n";
        }
    }

    return SUCESSO;
}