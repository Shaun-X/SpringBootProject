package shaun.sb.springbootDemo;

public class MyFirstBean {
	private String message = "";
	public MyFirstBean(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "MyFirstBean [message=" + message + "]";
	}
	
}	
