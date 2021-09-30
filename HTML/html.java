import java.io.*;
import java.net.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.*;
import java.util.Scanner;

public class html{
    
    // identifica a String Final para ler as entradas

    public static int ehFim(String verificaFim, String palavra){

        if(verificaFim.charAt(0) == palavra.charAt(0)){
            if(verificaFim.charAt(1) == palavra.charAt(1)){
                if(verificaFim.charAt(2) == palavra.charAt(2)){
                    return 1;
                }else{
                    return 0;
            }
            }else{
                return 0;
            }
        }else{
            return 0;
        }

    }
    
    public static String lerHTML(String site){



        URL url;
        InputStream input = null;
        BufferedReader leitor;
        String answer = "", linha;

        try{
            
            // cria objeto urj
            url = new URL(site);
            // abre coneção
            input = url.openStream();
            // fluxo de entrada
            leitor = new BufferedReader(new InputStreamReader(input));
            
            // ler enquanto for diferente de null

            while((linha = leitor.readLine()) != null){
                // preenchendo os dados
                answer = answer + linha;
            
            }

        }catch(MalformedURLException erro1){
            erro1.printStackTrace();

        }catch(IOException erro2){
            erro2.printStackTrace();
        }

        try{
            input.close();
        }catch(IOException erro){
            erro.printStackTrace();
        }

        return answer;
    }
    
    // identifica consoante

    public static int Consoante(String answer){

        int tam = answer.length();
        int cont = 0;

        for(int i = 0; i < tam; i = i + 1){

            // identifica de A minusculo até Z minusculo

            if((answer.charAt(i) >= 'a') && (answer.charAt(i) <= 'z')){

                // tudo que não é vogal

                if((answer.charAt(i) != 'a') && (answer.charAt(i) != 'e') && (answer.charAt(i) != 'i') && (answer.charAt(i) != 'o') && (answer.charAt(i) != 'u')){

                    cont = cont + 1;
                }
            }else{

            }

        }

        return cont;
    }
    

    // Identifica BR
    public static int Br(String answer){

        int cont = 0;
        int tam = answer.length();

        // encontra o br
        for(int i = 0; i < tam; i = i + 1){
            if(answer.charAt(i) == '<'){
                if(answer.charAt(i+1) == 'b'){
                    if(answer.charAt(i+2) == 'r'){
                        if(answer.charAt(i+3) == '>'){
                            cont = cont + 1;
                        }
                    }
                }
            }
        }
        

        return cont;
    }  
    
    // identifica table

    public static int Table(String answer){

        int cont = 0;
        int tam = answer.length();

        // encontra o table
        for(int i = 0; i < tam; i = i + 1){
            if(answer.charAt(i) == '<'){
                if(answer.charAt(i+1) == 't'){
                    if(answer.charAt(i+2) == 'a'){
                        if(answer.charAt(i+3) == 'b'){
                            if(answer.charAt(i+4) == 'l'){
                                if(answer.charAt(i+5) == 'e'){
                                    if(answer.charAt(i+6) == '>'){

                                        cont = cont + 1;
                                        
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

        return cont;
    }
    
    public static int []Vogal(String answer){

        int tam = answer.length();
        int []vetor = new int[22];

        // inicia vetor

        for(int i = 0; i < 22; i++){
            vetor[i] = 0;
        }

        // identifica e conta as respostas para cada variavel

        for(int i = 0; i < tam; i++){
            if(answer.charAt(i) == 97){
                            vetor[0] = vetor[0] + 1;   
            }
            if(answer.charAt(i) == 101){
                vetor[1] = vetor[1] + 1;   
            }
            if(answer.charAt(i) == 105){
                vetor[2] = vetor[2] + 1;   
            }
            if(answer.charAt(i) == 111){
                vetor[3] = vetor[3] + 1;   
            }
            if(answer.charAt(i) == 117){
                vetor[4] = vetor[4] + 1;   
            }
            if(answer.charAt(i) == 225){
                vetor[5] = vetor[5] + 1;   
            }
            if(answer.charAt(i) == 233){
                vetor[6] = vetor[6] + 1;   
            }
            if(answer.charAt(i) == 237){
                vetor[7] = vetor[7] + 1;   
            }
            if(answer.charAt(i) == 243){
                vetor[8] = vetor[8] + 1;   
            }
            if(answer.charAt(i) == 250){
                vetor[9] = vetor[9] + 1;   
            }
            if(answer.charAt(i) == 224){
                vetor[10] = vetor[10] + 1;   
            }
            if(answer.charAt(i) == 232){
                vetor[11] = vetor[11] + 1;   
            }
            if(answer.charAt(i) == 236){
                vetor[12] = vetor[12] + 1;   
            }
            if(answer.charAt(i) == 242){
                vetor[13] = vetor[13] + 1;   
            }
            if(answer.charAt(i) == 249){
                vetor[14] = vetor[14] + 1;   
            }
            if(answer.charAt(i) == 227){
                vetor[15] = vetor[15] + 1;   
            }
            if(answer.charAt(i) == 245){
                vetor[16] = vetor[16] + 1;   
            }
            if(answer.charAt(i) == 226){
                vetor[17] = vetor[17] + 1;   
            }
            if(answer.charAt(i) == 234){
                vetor[18] = vetor[18] + 1;   
            }
            if(answer.charAt(i) == 238){
                vetor[19] = vetor[19] + 1;   
            }
            if(answer.charAt(i) == 244){
                vetor[20] = vetor[20] + 1;   
            }
            if(answer.charAt(i) == 251){
                vetor[21] = vetor[21] + 1;   
            }
        }

        return vetor;
    }
    
    public static void treatData(String answer, String nome){

        // encontrando as quantidades de cada variavel
        int []vetor = Vogal(answer);
        int consoantes = Consoante(answer);
        int br = Br(answer);
        int table = Table(answer);

        // retira os consoantes do br
        if(br > 0){
            consoantes = consoantes - (2*table);
        }

        // retira os consoantes do table
        // retira as vogais do table
        // retira as vogais do table
        if(table > 0){
            consoantes = consoantes - (3*table);
            vetor[0] = vetor[0] - table;
            vetor[1] = vetor[1] - table;
        }
        
        // printa resposta

        MyIO.print("a(" + vetor [0] + ") ");
        MyIO.print("e(" + vetor [1] + ") ");
		MyIO.print("i(" + vetor [2] + ") ");
		MyIO.print("o(" + vetor [3] + ") ");
		MyIO.print("u(" + vetor [4] + ") ");
		MyIO.print("á(" + vetor [5]+") ");
		MyIO.print("é(" + vetor [6] + ") ");
		MyIO.print("í(" + vetor [7] + ") ");
		MyIO.print("ó(" + vetor [8] + ") ");
		MyIO.print("ú(" + vetor [9] + ") ");
		MyIO.print("à(" + vetor [10 ] +") ");
		MyIO.print("è(" + vetor [11] + ") ");
		MyIO.print("ì(" + vetor [12] + ") ");
		MyIO.print("ò(" + vetor [13] + ") ");
		MyIO.print("ù(" + vetor [14] + ") ");
		MyIO.print("ã(" + vetor [15] + ") ");
		MyIO.print("õ(" + vetor [16] + ") ");
		MyIO.print("â(" + vetor [17] + ") ");
		MyIO.print("ê(" + vetor [18] + ") ");
		MyIO.print("î(" + vetor [19] + ") ");
		MyIO.print("ô("+vetor[20]+") ");
		MyIO.print("û("+vetor[21]+") ");
		MyIO.print("consoante(" + consoantes + ") ");
		MyIO.print("<br>(" + br + ") ");
		MyIO.print("<table>(" + table + ") ");
		MyIO.println(nome);
    }
    
    public static void main(String[] args) throws Exception{

        String nome = MyIO.readLine();

        while(ehFim(nome, "FIM") != 1){

            String site = MyIO.readLine();
            String HTML = lerHTML(site);
            treatData(HTML, nome);
            nome = MyIO.readLine();
        }


    }    

}