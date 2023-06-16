#include <iostream>
#include <iomanip>
#include <string>
#define SUCESSO 0
#define CAWNUMBER 3
 
using namespace std;
 
int main() {

    int numberCaw = 0, loteria = 0;
    string corvo;

    while(numberCaw < CAWNUMBER){
        getline(cin, corvo);

        if(corvo == "caw caw")
        {
            std::cout << loteria << "\n";
            loteria = 0;
            numberCaw++;
        }
        else
        {
            if(corvo[0] == '*'){
                loteria += 4;
            }
            if(corvo[1] == '*'){
                loteria += 2;
            }
            if(corvo[2] == '*'){
                loteria += 1;
            }
        }
    }

    return SUCESSO;
}