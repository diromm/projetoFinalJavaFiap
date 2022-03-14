package main.java.br.com.grupo.telegram_bot;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class rest {
    static String webService = "https://allugofrases.herokuapp.com/frases/random";
    static int codigoSucesso = 200;


    public static Frase buscaFrase() throws Exception {
        String urlParaChamada = webService;
        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Util.converteJsonEmString(resposta);

            Gson gson = new Gson();
            Frase endereco = gson.fromJson(jsonEmString, Frase.class);

            return endereco;
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }



}
