package model;

public abstract class Area {
	protected Integer areaId;

	public Area(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
}
