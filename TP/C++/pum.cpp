#include <iostream>
#include <iomanip>
#include <string>
#include <cmath>
#define SUCESSO 0
 
using namespace std;
 
int main() 
{
    int valor, atual;
    std::cin >> valor;

    for (int i = 0; i < valor; i++)
    {
        atual = i * 4;
        std::cout << atual+1 << " " << atual+2 << " " << atual+3 << " PUM\n";
    }

    return SUCESSO;
}