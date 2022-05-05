
public class EmailTransmitter implements Transmitter {
	public static final String transmitterTypeName = "EMAIL";
	private Message message = null;

	public void store(Message message) {
		this.message = message;
		Person receiver = message.getReceiver();
		receiver.notify(this);
	}

	public Message retrieve(Person receiver) {
		if (receiver.equals(message.getReceiver()))
			return message;
		return null;
	}

	public String transmitterTypeName() {
		return transmitterTypeName;
	}
}