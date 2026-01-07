import java.util.ArrayList;
import java.util.Scanner;

public class jogo {
    private final palavra palavra;
    private final jogador jogador;

    public jogo(palavra palavra, jogador jogador) {
        this.palavra = palavra;
        this.jogador = jogador;
    }

    public void iniciarJogo() {
        var numeroChutes=10;
        var chutes= new ArrayList<String>();

        this.palavra.gerarPalavraSecreta();

        var scanner = new Scanner(System.in);
        System.out.println("Óla "+ this.jogador.getNome()+", bem-vindo ao Jogo da Forca!");
        System.out.println("você tem "+ numeroChutes + " chutes para adivinhar a palavra secreta.");
        System.out.println(this.palavra.getPalavraComChute()+ "\n");

        while(!this.palavra.palavaraCompleta() && chutes.size()<numeroChutes) {
            System.out.println("Digite seu chute: ");
            var chute = scanner.nextLine();

            if (chutes.contains(chute)) {
                System.out.println("Você jà chutou essa letra! Tente novamente." );
                continue;
            }
            chutes.add(chute);
            this.palavra.revelarLetra(chute);

            System.out.println("Palavra: "+ this.palavra.getPalavraComChute());

            if(this.palavra.palavaraCompleta()) {
                System.out.println("Parabéns "+this.jogador.getNome()+" Você venceu!");

            } else if (chutes.size()== numeroChutes) {
                System.out.println("Você perdeu "+ this.jogador.getNome()+ " A palavra secreta è: "+this.palavra.getPalavraSecreta());

            }
        }
    }
}
