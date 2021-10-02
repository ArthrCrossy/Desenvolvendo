public class algebra {

        // Transforma string em vetor de Char
        public static char[] tranformarChar(String palavra, int size, char conv[]){

            for(int i = 0; i < size; i = i + 1){
                conv[i] = palavra.charAt(i);
            }

            return conv;
        }

        // Troca as vogais para transformar em valores booleanos
        public static char[] trocaValor(char[] answer, int[] value){

            char a = 'F', b = 'F', c = 'F';

            if(value.length == 2){
                if(value[0] == 1){
                    a = 'V';
                }

                if(value[1] == 1){
                    b = 'V';
                }
            }

            if(value.length == 3){
                if(value[0] == 1){
                    a =  'V';
                }

                if(value[1] == 1){
                    b = 'V';
                }

                if(value[2] == 1){
                    c = 'V';
                }
            }

            for(int i = 0; i < answer.length; i = i + 1){
                if(answer[i] == 'A'){
                    answer[i] = a;
                }

                if(answer[i] == 'B'){
                    answer[i] = b;
                }

                if(answer[i] == 'C'){
                    answer[i] = c;
                }
            }

            return answer;

        }

        // FUnção not
        public static char[] not(char[] entrada, int j){

            boolean encontrou = true;
            int stop = 0;

            
            for(int i = j; (i <=  entrada.length) && (encontrou) ; i = i + 1){
                // encontra final da string
                if(entrada[i] == ')'){
                    // para loop
                    encontrou = false;
                    // final da string
                    stop = i;
                   
                }

                // operação booleano
                if(encontrou && (entrada[i] == 'F') || (entrada[i] ==  'V')){

                    if(entrada[i] == 'V'){
                        entrada[i] = 'F';
                    }else{
                        entrada[i] = 'V';
                    }

                }

            }

            // limpa tudo que não é os sinais booleanos
            for(int i = j - 3; i <= stop; i = i + 1){

                if((entrada [i] != 'F') && (entrada[i] != 'V')){

                    entrada[i] = ' ';
                }

            }


            return entrada;
        }
        

        public static char[] and(char[] entrada, int j){

            int stop = 0;
            int answer = 0;
            boolean ehAnd = true;

            for(int i = j; i < entrada.length; i = i + 1){

                // encontra o final da string
                if(entrada[i] == ')'){

                    // se não achou F é verdadeiro
                    if(ehAnd){
                        entrada[i - 1] = 'V';
                        answer = i - 1;
                    }
                    
                    

                    stop = i;
                    i = entrada.length - 1;

                }

                // se acha falso é igual a 0
                if((entrada[i] == 'F') && ehAnd){

                    answer = i;
                    ehAnd =false;
                }
            }

            // limpa tudo que não é a posição correspondente do resultado booleano
            for(int i = j - 3; i <= stop; i = i + 1){

                if( i != answer){
                    entrada[i] = ' ';
                }
            }

            return entrada;
        }


        public static char[] or(char[] entrada, int j){

            int stop = 0;
            int answer = 0;
            boolean ehtrue = false;

            for(int i = j; i < entrada.length; i = i + 1){
                
                // roda até o final da string se não achar verdadeiro é falso
                if(entrada[i] == ')'){

                    entrada[i] = ' ';

                    if( !ehtrue ){

                        entrada[i-1] = 'F';
                    }

                    stop = i;

                    if( !ehtrue){

                        stop = i - 1;
                    }

                    i = entrada.length - 1;
                }

                // se acha o V a função final é verdadeira e acha a posição correspondente
                if((entrada[i] == 'V') && (!ehtrue)){

                    answer = i;
                    ehtrue = true;
                }

            }

            // limpa tudo que não é a posição correspondente
            for(int i = j - 2; i < stop; i = i + 1){

                if( i != answer){

                    entrada[i] = ' ';
                }
            }

            return entrada;
        }

        public static void main(String[] args){

            // recebe o numero de caracteres
            int numb = MyIO.readInt();

            int[] valores = new int[numb];

            // continua a sequencia
            while( numb != 0){

                // aloca os valores
                for(int i = 0; i < numb; i = i + 1){

                    valores[i] = MyIO.readInt();

                }

                // recebe a string
                String ex = MyIO.readLine();

                int size = ex.length();

                char[] conv = new char[size];

                char[] answer = tranformarChar(ex, size, conv);

                // troca o abc pelos valores
                answer = trocaValor(answer, valores);

                for(int i = answer.length - 1; i >= 0; i = i - 1){
                    // descobre c vai ser o not, and, ou or através do caracteres final
                    if(answer[i] == '('){

                        char operacao = answer[i - 1];

                        if(answer[i - 1] == operacao){

                            if(operacao == 't'){

                                answer = not(answer, i);
                            }

                            if(operacao == 'd'){

                                answer = and(answer, i);
                            }

                            if(operacao == 'r'){

                                answer = or(answer, i);
                            }

                        }
                        // continuar o loop
                        i = answer.length - 1;
                    }
                }

                // identifica a resposta
                for(int i = 0; i < answer.length; i = i + 1){

                    if(answer[i] == 'V'){
                        MyIO.println("1");
                    }
    
                    if(answer[i] == 'F'){
                        MyIO.println("0");
                    }
                }

                // da sequencia ao loop
                numb = MyIO.readInt();

                valores = new int[numb];
            }


        }
}