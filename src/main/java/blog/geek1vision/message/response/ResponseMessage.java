package blog.geek1vision.message.response;

public class ResponseMessage {
	private String message;

	public ResponseMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
}