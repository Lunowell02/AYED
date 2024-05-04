package EJ4;

public class AreaEmpresa {
	private String id;
	private int tardanza;
	
	public AreaEmpresa(String unId, int unaTardanza) {
		this.id=unId;
		this.tardanza = unaTardanza;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTardanza() {
		return tardanza;
	}

	public void setTardanza(int tardanza) {
		this.tardanza = tardanza;
	}
	
}
