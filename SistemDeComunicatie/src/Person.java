import java.util.Objects;

public class Person {

	private String name;
	private Transmitter transmitter = null;
	
	public Person(String name) {
		this.name = name;
	}
	
	public void send(Person receiver, String text) {
		Message message = new Message(this, receiver, text);
		transmitter.store(message);
	}
	
	public void notify(Transmitter t) {
		Message message = t.retrieve(this);
		if (message == null)
			System.out.println("An error occured: no message available for " + this);
		System.out.println(formatNotification(message, t));
	}

	public String formatNotification(Message message, Transmitter t) {
		String toPrint = message.getSender() + " said to " + message.getReceiver() + " (" + t.transmitterTypeName()
				+ ") : \"" + message.getMessage() + "\"";
		return toPrint;
	}

	public boolean equals(Person person) {
		if (this.name.equals(person.getName()))
			return true;
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getName();
	}
	
	public Transmitter getTransmitter() {
		return transmitter;
	}

	public void setTransmitter(Transmitter transmitter) {
		this.transmitter = transmitter;
	}
}