import java.time.LocalDate;
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
        //Arq.openRead(nomeArquivo, "UTF-8");
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

class Lista {

    public String[] array;
    public int n;
    public int comp = 0;
 
    public Lista () {
       
    }
 
    public Lista (int tamanho){
       array = new String[tamanho];
       n = 0;
    }

    public int getComp(){
        
        return ++this.comp;
    }

    public void inserir(String x, int pos) throws Exception {

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

     public void mostrar(Filmes array[]){

        int cont2 = 0;

        MyIO.print("[ ");
        for(int i = 0; i < n; i = i + 1){
            MyIO.print(array[i].getNome() + " ");
            cont2 = cont2 + 1;
        }
        MyIO.println("]");
        MyIO.println(cont2);
     }

    void bubbleSort(Filmes array[], int n) throws Exception{
        //n = array.length - 1;
        for (int i = 0; i < n - 1; i = i + 1)
            for (int j = 0; j < n - i - 1 ; j = j + 1){

                int x  = array[j].getNome().compareTo(array[j+1].getNome());


                if (x > 0 ){
                    
                    String temp = array[j].getNome();
                    array[j].SetNome(array[j+1].getNome());
                    array[j+1].SetNome(temp);

                }
            }
    }
    
    
    boolean binarySearch(Filmes array[], String x, int tam){


        int l = 0, r = tam;
        
        while (l <= r) {
            comp = comp + 1;
            int m = (l + (r - l) / 2);

            if (array[m].getNome().equals(x)){
                return true;
            }
            
            if(array[m].getNome().compareTo(x) < 0){
                l = m + 1;
            }
            
            else{
                r = m - 1;
            }
        }
  
        return false;
    }
    
}
 
public class buscabinaria {

    // Visualiza o fim dos sites
   
    public static boolean ehFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) throws Exception {
        
        MyIO.setCharset("UTF-8");

        rodar();

    }

    public static void rodar() throws Exception{

        int i = -1;

        String[] input = new String[62];
        
        Lista x = new Lista(100);
        int p = 0;
        String[] vetorString = new String[100];
        int l = - 1;
        int cont = 0;
        int cont2 = 0;
        int comp = 0;
        Filmes[] vector = new Filmes[62];

        do{
             i = i + 1;
            input[i] = MyIO.readLine();

        }while(!ehFim(input[i]));

        long beginTime = new Date().getTime();
        
        for(int y = 0; y < i; y = y + 1 ){
            vector[y] = new Filmes();
            vector[y].leFilme(input[y]);
            x.inserir(vector[y].getNome(), y);
            cont = cont + 1;
            cont2 = cont2 + 1;
        }      

        cont2 = cont2 - 1;

        do{l = l + 1;
            vetorString[l] = MyIO.readLine();
            p = p + 1;
        }while(!ehFim(vetorString[l]));
        long endTime = new Date().getTime();
        x.bubbleSort(vector, cont);
        
        for(i = 0; i < p; i = i + 1){
            comp = comp + 1;
            if(x.binarySearch(vector, vetorString[i], cont2)){
                MyIO.println("SIM");
            }else{
                MyIO.println("NÃO");
            }
        }
        long time = endTime - beginTime;

        Arq.openWrite("713229_buscaBinária.txt");
        Arq.print("713229 " + time + " " + comp);
        Arq.close();
    }
}


