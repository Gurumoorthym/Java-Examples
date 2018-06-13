package dependencyInjection.consumer;

import dependencyInjection.services.MessageService;

public class MessageSend implements MessageConsumer{
	private MessageService ms;
	public MessageSend(MessageService ms){
		this.ms = ms;
	}
	
	
	@Override
	public void processMessage(String msg, String to) {
		if(null != msg && null != to) {
			ms.sendMessage(msg, to);
		}
		
	}

}
