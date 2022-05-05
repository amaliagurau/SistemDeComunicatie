
public class Message {

	private String message;
	private Person sender, receiver;

	public Message(Person sender, Person receiver, String message) {
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
	}

	public String toString() {
		String toPrint = sender + " said to " + receiver + " : \"" + message + "\"";
		return toPrint;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Person getSender() {
		return sender;
	}

	public void setSender(Person sender) {
		this.sender = sender;
	}

	public Person getReceiver() {
		return receiver;
	}

	public void setReceiver(Person receiver) {
		this.receiver = receiver;
	}
}
