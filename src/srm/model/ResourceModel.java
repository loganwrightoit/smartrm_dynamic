package srm.model;

public class ResourceModel {

	private int id;
	private String name;
	private int l_id;
	private int r_id;
	private String specPurpose;
	private int cap;
	public ResourceModel(int id, String name, int l_id, int r_id,
			String specPurpose, int cap) {
		this.id=id;
		this.name=name;
		this.l_id=l_id;
		this.r_id=r_id;
		this.specPurpose=specPurpose;
		this.cap=cap;
		// TODO Auto-generated constructor stub
	}

}
