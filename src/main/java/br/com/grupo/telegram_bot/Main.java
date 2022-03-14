package main.java.br.com.grupo.telegram_bot;

import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.*;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

public class Main {

	public static void main(String[] args) throws Exception {
		// Criacao do objeto bot com as informacoes de acesso.
		TelegramBot bot = new TelegramBot("5105898544:AAHrZFCgdbBI8pI5BNwEbSc4esNEessKpFs");

		// Objeto responsavel por receber as mensagens.
		GetUpdatesResponse updatesResponse;

		// Objeto responsavel por gerenciar o envio de respostas.
		SendResponse sendResponse;

		// Objeto responsavel por gerenciar o envio de acoes do chat.
		BaseResponse baseResponse;

		String userName = "null";

		Mensagens mensagens = new Mensagens();
		Frase frase = new Frase();
		frase.frase = "Ainda";





		// Controle de off-set, isto e, a partir deste ID sera lido as mensagens
		// pendentes na fila.
		int m = 0;
		boolean start = false;

		// Loop infinito pode ser alterado por algum timer de intervalo curto.
		while (true) {
			// Executa comando no Telegram para obter as mensagens pendentes a partir de um
			// off-set (limite inicial).
			updatesResponse = bot.execute(new GetUpdates().limit(100).offset(m));

			// Lista de mensagens.
			List<Update> updates = updatesResponse.updates();

			// Analise de cada acao da mensagem.
			for (Update update : updates) {

				// Atualizacao do off-set.
				m = update.updateId() + 1;

				System.out.println("Recebendo mensagem: " + update.message().text() );

				// Envio de "Escrevendo" antes de enviar a resposta.
				baseResponse = bot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));

				// Verificacao de acao de chat foi enviada com sucesso.
				System.out.println("Resposta de Chat Action Enviada? " + baseResponse.isOk());

				// Envio da mensagem de resposta.
				System.out.println("Valor de mensagem  " +	update.message().text());
					if (update.message().text().equals("/start")){
						mensagens.start(update.message().text());
						sendResponse = bot.execute(new SendMessage(update.message().chat().id(), mensagens.saudacao));
					}else{
						Frase fra = rest.buscaFrase();
						sendResponse = bot.execute(new SendMessage(update.message().chat().id(), fra.frase));
					}


				// Verificacao de mensagem enviada com sucesso.
				System.out.println("Mensagem Enviada? " + sendResponse.isOk());
			}
		}
	}
}
