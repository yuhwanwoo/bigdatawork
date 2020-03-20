package spring.data.mongodb.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//mongodb Collection에서 하나의 document와 매핑될 클래스
// (자동으로 매핑해준대)

@Document(collection="score") //()안에는 컬렉션이 뭔지 알려줘야함
public class ScoreDTO {
	@Id
	String _id;
	String id;
	String name;
	String dept;
	String addr;
	int java;
	int servlet;
	
	public ScoreDTO() {
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getServlet() {
		return servlet;
	}

	public void setServlet(int servlet) {
		this.servlet = servlet;
	}

	@Override
	public String toString() {
		return "ScoreDTO [id=" + id + ", name=" + name + ", dept=" + dept + ", addr=" + addr + ", java=" + java
				+ ", servlet=" + servlet + "]";
	}
	
	
	
}
