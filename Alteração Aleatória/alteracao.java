import java.util.Random;

class alteracao {

    public static char[] convert_string(String x){

        // declarando tamanho do vetor
        char[] vet_carac = new char[x.length()];
        char carac;

        // transformando string em vetor de caracteres
        for(int i = 0; i< x.length();i=i+1){
            carac = x.charAt(i);
            vet_carac[i] = carac;
        }

        return vet_carac;
    }

    public static char[] gerador(String text, Random gerador){

        // encontra as variaveis aleatorias
        char letter = (char)('a'+(Math.abs(gerador.nextInt())%26));
        char letter2 = (char)('a'+(Math.abs(gerador.nextInt())%26));

        // transforma string em vetor de caracteres
        char[] palavra = convert_string(text);

        //int tamanho = palavra.length;
        char x;

        // identificando o vetor de caracteres com as variaveis aleatorias e trocando para formar o novo vetor.
        for(int i = 0; i<palavra.length;i=i+1){
            if(palavra[i] == letter){
                // trocando os caractéres
                palavra[i] = letter2;
            }
        }

        // printando as respostas
        for(int i = 0;i<palavra.length;i=i+1){
            MyIO.print(palavra[i] );
            
        }
        MyIO.print("\n");

        return palavra;
    }


    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
     }

    public static void main(String[] args){

        String[] text = new String[1500];
        int num = 0;
        int number = 0;

        do{
            text[num] = MyIO.readLine();
            num = num + 1;

        }while(!isFim(text[num - 1]));

        num = num - 1;

        Random gerador = new Random(4);

        for(int i = 0; i < num; i = i + 1){
            
            gerador(text[i], gerador);

        }

    }   
}