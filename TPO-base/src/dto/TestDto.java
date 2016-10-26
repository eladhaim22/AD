package dto;

import java.io.Serializable;
import java.rmi.RemoteException;

public class TestDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String test;
	
	public TestDto(String test){
		super();
		this.test = test;
	}

	public TestDto(int id, String test){
		super();
		this.id = id;
		this.test = test;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getTest(){
		return test;
	}

	public void setTest(String test){
		this.test = test;
	}
	
	@Override
	public String toString() {
		return "Test [id=" + id + ", test=" + test
				+ "]";
	}
	
}