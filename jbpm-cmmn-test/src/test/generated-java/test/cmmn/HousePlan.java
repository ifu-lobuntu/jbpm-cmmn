package test.cmmn;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import test.cmmn.collection.OneToManySet;
@Entity(name = "HousePlan")
@Table(name = "house_plan")
public class HousePlan {
	@OneToOne()
	@JoinColumns(value = { @JoinColumn(name = "construction_case_id", referencedColumnName = "id") })
	private ConstructionCase constructionCase = null;
	@Id()
	@GeneratedValue()
	private String id = null;
	@OneToOne(mappedBy = "housePlan", cascade = CascadeType.ALL)
	private RoofPlan roofPlan = null;
	@SuppressWarnings("serial")
	private transient OneToManySet<HousePlan, RoomPlan> roomPlansWrapper = new OneToManySet<HousePlan, RoomPlan>(this) {
		public Set<RoomPlan> getDelegate() {
			return roomPlans;
		}

		@SuppressWarnings("unchecked")
		protected OneToManySet<HousePlan, RoomPlan> getChildren(HousePlan parent) {
			return (OneToManySet<HousePlan, RoomPlan>) parent.getRoomPlans();
		}

		public HousePlan getParent(RoomPlan child) {
			return (HousePlan) child.getHousePlan();
		}

		public void setParent(RoomPlan child, HousePlan parent) {
			child.zz_internalSetHousePlan(parent);
		}

		public boolean isLoaded() {
			return true;
		}

		public boolean isInstanceOfChild(Object o) {
			return o instanceof RoomPlan;
		}
	};
	@OneToMany(mappedBy = "housePlan", cascade = CascadeType.ALL)
	private Set<RoomPlan> roomPlans = new HashSet<RoomPlan>();
	@SuppressWarnings("serial")
	private transient OneToManySet<HousePlan, WallPlan> wallPlansWrapper = new OneToManySet<HousePlan, WallPlan>(this) {
		public Set<WallPlan> getDelegate() {
			return wallPlans;
		}

		@SuppressWarnings("unchecked")
		protected OneToManySet<HousePlan, WallPlan> getChildren(HousePlan parent) {
			return (OneToManySet<HousePlan, WallPlan>) parent.getWallPlans();
		}

		public HousePlan getParent(WallPlan child) {
			return (HousePlan) child.getHousePlan();
		}

		public void setParent(WallPlan child, HousePlan parent) {
			child.zz_internalSetHousePlan(parent);
		}

		public boolean isLoaded() {
			return true;
		}

		public boolean isInstanceOfChild(Object o) {
			return o instanceof WallPlan;
		}
	};
	@OneToMany(mappedBy = "housePlan", cascade = CascadeType.ALL)
	private Set<WallPlan> wallPlans = new HashSet<WallPlan>();
	String path;
	@javax.persistence.Basic()
	private String uuid = getUuid();

	public HousePlan() {
	}

	public HousePlan(ConstructionCase owner) {
		this.setConstructionCase(owner);
	}

	public ConstructionCase getConstructionCase() {
		ConstructionCase result = this.constructionCase;
		return result;
	}

	public String getId() {
		String result = this.id;
		return result;
	}

	public RoofPlan getRoofPlan() {
		RoofPlan result = this.roofPlan;
		return result;
	}

	public Set<RoomPlan> getRoomPlans() {
		Set<RoomPlan> result = this.roomPlansWrapper;
		return result;
	}

	public Set<WallPlan> getWallPlans() {
		Set<WallPlan> result = this.wallPlansWrapper;
		return result;
	}

	public void setConstructionCase(ConstructionCase newConstructionCase) {
		ConstructionCase oldValue = this.constructionCase;
		if ((newConstructionCase == null || !(newConstructionCase.equals(oldValue)))) {
			this.constructionCase = newConstructionCase;
			if (!(oldValue == null)) {
				oldValue.setHousePlan(null);
			}
			if (!(newConstructionCase == null)) {
				if (!(this.equals(newConstructionCase.getHousePlan()))) {
					newConstructionCase.setHousePlan(this);
				}
			}
		}
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setRoofPlan(RoofPlan newRoofPlan) {
		RoofPlan oldValue = this.roofPlan;
		if ((newRoofPlan == null || !(newRoofPlan.equals(oldValue)))) {
			this.roofPlan = newRoofPlan;
			if (!(oldValue == null)) {
				oldValue.setHousePlan(null);
			}
			if (!(newRoofPlan == null)) {
				if (!(this.equals(newRoofPlan.getHousePlan()))) {
					newRoofPlan.setHousePlan(this);
				}
			}
		}
	}

	public void setRoomPlans(Set<RoomPlan> newRoomPlans) {
		this.roomPlans = newRoomPlans;
	}

	public void setWallPlans(Set<WallPlan> newWallPlans) {
		this.wallPlans = newWallPlans;
	}

	public void zz_internalSetConstructionCase(ConstructionCase value) {
		this.constructionCase = value;
	}

	public void zz_internalSetRoofPlan(RoofPlan value) {
		this.roofPlan = value;
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
		return o instanceof HousePlan && ((HousePlan) o).getUuid().equals(getUuid());
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
