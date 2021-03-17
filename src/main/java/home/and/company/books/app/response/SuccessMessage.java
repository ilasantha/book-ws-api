package home.and.company.books.app.response;

public class SuccessMessage {

	private String operation;
	private String message;
	
	public SuccessMessage(String operation, String message) {
			this.operation = operation;
		this.message = message;
	}
	
	public SuccessMessage()
	{
		//Default. 
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
