public class is {
    
    static Boolean is_java_number(String text, int number, int i){

        char letter;

        // itera todos os caracteres
        for(i=0;i<number;i=i+1){

            // pega o char
            letter = text.charAt(i);

            // se não for numero retorna falso
            if(((int)letter < 48) || ((int)letter > 57) ){
                return false;
            }
        }
        
        return true;
    }

    // retorna true se for vogal
    static boolean vogal(char x){
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

        // itera até o final
        for(i=0;i<=number;i=i+1){

            // pega caracter
            letter = text.charAt(i);

            x = vogal(letter);
            // se retornar consoante breaka e retorna zero
            if( x == false){

                return false;
            }
           
        }

        return true;
    }
    
    static boolean is_java_conso(String text, int number, int i){

        char letter;
        boolean x;

        // itera até o final
        for(i=0;i<=number;i=i+1){
            // pega caracter
            letter = text.charAt(i);
            // tem que retornar true se não for vogal
            x = !vogal(letter);
            // braka se for vogal
            if( x == false){

                return false;
            }

        }

        return true;
    }

    

    static boolean verify_float(char x){

        // se não for de , até o 9 retorna falso
        if(((int) x < 44 || (int) x>57)){
            return false;
        }else{
            return true;    
        }
    }



    static boolean is_java_float(String text, int number, int i){

        char letter, letter2;
        int cont = 0;
        boolean x;

        // itera todos os caracteres
        for(int j=0;j<number;j=j+1){
            // pega todos os caracteres
            letter2 = text.charAt(j);

                // se for . ou , aumenta o contador
                if(((int)letter2 == 46) || (int)letter2 ==44){
                    cont = cont + 1;
                }
                
        }
            // se for diferente de 1 pont ou 1 virgula já retorna falso
            
            if(cont != 1){
                return false;
            }

        // itera todos os caracteres
        for(i=0;i<number;i=i+1){

            // pega os caracters
            letter = text.charAt(i);

            // verifica se é float
            x = verify_float(letter);

            // breaka e retorna falso se o x for falso
            if( x == false){

                return false;
            }
            
        }

        return true;

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

        number = text[i].length() - 1;

        boolean ok_1 = is_java_vogal( text[i], number, 0);
        boolean ok_2 = is_java_conso( text[i], number, 0);
        boolean ok_3 = is_java_number( text[i], number, 0);
        boolean ok_4 = is_java_float(text[i], number, 0);
        
        // resposta
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