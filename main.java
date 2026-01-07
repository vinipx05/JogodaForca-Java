public class main {
    static void main() {
        var jogador = new jogador("Vinicius");
        var palavra = new palavra();
        var jogo = new jogo(palavra,jogador);

        jogo.iniciarJogo();

    }
}
