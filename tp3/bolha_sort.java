import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

class Filmes implements Cloneable {

    // declarando variaveis
    private String nome;
    private String Formato;
    private String Duracao;
    private String pais;
    private String idioma;
    private String Emissora;
    private String transmissao;
    private int numberTemp;
    private int numberEp;
    
    // declarando construtor
    public Filmes(){
        
    }

    // print
    public String toString(){

        return this.nome + " " + this.Formato + " " + this.Duracao + " " + this.pais + " " + this.idioma + " " + this.Emissora + " " + this.transmissao + " " + this.numberTemp + " " + this.numberEp;
    }

    // construtura jova
    public Filmes(String nome, String Formato, String Duracao, String pais, String idioma, String Emissora, String transmissao, int numberTemp, int numberEp){
        this.nome = nome;
        this.Formato = Formato;
        this.Duracao = Duracao;
        this.pais = pais;
        this.idioma = idioma;
        this.Emissora = Emissora;
        this.transmissao = transmissao;
        this.numberTemp = numberTemp;
        this.numberEp = numberEp;
        
    }

    // Gets e Sets
    public String getNome(){
        return this.nome;
    }

    public String getFormato(){
        return this.Formato;
    }

    public String getDuracao(){
        return this.Duracao;
    }

    public String getPais(){
        return this.pais;
    }

    public String getIdioma(){
        return this.idioma;
    }

    public String getEmissora(){
        return this.Emissora;
    }

    public String getTransmissao(){
        return this.transmissao;
    }

    public int getNumberTemp(){
        return this.numberTemp;
    }

    public int getNumberEp(){
        return this.numberEp;
    }

    public void SetNome(String nome){
        this.nome = nome;
    }

    public void setFormato(String Formato){
        this.Formato = Formato;
    }

    public void setDuracao(String Duracao){
        this.Duracao = Duracao;
    }

    public void setPais(String pais){
        this.pais = pais;
    }

    public void setIdioma(String idioma){
        this.idioma = idioma;
    }

    public void setEmissora(String Emissora){
        this.Emissora = Emissora;
    }

    public void setTransmissao(String transmissao){
        this.transmissao = transmissao;
    }

    public void setNumbertemp(int numberTemp){
        this.numberTemp = numberTemp;
    }

    public void setNumberEp(int numberEp){
        this.numberEp = numberEp;
    }

    // Clone
    Filmes getClone(){
        try {
            return (Filmes) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("ERRO CLONE");
            return this;
        }
    }

    public void leFilme(String nomeArquivo){

        String linhaFormato = "";
        String linhaTemporada = "";
        String novaTemporada = "";
        String linhaOrigem = "";
        String novoOrigem = "";
        String novoFormato = "";
        String linhaEmissora = "";
        String linhaIdioma = "";
        String novoIdioma = "";
        String novaEmissora = "";
        String linhaEpisodio = "";
        String novoEpisodio = "";
        String linhaTransmissao = "";
        String novaTransmissao = "";
        String linhaDuracao = "";
        String novaDuracao = "";
        String linhaTitulo = "";
        String novoTitulo = "";
        
        int i =0;

        // concatena o string
        String x = "/tmp/series/";
        x += nomeArquivo;
     //   Arq.openRead(nomeArquivo, "UTF-8");
        Arq.openRead(x, "UTF-8");

        //Descobre a posição no site
        for(i = 0; i <5; i = i + 1){
            linhaTitulo = Arq.readLine();
        }
        
        linhaTitulo = limpaDados(linhaTitulo);
        novoTitulo = limpaTitulo(linhaTitulo);
        SetNome(novoTitulo);

        //Descobre a posição no site
        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaFormato.contains("Formato")){
               
               break;
            }
            linhaFormato = Arq.readLine();
        }

        
        for(i = 0; i <1; i = i + 1){
            linhaFormato = Arq.readLine();
            novoFormato = limpaDados(linhaFormato);

        }

        setFormato(novoFormato);

        
        //Descobre a posição no site
        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaDuracao.contains("Duração")){
                break;
            }
            linhaDuracao = Arq.readLine();
        }

        for(i = 0; i <1; i = i + 1){
            linhaDuracao = Arq.readLine();
            novaDuracao = limpaDados(linhaDuracao);

        }

        setDuracao(novaDuracao);

        //Descobre a posição no site
        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaOrigem.contains("País de origem")){
                break;
            }
            linhaOrigem = Arq.readLine();
        }

        //Descobre a posição no site
        for(i = 0; i <1; i = i + 1){
            linhaOrigem = Arq.readLine();
            novoOrigem = limpaDados(linhaOrigem);

        }

        setPais(novoOrigem);

        //Descobre a posição no site
        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaIdioma.contains("Idioma original")){
                break;
            }
            linhaIdioma = Arq.readLine();
        }

        for(i = 0; i <1; i = i + 1){
            linhaIdioma = Arq.readLine();
            novoIdioma = limpaDados(linhaIdioma);

        }
        
        setIdioma(novoIdioma);

        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaEmissora.contains("Emissora")){
                break;
            }
            linhaEmissora = Arq.readLine();
        }

        for(i = 0; i <1; i = i + 1){
            linhaEmissora = Arq.readLine();
            novaEmissora = limpaDados(linhaEmissora);
        }

        setEmissora(novaEmissora);

        //Descobre a posição no site
        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaTransmissao.contains("Transmissão original")){
                break;
            }
            linhaTransmissao = Arq.readLine();
        }

        for(i = 0; i <1; i = i + 1){
            linhaTransmissao = Arq.readLine();
            linhaTransmissao = firstDataTreat(linhaTransmissao);
            novaTransmissao = limpaDadosData(linhaTransmissao);
        }

        setTransmissao(novaTransmissao);
        
        //Descobre a posição no site
        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaTemporada.contains("N.º de temporadas")){
                break;
            }
            linhaTemporada = Arq.readLine();
        }

        for(i = 0; i <1; i = i + 1){
            linhaTemporada = Arq.readLine();
            novaTemporada = limpaDados(linhaTemporada);
            novaTemporada = limpastringTemp(novaTemporada);
            
        }

        //Descobre a posição no site
        setNumbertemp(Integer.parseInt(novaTemporada));

        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaEpisodio.contains("N.º de episódios")){
                break;
            }
            linhaEpisodio = Arq.readLine();
        }

        for(i = 0; i <1; i = i + 1){
            
            linhaEpisodio = Arq.readLine();
            novoEpisodio = limpaDados(linhaEpisodio);
            novoEpisodio = limpaListaEpisodios(novoEpisodio);
            novoEpisodio = limpastringEp(novoEpisodio);
           
        }

        setNumberEp(Integer.parseInt(novoEpisodio));

//        MyIO.println(toString());
        Arq.close();

    }

    // numeros
    public String limpastringEp(String s){

        String novoS = "";
        int tam = s.length();
        
        for(int i  = 0; i < tam; i = i +1){
        novoS =  novoS + s.charAt(i);
        }

        novoS = novoS.trim();

        return novoS;
    }

        // limpa as temporadas
    public String limpaListaEpisodios(String ep){

        int tam = ep.length();
        String newEp = "";
        boolean continuar = true;

        for(int i = 0; i < tam && continuar == true; i = i + 1){
            
            // apenas numneros
            if(ep.charAt(i) >= 48 && ep.charAt(i)<= 57){
                newEp = newEp + ep.charAt(i);
            }
            // quebra c tiver string
            if(ep.charAt(i) == '+' || ep.charAt(i) == '-'  || ep.charAt(i) == ' '){
                continuar = false;
                
            }

        }

        return newEp;
    }

    // limpa as temporadas
    public String limpastringTemp(String ep){

        int tam = ep.length();
        String newEp = "";
        boolean continuar = true;

        for(int i = 0; i < tam && continuar == true; i = i + 1){

            // Apenas numeros
            if(ep.charAt(i) >= 48 && ep.charAt(i)<= 57){
                newEp = newEp + ep.charAt(i);
            }
            // quebra c tiver string
            if(ep.charAt(i) == '+' || ep.charAt(i) == '-'  || ep.charAt(i) == ' '){
                continuar = false;
                
            }

        }

        //newEp = newEp.trim();

        return newEp;
    }

    // limpa o titulo 
    public String limpaTitulo(String palavra){

        String novaPalavra = "";
        int tam = palavra.length();
        boolean ehTrue = true;


        for(int i = 0; i < tam && ehTrue; i = i + 1){

            if(palavra.charAt(i) == '–' || palavra.charAt(i) == '('){

                ehTrue = false;
            }else{
                novaPalavra = novaPalavra + palavra.charAt(i);
            }


        }

        novaPalavra = novaPalavra.trim();


        return novaPalavra;
    }


    // consegue limpar conteúdo entre < e > e &
    // e adicionar em novaPalavra
    public String limpaDados(String palavra){

        String novaPalavra = "";
        int tam = palavra.length();

        for(int i = 0; i < tam; i = i + 1){
            if(palavra.charAt(i) == '<' || palavra.charAt(i) == '&'){
                for(int y = i; y < tam; y = y + 1){
                    if(palavra.charAt(y) == '>'){
                        
                        i = y;
                        y = tam;
                    }
                }
            }else{

                novaPalavra = novaPalavra + palavra.charAt(i);
            }
        }

        novaPalavra = novaPalavra.trim();


        return novaPalavra;
    }

    // retira &#160;
    public String firstDataTreat(String palavra){
        /*&#160;*/
        
        String novaPalavra = palavra.replace("&#160;", "");

        return novaPalavra;
    }

    // consegue limpar conteúdo entre < e > e &
    // e adicionar em novaPalavra
    public String limpaDadosData(String palavra){

        String novaPalavra = "";
        int tam = palavra.length();

        for(int i = 0; i < tam; i = i + 1){
            if(palavra.charAt(i) == '<' || palavra.charAt(i) == '&'){
                for(int y = i; y < tam; y = y + 1){
                    if(palavra.charAt(y) == '>'){
                        i = y;
                        y = tam;
                    }
                }
            }else{

                novaPalavra = novaPalavra + palavra.charAt(i);
            }
        }

        novaPalavra = novaPalavra.trim();

        return novaPalavra;
    }

}

class lista {

    public Filmes[] array;
    public int n;
    public int comp = 0;
    public int mov;
 
    public lista () {
       
    }
 
    public lista (int tamanho){
       array = new Filmes[tamanho];
       n = 0;
    }

    public int getComp(){
        return this.comp;
    }

    public int getMov(){
        return this.mov;
    }

    public void inserirInicio(Filmes x) throws Exception {
 
        //validar insercao
        if(n >= array.length){
           throw new Exception("Erro ao inserir!");
        } 
  
        //levar elementos para o fim do array
        for(int i = n; i > 0; i--){
           array[i] = array[i-1];
        }
        
        MyIO.println(x.getNome());

        array[0] = x;
        
        n = n + 1;
     }

    public void inserir(Filmes x, int pos) throws Exception {

        //validar insercao
        if(n >= array.length || pos < 0 || pos > n){
           throw new Exception("Erro ao inserir!");
        }
  
        //levar elementos para o fim do array
        for(int i = n; i > pos; i--){
           array[i] = array[i-1];
        }
  
        array[pos] = x;
        n = n + 1;
        
    }
    public void inserirFim(Filmes x) throws Exception {
 
        //validar insercao
        if(n >= array.length){
           throw new Exception("Erro ao inserir!");
        }
  
        array[n] = x;
        n = n + 1;
    }
   
    public Filmes removerInicio() throws Exception {
 
        //validar remocao
        if (n == 0) {
           throw new Exception("Erro ao remover!");
        }
        MyIO.println("(R) " +  array[0].getNome());

        Filmes resp = array[0];

        n = n - 1;
  
        for(int i = 0; i < n; i++){
           array[i] = array[i+1];
        }
  
        return resp;
     }

     public Filmes remover(int pos) throws Exception {
 
        //validar remocao
        if (n == 0 || pos < 0 || pos >= n) {
           throw new Exception("Erro ao remover!");
        }

        MyIO.println("(R) " +  array[pos].getNome());

        Filmes resp = array[pos];
        n = n - 1;
  
        for(int i = pos; i < n; i++){
           array[i] = array[i+1];
        }
  
        return resp;
     }


     public Filmes removerFim() throws Exception {
 
        //validar remocao
        if (n == 0) {
           throw new Exception("Erro ao remover!");
        }
        
        MyIO.println("(R) " +  array[n = n - 1].getNome());

        return array[n = n - 1];
     }

     /*public String toString(){

        return this.nome + " " + this.Formato + " " + this.Duracao + " " + this.pais + " " + this.idioma + " " + this.Emissora + " " + this.transmissao + " " + this.numberTemp + " " + this.numberEp;
    }*/

     public void mostrar (){
      //  MyIO.print("[ ");
        for(int i = 0; i < n; i++){
           MyIO.println(array[i].getNome() + " " + array[i].getFormato() + " " + array[i].getDuracao() + " " + array[i].getPais() + " " + array[i].getIdioma() + " " + array[i].getEmissora() + " " +  array[i].getTransmissao() + " " + array[i].getNumberTemp() + " " + array[i].getNumberEp()) ;
        
        }
      //  MyIO.println("]");
    }


    public void mostrarPais (){
          for(int i = 0; i < n; i++){
             MyIO.println(array[i].getNome() + " " + array[i].getPais()) ;
          
          }
      }

    public int changeNumber(int number, int j){

        if(number > 0){
            number = j;
        }

        return number;
    }

    public void ordenacaoSelecao(){

        int menor;
        int number;

        for(int i = 0; i < (n - 1); i = i + 1){
            menor = i;
            for(int j=(i+1); j < n; j = j + 1){
                number = array[menor].getPais().compareTo(array[j].getPais());
                comp = comp + 1;
                if(number > 0){
                    menor = j;
                }
                
            }

            swap(menor, i);
        }
    }

    public void ordenacaoSelecaoNome(){

        int menor;
        for(int i = 0; i < (n - 1); i = i + 1){
            menor = i;
            for(int j=(i+1); j < n; j = j + 1){

                int number = array[menor].getNome().compareTo(array[j].getNome());
                comp = comp + 1;
                if(number > 0){
                    menor = j;
                }
            }

                swap(menor, i);
           
        }
    }

    public void ordenacaoSelecaoNomeEUA(){

        int menor;

        for(int i = 0; i < (n - 1); i = i + 1){
            menor = i;
            for(int j=(i+1); j < n; j = j + 1){

                int number = array[menor].getNome().compareTo(array[j].getNome());
                comp = comp + 1;
                if(number > 0 && array[menor].getPais().contains("Estados Unidos") && array[j].getPais().contains("Estados Unidos")){
                    menor = j;
                }
            }

                swap(menor, i);
          
        }
    }

    public void ordenacaoSelecaoNomeUk(){

        int menor;

        for(int i = 0; i < (n - 1); i = i + 1){
            menor = i;
            for(int j=(i+1); j < n; j = j + 1){

                int number = array[menor].getNome().compareTo(array[j].getNome());
                comp = comp + 1;
                if(number > 0 && array[menor].getPais().contains("Reino Unido")){
                    menor = j;
                }
            }

                swap(menor, i);
           
        }
    }

    public void swap(int i, int y){

        Filmes aux = array[i];
        array[i] = array[y];
        array[y] = aux;
    }

    public void bubbleSortNome() throws Exception {

        long comeco = new Date().getTime();
        int comp = 0;
        int mov = 0;

		for (int i = (n - 1); i > 0; i = i - 1) {

			for (int j = 0; j < i; j = j + 1) {

                int x = array[j].getNome().compareTo(array[j+1].getNome());
                
                    comp = comp + 1;
				if (x > 0) {
                    mov = mov + 1;
                    swap(j, j+1);

				}
			}
		}

        long fim = new Date().getTime();

        try{

            File arquivo = new File("713229_insercao.txt");

            if(!arquivo.exists()){
                arquivo.createNewFile();
            }

            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Tempo: " + ( fim - comeco ) + " milisegundos ...");
            bw.write("Comparacoes: " + comp);
            bw.write("movimentacoes: " + mov);
            bw.close();
            fw.close();

        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void bubbleSortTemp() throws Exception {

        long comeco = new Date().getTime();
        int comp = 0;
        int mov = 0;

		for (int i = (n - 1); i > 0; i = i - 1) {

			for (int j = 0; j < i; j = j + 1){
                    comp = comp + 1;
				if (array[j].getNumberTemp() > array[j+1].getNumberTemp()) {
                    mov = mov + 1;
                    swap(j, j+1);
				}
                
			}
		}

        long fim = new Date().getTime();

        try{

            File arquivo = new File("713229_insercao.txt");

            if(!arquivo.exists()){
                arquivo.createNewFile();
            }

            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Tempo: " + ( fim - comeco ) + " milisegundos ...");
            bw.write("Comparacoes: " + comp);
            bw.write("movimentacoes: " + mov);
            bw.close();
            fw.close();

        } catch(Exception e){
            System.out.println(e);
        }
    }

}

public class bolha_sort {

    // Visualiza o fim dos sites
   
    public static boolean ehFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    // transformando String em vetor de caracter
    public char[] transformaChar(String s){

        char[] palavra = new char[s.length()];

        for(int i = 0; i < s.length(); i = i + 1){
            palavra[i] = s.charAt(i);
        }

        return palavra;
    }

    public static void main(String[] args) throws Exception {

        MyIO.setCharset("UTF-8");

        rodar();

    }

    // pegando html
    public String transformaString(String s){

        String newPalavra = new String();

        for(int i = 3; i < s.length(); i = i + 1){

            newPalavra = newPalavra + s.charAt(i) ;

        }

       // MyIO.println(newPalavra);

        return newPalavra;
    }

    // dividiondo string pegar os numeros
    public String transformarStringpespaco(String s){

        String newPalavra = new String();

        for(int i = 6; i < s.length(); i = i + 1){

            if(s.charAt(i) != ' ' || s.charAt(i) != 240){

                newPalavra = newPalavra + s.charAt(i);

            }

        }

        return newPalavra;
    }

    public String transformarNumero(String s){

        String palavra = new String();
        int cont = 0;
        boolean ok = true;

        for(int i = 0; i < s.length() && ok == true; i = i + 1){

            if(s.charAt(i) >= 48 && s.charAt(i) <= 57){

                palavra = palavra + s.charAt(i);
                cont = cont + 1;

                if(cont == 2){
                    ok = false;
                }
            }
        }

        return palavra;
    }

    // pegando string transformando em uma lista de objetos
    public static lista converterLista(String input[], int n,lista x) throws Exception {

        Filmes[] vector = new Filmes[100];

        for(int i = 0; i < n; i = i + 1 ){
            vector[i] = new Filmes();
            vector[i].leFilme(input[i]);
            x.inserir(vector[i], i);
        //    MyIO.println(i);
        }

        return x;
    }

    // inserindo inicio
    public void trataInserir(String palavra, Filmes html, lista x) throws Exception{

        if(palavra.charAt(1) == 'I'){

            palavra = transformaString(palavra);
            html.leFilme(palavra);
            x.inserirInicio(html);
                
        }

        if(palavra.charAt(1) == 'F'){

            palavra = transformaString(palavra);
            html.leFilme(palavra);
            x.inserirFim(html); 
        }

        if(palavra.charAt(1) == '*'){
            String palavra2 = new String();
            palavra2 = transformarNumero(palavra);
            palavra = transformarStringpespaco(palavra);
            int number = Integer.parseInt(palavra2);
            html.leFilme(palavra);
            x.inserir(html, number);
        }
    }

    // removendo
    public void trataRemover(String palavra, Filmes html, lista x) throws Exception {

        if(palavra.charAt(1) == '*'){

            palavra = transformaString(palavra);

            int number = Integer.parseInt(palavra);

            x.remover(number);
        }

        if(palavra.charAt(1) == 'I'){

            x.removerInicio();

        }

        if(palavra.charAt(1) == 'F'){

            x.removerFim();
        }

    }

    public void tratandoDado(int tam, lista x) throws Exception {

        String palavra = new String();

        while(tam > 0){
            
            Filmes html = new Filmes();
            palavra = MyIO.readLine();
            
            // inserindo inicio
            if(palavra.charAt(0) == 'I'){
                
                trataInserir(palavra, html, x);

            }

            // removendo
            if(palavra.charAt(0) == 'R'){

                trataRemover(palavra, html, x);

            }

            tam = tam - 1;
        }

    }

  
    public static void rodar() throws Exception{

        int i = -1;

        String[] input = new String[70];

        lista x = new lista(61);

        do{
             i = i + 1;
            input[i] = MyIO.readLine();

        }while(!ehFim(input[i]));

        x = converterLista(input, i, x);

        x.bubbleSortNome();
        x.bubbleSortTemp();
        x.mostrar();
        
        }
}


