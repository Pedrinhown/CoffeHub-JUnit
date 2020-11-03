package exceptions;

@SuppressWarnings("serial")
public class ItemInvalidoException extends RuntimeException {
	public ItemInvalidoException() { }

	public ItemInvalidoException(String msg) {
		super(msg);
	}
}
