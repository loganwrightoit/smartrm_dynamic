package srm.model;

import java.sql.Timestamp;

public class BookingModel {
	private int b_id;
	private int l_id;
	private int rr_id;
	private int u_id;
	private Timestamp start_time;
	private Timestamp end_time;
	private String specialrequests;
	private String purpose;
	
	public BookingModel()
	{
		
	}
	
	public BookingModel(int b_id, int l_id, int rr_id, int u_id, Timestamp start_time, Timestamp end_time, String specialrequests, String purpose)
	{
		this.b_id = b_id;
		this.l_id = l_id;
		this.rr_id = rr_id;
		this.u_id = u_id;
		this.start_time = start_time;
		this.end_time = end_time;
		this.specialrequests = specialrequests;
		this.purpose = purpose;
	}
	
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public int getL_id() {
		return l_id;
	}
	public void setL_id(int l_id) {
		this.l_id = l_id;
	}
	public int getRr_id() {
		return rr_id;
	}
	public void setRr_id(int rr_id) {
		this.rr_id = rr_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	public String getSpecialrequests() {
		return specialrequests;
	}
	public void setSpecialrequests(String specialrequests) {
		this.specialrequests = specialrequests;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
}
