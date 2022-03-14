package main.java.br.com.grupo.telegram_bot;

public class Mensagens {
    private String nomeUsuario;
    private String mensagemRecebida;
    public String saudacao;
    private String resposta;

    public Mensagens() throws Exception {
    }


    public String start(String mensagem) {
        if (mensagem.equals("/start")) {
            System.out.println("Entrei " + mensagem);
        }
        saudacao = "Qual o seu nome?";

        return saudacao;
    }


    public String getMensagemRecebida() {
        return mensagemRecebida;
    }

    public void setMensagemRecebida(String mensagemRecebida) {
        this.mensagemRecebida = mensagemRecebida;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        setResposta(
                "ótimo! " + this.nomeUsuario + " vamos conversar?"
        );
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }


    public String getResposta() {
        return resposta;
    }
    public String getFrases () throws Exception {
        Frase fra = rest.buscaFrase();
        fra.frase = resposta;
        return  resposta;
    }


}
