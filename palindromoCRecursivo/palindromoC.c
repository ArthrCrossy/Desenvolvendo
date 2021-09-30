#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


bool palindromoRecursivo(char* palavra, int i){

    int resp = true;
    
    int tam = strlen(palavra);
    
    // vai decrescendo
    int j = tam - (1 + i);
    
    // roda até a metade
    if(i < tam / 2){

        // se descobri que não são iguais retorna falso e fecha o loop
        if(palavra[i] != palavra[j]){

            resp = false;
            tam = 0;

        }else{
            // roda o proximo char
            resp = palindromoRecursivo(palavra, i+1);
        }

    }

        return resp;
}


int ehpalindromoRecursivo(char* palavra){

    // joga string para a função principal
    return palindromoRecursivo(palavra, 0);

}

// verifica quando terminar de ler
int ehFim(char *palavra1, char* palavra2){

    int resp = 1;
    int tam = 3;

    // se as strings tiverem tamanho diferente já termina a string
    if(strlen(palavra1) != strlen(palavra2)){
        resp = 0;
        tam = strlen(palavra1);
    }

    // verifica se são iguais se não termina a string
    for(int i = 0; i < tam; i = i + 1){
        if(palavra1[i] != palavra2[i]){
            resp = 0;
        }
    }

    return resp;

}

int main(){

    char entrada[500];
    // entrada
	scanf(" %[^\n]%*c",entrada);

    do{
        if(ehpalindromoRecursivo(entrada)){
            printf("SIM\n");
        }else{
            printf("NAO\n");
        }

        scanf(" %[^\n]%*c",entrada);

    // condição
    }while(!ehFim(entrada, "FIM"));

    return 0;
}