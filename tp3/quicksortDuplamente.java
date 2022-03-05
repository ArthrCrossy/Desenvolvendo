import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.nio.charset.*;
import java.nio.*;

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
    /*Filmes getClone(){
        try {
            return (Filmes) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("ERRO CLONE");
            return this;
        }
    }*/

    public void clone (Filmes j){

        this.SetNome(nome);
        this.setFormato(Formato);
        this.setDuracao(Duracao);
        this.setPais(pais);
        this.setIdioma(idioma);
        this.setEmissora(Emissora);
        this.setTransmissao(transmissao);
        this.setNumbertemp(numberTemp);
        this.setNumberEp(numberEp);

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

class celula {

	public Filmes elemento;
	public celula ant;
	public celula prox;
    public int cont = 0;

	public celula() {
		
	}

	public celula(Filmes elemento) {

		this.elemento = elemento;
		this.ant = this.prox = null;
	}
}

class duplaLista {

	private celula primeiro;
	private celula ultimo;
    public celula cont;

	public duplaLista() {

		primeiro = new celula();
		ultimo = primeiro;
	}

	public void inserirInicio(Filmes x) {

		celula tmp = new celula(x);

        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;

        if(primeiro == ultimo){
            ultimo = tmp;
        }else{
            tmp.prox.ant = tmp;
        }

        tmp = null;
	}

	public void inserirFim(Filmes x) {

		ultimo.prox = new celula(x);
        ultimo.prox.ant = ultimo;
		ultimo = ultimo.prox;

	}

	public Filmes removerInicio(){

        celula tmp = primeiro;
		primeiro = primeiro.prox;
		Filmes resp = primeiro.elemento;
        tmp.prox = primeiro.ant = null;
        tmp = null;

		return resp;
	}

	public Filmes removerFim() {
	
        Filmes resp = ultimo.elemento;
        ultimo = ultimo.ant;
        ultimo.prox.ant = null;
        ultimo.prox = null;

		return resp;
	}

    public Filmes inicializa(){

        Filmes resp = ultimo.elemento;

        return resp;
    }

   public void inserir(Filmes x, int pos){
      
            celula i = primeiro;

         for(int j = 0; j < pos; j++, i = i.prox){
            celula tmp = new celula(x);
            tmp.ant = i;
            tmp.prox = i.prox;
            tmp.ant.prox = tmp.prox.ant = tmp;
            tmp = i = null;
         }
   }

	public Filmes remover(int pos) {

    Filmes resp;
    int tamanho = tamanho();

	    if (pos == 0){
         resp = removerInicio();
      } else if (pos == tamanho - 1){
         resp = removerFim();
      } else {

        celula i = primeiro.prox;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         i.ant.prox = i.prox;
         i.prox.ant = i.ant;
         resp = i.elemento;
         i.prox = i.ant = null;
         i = null;
      }

		return resp;
	}

    public void mostrar() {

		for (celula i = primeiro.prox; i != null; i = i.prox) {
			MyIO.println(i.elemento.getNome() + " " + i.elemento.getFormato() + " " + i.elemento.getDuracao() + " " + i.elemento.getPais() + " " + i.elemento.getIdioma() + " " + i.elemento.getEmissora() + " " + i.elemento.getTransmissao() + " " + i.elemento.getNumberTemp() + " " + i.elemento.getNumberEp());
		}
	}

    
    public celula getCelulaDuplaPosicao(int n){
        celula i = primeiro.prox;

        for(int j = 0; j < n; j = j + 1){
            i = i.prox;
        }

        return i;
    }

    public int tamanho() {

        int tamanho = 0;

        for(celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
        return tamanho;
        }

   public Filmes getMeio(){

    int tam = tamanho()/2;
    int cont = 0    ;
    Filmes elem = inicializa();
    celula i = primeiro;
    
    while(cont != tam){
        
        i = i.prox;
        cont = cont + 1;
        elem = i.prox.elemento;
    }

        return elem;

    }

    public void swap(celula i, celula j){
        Filmes tmp = i.elemento;
        i.elemento = j.elemento;
        j.elemento = tmp;

    }

   public void quickSort(){
        quickNow(0, tamanho() - 1);
   }

   public void quickNow(int esq, int dir){

        int i = esq;
        int j = dir;

        long comeco = new Date().getTime();
        int comp = 0;
        int mov = 0;
        
        Filmes pivo = getCelulaDuplaPosicao((dir+esq)/2).elemento;

    while(i <= j){
        comp = comp +1;
        while((getCelulaDuplaPosicao(i).elemento.getPais().compareTo(pivo.getPais()) < 0) || (getCelulaDuplaPosicao(i).elemento.getPais().compareTo(pivo.getPais()) == 0) && (getCelulaDuplaPosicao(i).elemento.getNome().compareTo(pivo.getNome()) < 0)){
            i = i + 1;
            comp = comp + 1;
        }
        comp = comp + 1;
        while((getCelulaDuplaPosicao(j).elemento.getPais().compareTo(pivo.getPais()) > 0) || (getCelulaDuplaPosicao(j).elemento.getPais().compareTo(pivo.getPais()) == 0) && (getCelulaDuplaPosicao(j).elemento.getNome().compareTo(pivo.getNome()) > 0)){
            j = j - 1;
            comp = comp + 1;
        }
        comp = comp + 1;
        if(i <=j){
            mov = mov + 1;
            swap(getCelulaDuplaPosicao(i), getCelulaDuplaPosicao(j));
            i = i + 1;
            j = j - 1;
        }
    }
        comp = comp + 1;
        if(esq < j){

            quickNow(esq, j);
        }
        comp = comp + 1;
        if(i < dir){
            quickNow(i, dir);
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
class lista {



    public int changeNumber(int number, int j){

        if(number > 0){
            number = j;
        }

        

        return number;
    }
}

 
 public class quicksortDuplamente {

    // Visualiza o fim dos sites
   
    public static boolean ehFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    // transformando String em vetor de caracter
    public static char[] transformaChar(String s){

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
    public static String transformaString(String s){

        String newPalavra = new String();

        for(int i = 3; i < s.length(); i = i + 1){

            newPalavra = newPalavra + s.charAt(i) ;

        }

       // MyIO.println(newPalavra);

        return newPalavra;
    }
    // dividiondo string pegar os numeros
    public static String transformarStringpespaco(String s){

        String newPalavra = new String();

        for(int i = 6; i < s.length(); i = i + 1){

            if(s.charAt(i) != ' ' || s.charAt(i) != 240){

                newPalavra = newPalavra + s.charAt(i);

            }

        }

        return newPalavra;
    }

    public static String transformarNumero(String s){

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
    public static duplaLista converterLista(String input[], int n,duplaLista x) throws Exception {

        Filmes[] vector = new Filmes[100];

        for(int i = 0; i < n; i = i + 1 ){
            vector[i] = new Filmes();
            vector[i].leFilme(input[i]);
           x.inserirInicio(vector[i]);
        }

        return x;
    }

    // inserindo inicio
    public static void trataInserir(String palavra, Filmes html, duplaLista x) throws Exception{

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
    public static void trataRemover(String palavra, Filmes html, duplaLista x) throws Exception {

        if(palavra.charAt(1) == '*'){

            palavra = transformaString(palavra);

            int number = Integer.parseInt(palavra);

            x.remover(number);
            
        }

        if(palavra.charAt(1) == 'I'){

        //    x.removerInicio();
            x.removerInicio();
        }

        if(palavra.charAt(1) == 'F'){

            x.removerFim();
        }

    }

    public static void tratandoDado(int tam, duplaLista x) throws Exception {

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

    public static long time(){
        return new Date().getTime();
    }

    public static void rodar() throws Exception{

        int i = -1;
        String[] input = new String[70];
        
        do{
             i = i + 1;
            input[i] = MyIO.readLine();
        }while(!ehFim(input[i]));

        duplaLista x = new duplaLista();

        x = converterLista(input, i, x);
        x.quickSort();
        x.mostrar();
    }

}



