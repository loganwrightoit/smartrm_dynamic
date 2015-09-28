package srm.model;

public class RegisteredResource
{

	public RegisteredResource(int rr_id, String rr_name, int l_id, int r_id, String special_features, int capacity)
	{
		this.rr_id = rr_id;
		this.rr_name = rr_name;
		this.l_id = l_id;
		this.r_id = r_id;
		this.special_features = special_features;
		this.capacity = capacity;
	}
	
	public RegisteredResource() {} // For Bean usage
	
	public int getRr_id() {
		return rr_id;
	}

	public void setRr_id(int rr_id) {
		this.rr_id = rr_id;
	}

	public String getRr_name() {
		return rr_name;
	}

	public void setRr_name(String rr_name) {
		this.rr_name = rr_name;
	}

	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getSpecial_features() {
		return special_features;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	int rr_id;
	String rr_name;
	int l_id;
	int r_id;
	String special_features;
	int capacity;
	
}
