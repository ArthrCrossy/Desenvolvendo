public class palindromoRecursivo {

    public static boolean palindrome(String testar, int cont){

        boolean answer = true;

        // se o primeiro até o metade vai e roda
        if(cont < testar.length()/2){
            // se for diferente retorna false e termina a iteração
            // primeiro vai de 0 até a metade
            // vai do ultimo até o meio
            if(testar.charAt(cont) != testar.charAt(testar.length()-(cont + 1))){

                // termina o ciclo
                answer = false;
                cont = testar.length();
            }else{
                // roda o chart
                answer = palindrome(testar, cont = cont + 1);
            }
        }
        // se for igual retorna true
        return answer;
    }

    public static boolean isFim(String palavra){
        return (palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
 }

public static void main(String[] args) {
        
    // declarando variaveis
    String[] text = new String[1000];
    int num = 0;

    do{
        // lendo os vetores
        text[num] = MyIO.readLine();
        num = num + 1;
        // até ser false
    }while(!isFim(text[num - 1]));

    num = num - 1;

    // joga para função até chegar o numero de entrada
    for(int i = 0; i < num; i = i + 1){

        boolean ok = palindrome(text[i], 0);

        if(ok == true){
            MyIO.println("SIM");
        }else{
            MyIO.println("NAO");
        }
        }
    }

}