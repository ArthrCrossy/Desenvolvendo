#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_FIELD_SIZE 100

typedef struct {
    char nome[MAX_FIELD_SIZE];
    char formato[MAX_FIELD_SIZE];
    char duracao[MAX_FIELD_SIZE];
    char pais[MAX_FIELD_SIZE];
    char idioma[MAX_FIELD_SIZE];
    char emissora[MAX_FIELD_SIZE];
    char transmissao[MAX_FIELD_SIZE];
    int num_temporadas;
    int num_episodios;
} Serie;

char *remove_line_break(char *line) {
    while (*line != '\r' && *line != '\n') line++;
    *line = '\0';
    return line;
}

char *freadline(char *line, int max_size, FILE *file) {
    return remove_line_break(fgets(line, max_size, file));
}

char *readline(char *line, int max_size) {
    return freadline(line, max_size, stdin);
}

void print_serie(Serie *serie) {
    printf("%s %s %s %s %s %s %s %d %d\n",
        serie->nome,
        serie->formato,
        serie->duracao,
        serie->pais,
        serie->idioma,
        serie->emissora,
        serie->transmissao,
        serie->num_temporadas,
        serie->num_episodios
    );
}

// Retorna o tamanho em bytes de um arquivo.
long tam_arquivo(FILE *file) {
    fseek(file, 0L, SEEK_END);
    long size = ftell(file);
    rewind(file);
    return size;
}

// Retorna todo o conteúdo do arquivo numa string.
char *ler_html(char filename[]) {
    FILE *file = fopen(filename, "r");
    if (!file) {
        fprintf(stderr, "Falha ao abrir arquivo %s\n", filename);
        exit(1);
    }
    long tam = tam_arquivo(file);
    char *html = (char *) malloc(sizeof(char) * (tam + 1));
    fread(html, 1, tam, file);
    fclose(file);
    html[tam] = '\0';
    return html;
}

/**
 * @brief Extrai os textos de uma tag html.
 * 
 * @param html Ponteiro para o caractere que abre a tag '<'.
 * @param texto Ponteiro para onde o texto deve ser colocado.
 * 
 * @return Ponteiro para o texto extraído.
 */
char *extrair_texto(char *html, char *texto) {
    char *start = texto;
    int contagem = 0;
    while (*html != '\0') {
        if (*html == '<') {
            if (
                (*(html + 1) == 'p') ||
                (*(html + 1) == 'b' && *(html + 2) == 'r') ||
                (*(html + 1) == '/' && *(html + 2) == 'h' && *(html + 3) == '1') ||
                (*(html + 1) == '/' && *(html + 2) == 't' && *(html + 3) == 'h') ||
                (*(html + 1) == '/' && *(html + 2) == 't' && *(html + 3) == 'd')
            ) break;
            else contagem++;
        }
        else if (*html == '>') contagem--;
        else if (contagem == 0 && *html != '"') {
            if (*html == '&') html = strchr(html, ';');
            else if (*html != '\r' && *html != '\n') *texto++ = *html;
        }
        html++;
    }
    *texto = '\0';
    return *start == ' ' ? start + 1 : start;
}

/**
 * @brief Lê o HTML da série e popula os campos da struct.
 * 
 * @param serie Struct Serie que vai receber os dados.
 * @param html String contendo todo o HTML do arquivo.
 */
void ler_serie(Serie *serie, char *html) {
    char texto[MAX_FIELD_SIZE];

    char *ptr = strstr(html, "<h1");
    extrair_texto(ptr, texto);

    char *parenteses_ptr = strchr(texto, '(');
    if (parenteses_ptr != NULL) *(parenteses_ptr - 1) = '\0';

    strcpy(serie->nome, texto);

    ptr = strstr(ptr, "<table class=\"infobox_v2\"");

    ptr = strstr(ptr, "Formato");
    ptr = strstr(ptr, "<td");
    strcpy(serie->formato, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "Duração");
    ptr = strstr(ptr, "<td");
    strcpy(serie->duracao, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "País de origem");
    ptr = strstr(ptr, "<td");
    strcpy(serie->pais, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "Idioma original");
    ptr = strstr(ptr, "<td");
    strcpy(serie->idioma, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "Emissora de televisão original");
    ptr = strstr(ptr, "<td");
    strcpy(serie->emissora, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "Transmissão original");
    ptr = strstr(ptr, "<td");
    strcpy(serie->transmissao, extrair_texto(ptr, texto));

    ptr = strstr(ptr, "N.º de temporadas");
    ptr = strstr(ptr, "<td");
    sscanf(extrair_texto(ptr, texto), "%d", &serie->num_temporadas);

    ptr = strstr(ptr, "N.º de episódios");
    ptr = strstr(ptr, "<td");
    sscanf(extrair_texto(ptr, texto), "%d", &serie->num_episodios);
}


    int isFim(char line[]) {
        return line[0] == 'F' && line[1] == 'I' && line[2] == 'M';
    }

    void swap(Serie *i, Serie *j){

        Serie tmp = *i;
        *i = *j;
        *j = tmp;
    }

    int getMaior(Serie s[], int n) {

        int maior = s[0].num_temporadas;

        for (int i = 0; i < n; i++) {
            if(maior < s[i].num_temporadas){
                maior = s[i].num_temporadas;
            }
        }
        return maior;
    }

    void ordenarSecundario(Serie s[], int n){

        for(int i = 0; i < n; i = i + 1){

            for(int j = i + 1; j < n; j = j + 1){

                if(s[i].num_temporadas == s[j].num_temporadas){

                    if(strcmp(s[i].nome, s[j].nome) > 0){

                        swap(&s[i], &s[j]);
                    }
                }
            }

        }

    }

    void countingSort(Serie s[], int i, int n){
        int tam = getMaior(s, n);

        int count[tam];
        Serie ordenado[n];

        for(int i = 0; i < tam; i = i + 1){
            count[i] = 0;
        }

        for(int i = 0; i < n; count[s[i].num_temporadas]++,i++);

        for(int i = 1; i < tam; count[i] = count[i-1] + count[i], i++);

        for(int i = n-1; i >= 0; ordenado[count[s[i].num_temporadas]-1] = s[i], count[s[i].num_temporadas]--, i--);

        for(int i = 0; i < n; s[i] = ordenado[i], i++);

    }

    void tranferir(Serie s[], Serie *s2){


        strcpy(s->nome, s2->nome);
        strcpy(s->formato, s2->formato);
        strcpy(s->duracao, s2->duracao);
        strcpy(s->pais, s2->pais);
        strcpy(s->idioma, s2->idioma);
        strcpy(s->emissora, s2->emissora);
        strcpy(s->transmissao, s2->transmissao);
        s->num_temporadas = s2->num_temporadas;
        s->num_episodios = s2->num_episodios;
    
    }

#define MAX_LINE_SIZE 250
#define PREFIXO "/tmp/series/"
//#define PREFIXO ""

int main() {
    Serie serie;
    Serie final[61];
   
    size_t tam_prefixo = strlen(PREFIXO);
    char line[MAX_LINE_SIZE];
    int i = 0;
    strcpy(line, PREFIXO);
    readline(line + tam_prefixo, MAX_LINE_SIZE);

    while (!isFim(line + tam_prefixo)) {
        char *html = ler_html(line);
        ler_serie(&serie, html);
        free(html);
        tranferir(&final[i], &serie);
        
        readline(line + tam_prefixo, MAX_LINE_SIZE);
        i = i + 1;
    }
    
    countingSort(final, 0, i);
    ordenarSecundario(final, i);
    
    for(int j = 0; j < i - 1; j = j + 1){
            printf("%s %s %s %s %s %s %s %d %d\n",
            final[j].nome,
            final[j].formato,
            final[j].duracao,
            final[j].pais,
            final[j].idioma,
            final[j].emissora,
            final[j].transmissao,
            final[j].num_temporadas,
            final[j].num_episodios);
    }

    return EXIT_SUCCESS;
}