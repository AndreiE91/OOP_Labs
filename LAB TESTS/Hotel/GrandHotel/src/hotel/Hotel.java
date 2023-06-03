package hotel;

import java.util.HashSet;
import java.util.Set;

public class Hotel {

	private Set<Area> areas;

	public Hotel() {
		areas = new HashSet<Area>();
	}

	public Set<Area> getAreas() {
		return this.areas;
	}

	public void addArea(Area area) {
		areas.add(area);
	}

}
