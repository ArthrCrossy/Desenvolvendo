public class isRecursivo {

    static boolean eh_number(char letter){

        // condição se não obedecer essas caracteristicas
        if(((int)letter < 48) || ((int)letter > 57)){
            return false;
        }else{
            return true;
        }

    }

    
    static Boolean is_java_number(String text, int number, int i){

        char letter;
        boolean x;
        // pega o char
        letter = text.charAt(i);
        
        // verifica se é number
        x = eh_number(letter);

        // se quando o x for falso breaka
        if( x == false){
            return false;
        }
        // itera todos os caracteres se não breakar false retorna true
        if(number == i){
            return true;
        }
          
        return is_java_number(text, number, i = i + 1);
    }

    static boolean vogal(char x){
        // verifica se é vogal
        if((int)x == 97 || (int)x == 101 || (int)x == 105 ||(int)x == 111 ||  (int)x == 117 ||
            (int)x == 65 || (int)x == 69 || (int)x == 73 ||(int)x == 79 || (int)x == 85){
            return true;
        }else{
            return false;
        }
    }

    static boolean is_java_vogal(String text, int number, int i){

        char letter;
        boolean x;

        // pega o char
        letter = text.charAt(i);

        // verifica se é vogal
        x = vogal(letter);
        
       
         // se quando o x for falso breaka
        if( x == false){
            return false;
        }

        // itera todos os caracteres se não breakar false retorna true
        if(number == i){
            return true;
        }


        return is_java_vogal(text, number, i=i+1);
    }

    static boolean conso(char x){

        boolean dif_vogal = (int)x != 97 && (int)x != 101 && (int)x != 105 && (int)x != 111 &&  (int)x != 117 &&
        (int)x != 65 && (int)x != 69 && (int)x != 73 && (int)x != 79 && (int)x != 85;

        boolean resto = !(((int)x < 65) || !((int)x > 90) || !(((int)x<97) || !((int)x>122)));

        if(dif_vogal && resto){
            return true;
        }else{
            return false;
        }
    }

    static boolean is_java_conso(String text, int number, int i){

        char letter;
        boolean x;

        // pega o char
        letter = text.charAt(i);

        // verifica se é consoante
        x = conso(letter);


         // se quando o x for falso breaka
        if( x == false){

            return false;
        }

        // itera todos os caracteres se não breakar false retorna true
        if(number == i){
            return true;
        }
        

        return is_java_conso(text, number, i = i + 1);
    }


    static boolean verify_float(char x){

        // retorna falso se não for do intervalo virgula até 9
        if(((int) x < 44 || (int) x>57)){
            return false;
        }else{
            return true;    
        }
    }

    static int verify_ponto(String text, int number, int j, int cont){

        // pega o char
        char letter2 = text.charAt(j);

        // quando for . ou , o contador aumenta
        if(((int)letter2 == 46) || (int)letter2 == 44){
            cont = cont + 1;
       }

       // quando iterar todos os caracteres entra aqui
        if(j == number){

            // se tiver um . ou , retorna 1 true
            if(cont == 1){
                return 1;
            // se tiver mais de um ponto ou virgula e retorna falso por causa do 2
            }else if(cont >1){
                return 2;
            }else{
            // se tiver mais de um ponto ou virgula e retorna falso por causa do 0
                return 0;
            }
        }

        return verify_ponto(text, number, j = j + 1, cont);
    }

    static boolean is_java_float(String text, int number, int i, int cont){

        char letter, letter2;
        boolean x;
        
            // no i = 0 verifica se tem só 1 ponto ou uma virgula
            if(i == 0){
                 cont = verify_ponto(text, number, 0, cont);
            }

            // pega caracter
            letter2 = text.charAt(i);

            // se os pontos e virgulas forem diferente de 1 retorna falso
            if(cont != 1){
                return false;
            }


            // itera todos caracteres
            if(number == i){
                return true;
            }
            
            // pega os caracteres
            letter = text.charAt(i);

            // verifica se só tem ponto ou virgula
            x = verify_float(letter);

            
            // se não for numero e tiver ponto ou virgula breaka e retorna 0
            if( x == false){

                return false;
            }

        return is_java_float(text, number, i = i + 1, cont);

    }

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
     }

    public static void main(String[] args){

        

        // declarando variaveis
        String[] text = new String[1000];
        int numEntrada = 0;
        int number = 0;
        
        do{
            // preenche o vetor
            text[numEntrada] = MyIO.readLine();
            numEntrada++;
            // até o limite
        }while(!isFim(text[numEntrada - 1]));

        numEntrada = numEntrada - 1;
        // joga para a função

        for(int i = 0; i<numEntrada;i=i+1){
        
        // subtrai 1 porquê eh < ao inves de <=
        number = text[i].length() - 1;

        boolean ok_1 = is_java_vogal( text[i], number, 0);
        boolean ok_2 = is_java_conso( text[i], number, 0);
        boolean ok_3 = is_java_number( text[i], number, 0);
        boolean ok_4 = is_java_float(text[i], number, 0, 0);
        
        if(ok_1 == true){
            MyIO.print("SIM ");
        }else{
            MyIO.print("NAO ");
        }
        if(ok_2 == true){
            MyIO.print("SIM ");
        }else{
            MyIO.print("NAO ");
        }
        if(ok_3 == true){
            MyIO.print("SIM ");
        }else{
            MyIO.print("NAO ");
        }
        if(ok_4 == true){
            MyIO.print("SIM ");
        }else{
            MyIO.print("NAO ");
        }

        MyIO.print("\n");

        }
    }

}
