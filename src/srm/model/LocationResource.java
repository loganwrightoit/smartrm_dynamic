package srm.model;

public class LocationResource {
	
	public LocationResource(int r_id, String r_name, String r_type, String r_desc)
	{
		this.r_id = r_id;
		this.r_name = r_name;
		this.r_type = r_type;
		this.r_desc = r_desc;
	}
	
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_type() {
		return r_type;
	}
	public void setR_type(String r_type) {
		this.r_type = r_type;
	}
	public String getR_desc() {
		return r_desc;
	}
	public void setR_desc(String r_desc) {
		this.r_desc = r_desc;
	}

	int r_id;
	String r_name;
	String r_type;
	String r_desc;
	
}
