package dev.entities.task;

public class Task {
	private int tId;
	private String descri;
	private String priority;
	private boolean complete;
	
	
	
	
	public Task() {
		super();
		
	}
	public Task(int tId, String descri, String priority, boolean complete) {
		super();
		this.tId = tId;
		this.descri = descri;
		this.priority = priority;
		this.complete = complete;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String getDescri() {
		return descri;
	}
	public void setDescri(String descri) {
		this.descri = descri;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	@Override
	public String toString() {
		return "Task [tId=" + tId + ", descri=" + descri + ", priority=" + priority + ", complete=" + complete + "]";
	}
	
	

}
