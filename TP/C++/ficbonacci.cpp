#include <iostream>

int main(){
    int n;
    int fib[46];
    
    std::cin >> n;
    
    fib[0] = 0;
    fib[1] = 1;
    
    std::cout << fib[0] << " " << fib[1] << " ";
    
    for(int i = 2; i < n; i++){
            fib[i] = fib[i-1] + fib[i-2];
            if(i == (n-1))
                 std::cout << fib[i];
            else
                std::cout << fib[i] << " ";
    }
    
    std::cout << "\n";
    return 0;
}