public class palindromo {
    

    static boolean palindrome(String text, int number, int i){
            
        while(number >= 0){

            char letter = text.charAt(i);
            char letter_2 = text.charAt(number);
            

            // Se for diferente as comparações retorna 0
            // compara até a metade
            if(letter != letter_2){ 
                return false;
            }

            number = number - 1;
            i = i + 1;
        }

        // se obedecer todas as comparações retorna true logo eh um palindromo
        return true;
    }


    // chegar a palavra Fim para de ler
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
     }

    public static void main(String[] args) {
        
       
        // declarando variaveis
        String[] text = new String[1000];
        int numEntrada = 0;
        int number = 0;

      

        do{
            // ler as palavras
            text[numEntrada] = MyIO.readLine();
            numEntrada++;
           
            // até ser verdade
        }while(!isFim(text[numEntrada - 1]));

        numEntrada = numEntrada - 1;
        
        // joga para a função até todas entradas
        for(int i = 0; i<numEntrada ; i=i+1){
           
            number = text[i].length() - 1;

            
            boolean ok = palindrome(text[i], number, 0);

            if(ok == true){
                MyIO.println("SIM");
            }else{
                MyIO.println("NAO");
            }
        }
    }
}