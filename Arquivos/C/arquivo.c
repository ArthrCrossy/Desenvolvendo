#include <stdio.h>
#include<stdlib.h>
#include<string.h>

int main(){

    // sabre arquivo
    FILE *arquivo = fopen("arquivo2.txt", "wb");

    // declara variavel
    int i = 0;
    int cont;
    double var;

    // aloca quantas repetições
    scanf("%d", &cont);

    while(i < cont){

        // aloca memoria
        scanf("%lf", &var);

        // escreve
        fwrite(&var, sizeof(double), 1, arquivo);

        i = i + 1;
    }

    fclose(arquivo);

    arquivo = fopen("arquivo2.txt", "rb");

    for(i=1;i<=cont;i=i+1){

        // procura os dados de tras para cima
        fseek(arquivo, -(sizeof(double)*i), SEEK_END);
        // le os dados
        fread(&var, sizeof(double), 1, arquivo);
        printf("%g\n", var);
    }

    return 0;
}