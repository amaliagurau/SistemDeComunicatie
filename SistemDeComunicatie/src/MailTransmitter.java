
public class MailTransmitter implements Transmitter {

	public static final String transmitterTypeName = "MAIL";
	private Message[] buffer;
	private int index;

	public MailTransmitter(int bufferSize) {
		buffer = new Message[bufferSize];
		int index = 0;
	}

	public void store(Message message) {
		if (index == buffer.length) {
			System.out.println("Nu se mai pot accepta scrisori pentru ca bufferul este plin!");
			return;
		}
		buffer[index++] = message;
		if (index == buffer.length) {
			for (int i = 0; i < buffer.length; i++) {
				Person receiver = buffer[i].getReceiver();
				receiver.notify(this);
			}
			index = 0;
		}
	}

	public Message retrieve(Person receiver) {
		for (int i = 0; i < buffer.length; i++)
			if (buffer[i].getReceiver().equals(receiver))
				return buffer[i];
		return null;
	}

	public String transmitterTypeName() {
		return transmitterTypeName;
	}
}
