package srm.model;

public class ResourceModel {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSpecPurpose() {
		return specPurpose;
	}

	public void setSpecPurpose(String specPurpose) {
		this.specPurpose = specPurpose;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	private int id;
	private String name;
	private int l_id;
	private int r_id;
	private String specPurpose;
	private int cap;
	
	public ResourceModel(int id, String name, int l_id, int r_id, String specPurpose, int cap)
	{
		this.id=id;
		this.name=name;
		this.l_id=l_id;
		this.r_id=r_id;
		this.specPurpose=specPurpose;
		this.cap=cap;
	}

}
