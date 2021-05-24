package kr.ac.hansung.exception;

public class NotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 8795546082074185666L;
	
	private String info;
	
	public NotFoundException(String info) {
		super();
		this.info = info;
	}
	
	public String getInfo() {
		return info;
	}
}
