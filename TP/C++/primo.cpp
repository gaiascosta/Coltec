#include <iostream>
#define SUCESSO 0
 
using namespace std;
 
int main() {
 
    int valorDesejado, numeroVezes;
    bool ehPrimo = true;

    std::cin >> numeroVezes;
    
    for(int j = 0; j < numeroVezes; j++){
        std::cin >> valorDesejado;
    
        for(int i = valorDesejado; i >= 2; i--){
            if((valorDesejado%i==0) && (valorDesejado != i)){
                ehPrimo = false;
                std::cout << valorDesejado << " nao eh primo" << "\n";
                break;
            }
        }

        if(ehPrimo){
            std::cout << valorDesejado << " eh primo" << "\n";
        }

        ehPrimo = true;
    }
 
    return SUCESSO;
}