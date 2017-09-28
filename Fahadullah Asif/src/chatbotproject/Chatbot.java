package chatbotproject;

public class Chatbot {

		private String userName;
		private Topic fahad;
		private boolean chatting;
		
		
		public Chatbot() {
			fahad = new ChatbotFahad();
			username = "unknown user";
		}
		
		public void startTalking() {
			ChatbotMain.print("Welcome to our chatbot! What is your name?");
			username = ChatbotMain.getInput();
			while(chatting) {
				ChatbotMain.print("What do you want to talk about?");
				String response = ChatbotMain.getInput();
				if(fahad.isTriggered(response)) {
					chattting = false;
					fahad.startChatting();
		
				}
				else {
					ChatbotMain.print("I'm sorry. I dont understand what you are talking about?");
				}
			}
		}
}
