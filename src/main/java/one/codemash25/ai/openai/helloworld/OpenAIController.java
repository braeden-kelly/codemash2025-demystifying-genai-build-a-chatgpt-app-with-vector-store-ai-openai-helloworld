package one.codemash25.ai.openai.helloworld;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
class OpenAIController {
	private final ChatClient chatClient;

	OpenAIController(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	@GetMapping("/ai/openai/chat")
	Map<String, String> completion(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
		return Map.of(
				"completion",
				chatClient.prompt()
						.user(message)
						.call()
						.content());
	}
}
