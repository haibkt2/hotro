package model;

import java.util.HashSet;
import java.util.Set;

public class support {
	private int idsupport;
	private String support;
	private Set<menu> menu;
	public int getIdsupport() {
		return idsupport;
	}

	public void setIdsupport(int idsupport) {
		this.idsupport = idsupport;
	}

	public String getSupport() {
		return support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	public void setSupport(int idsp, String sp) {
		this.idsupport = idsp;
		this.support = sp;

	}

	public Set<menu> getMenu() {
		return menu;
	}

	public void setMenu(Set<menu> menu) {
		this.menu = menu;
	}

	public support() {
	}
	public void addMenu(menu mn) {
		if (this.menu == null) {
			this.menu = new HashSet<menu>();
		}
		this.menu.add(mn);
	}
}
