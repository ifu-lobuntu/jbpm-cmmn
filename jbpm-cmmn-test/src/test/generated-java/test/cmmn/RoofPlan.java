package test.cmmn;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "RoofPlan")
@Table(name = "roof_plan")
public class RoofPlan {
	@OneToOne(mappedBy = "roofPlan")
	private House house = null;
	@OneToOne()
	@JoinColumns(value = { @JoinColumn(name = "house_plan_id", referencedColumnName = "id") })
	private HousePlan housePlan = null;
	@Id()
	@GeneratedValue()
	private String id = null;
	@Basic()
	@Column(name = "short_description")
	private String shortDescription = "";
	String path;
	@javax.persistence.Basic()
	private String uuid = getUuid();

	public RoofPlan() {
	}

	public RoofPlan(HousePlan owner) {
		this.setHousePlan(owner);
	}

	public House getHouse() {
		House result = this.house;
		return result;
	}

	public HousePlan getHousePlan() {
		HousePlan result = this.housePlan;
		return result;
	}

	public String getId() {
		String result = this.id;
		return result;
	}

	public String getShortDescription() {
		String result = this.shortDescription;
		return result;
	}

	public void setHouse(House newHouse) {
		House oldValue = this.house;
		if ((newHouse == null || !(newHouse.equals(oldValue)))) {
			this.house = newHouse;
			if (!(oldValue == null)) {
				oldValue.setRoofPlan(null);
			}
			if (!(newHouse == null)) {
				if (!(this.equals(newHouse.getRoofPlan()))) {
					newHouse.setRoofPlan(this);
				}
			}
		}
	}

	public void setHousePlan(HousePlan newHousePlan) {
		HousePlan oldValue = this.housePlan;
		if ((newHousePlan == null || !(newHousePlan.equals(oldValue)))) {
			this.housePlan = newHousePlan;
			if (!(oldValue == null)) {
				oldValue.setRoofPlan(null);
			}
			if (!(newHousePlan == null)) {
				if (!(this.equals(newHousePlan.getRoofPlan()))) {
					newHousePlan.setRoofPlan(this);
				}
			}
		}
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setShortDescription(String newShortDescription) {
		this.shortDescription = newShortDescription;
	}

	public void zz_internalSetHouse(House value) {
		this.house = value;
	}

	public void zz_internalSetHousePlan(HousePlan value) {
		this.housePlan = value;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String value) {
		this.path = value;
	}

	public int hashCode() {
		return getUuid().hashCode();
	}

	public boolean equals(Object o) {
		return o instanceof RoofPlan && ((RoofPlan) o).getUuid().equals(getUuid());
	}

	public String getUuid() {
		if (uuid == null) {
			uuid = java.util.UUID.randomUUID().toString();
		}
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
