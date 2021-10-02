#include <stdio.h>
#include <string.h>
#include <stdbool.h>

// retorna 1 se não for vogal
bool high(char name){
    return (((int)name!=97)&&((int)name!=101)&&((int)name!=105)&&((int)name!=111)&&((int)name!=117)&&((int)name!=65)&&((int)name!=69)&&((int)name!=73)&&((int)name!=79)&&((int)name!=85));
}


#define NUM_LINHAS 500
#define TAM_PALAVRA 100

bool read_vogal(char name[], int number, int i){

    // le toda string
    for(i = 0;i<number;i=i+1){
        // condição retorna 0
        if(high(name[i])){
            return 0;
        }
    }
    // se não obedecer a condição retorna true
    return 1;
}

//  função retorna true se não for numero
bool number_max(char name){
    return (((int)name < 48) || ((int)name > 57));
}

bool read_number(char name[], int number, int i){
    // roda todos caracteres
    for(i = 0;i<number;i=i+1){ 
        // retorna false  se identificar true na função
        if(number_max(name[i])){
            return 0;
        }
    }
    // se não obedecer a condição retorna true
    return 1;

}

bool read_conso(char name[], int number, int i){
    // le toda string
    for(i = 0;i<number;i=i+1){
        // condição retorna 0 se não for vogal
        if(!high(name[i])){
            return 0;
        }
    }
        // se não obedecer a condição retorna true

    return 1;

}


bool read_float(char name[], int number, int i, int cont){
    // le toda string
    for(i = 0;i<number;i=i+1){

          // condição retorna 0 se não for numero ou . e v
        if(((int)name[i] < 44 || ((int)name[i] > 58))){

                return 0;    
        }
    }
     // se não obedecer a condição retorna true
    return 1;

}

bool isFim(char entrada[]){

    return(entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M');
}


int main(){

    // declarando variaveis
    char text[300];
    int i, number;
    char palavra[300];
    bool ok, ok1, ok2, ok3;

    
    int qntleituras = 0;
    
    fgets(text, sizeof(text), stdin);

    // roda até chegar em FIM
    while (isFim(text) != true){
        number = strlen(text) - 1;

        ok = read_vogal(text, number, 0);
        ok1 = read_conso(text, number, 0);
        ok2 = read_number(text, number, 0);
        ok3 = read_float(text, number, 0, 0);
        
        if(ok == true){
            printf("SIM ");
        }else{
            printf("NAO ");
        }
        
        if(ok1 == true){
            printf("SIM ");
        }else{
            printf("NAO ");
        }

        if(ok2 == true){
            printf("SIM ");
        }else{
            printf("NAO ");
        }

        if(ok3 == true){
            printf("SIM ");
        }else{
            printf("NAO ");
        }
        
        printf("\n");

        fgets(text, sizeof(text), stdin);
    }

    return 0;
}