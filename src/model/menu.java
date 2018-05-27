package model;

import java.util.HashSet;
import java.util.Set;

public class menu {
	private int idmenu;
	private String menu;
	private int idsupport;
	private Set<content> contents;
	private content ct;

	public menu() {
	}
	public menu(int idmeu,String menu) {
		this.idmenu = idmeu;
		this.menu = menu;
	}
	
	public content getCt() {
		return ct;
	}

	public void setCt(content ct) {
		this.ct = ct;
	}

	public void setMenu(int idmn,String menu) {
		this.idmenu = idmn;
		this.menu = menu;
	}
	public menu(String menu,int idsp,int idmn) {
		this.menu = menu;
		this.idsupport = idsp;
		this.idmenu = idmn; 
	}
	
	public menu(String menu) {
		this.menu = menu;
		
	}

	public int getIdmenu() {
		return idmenu;
	}

	public void setIdmenu(int idmenu) {
		this.idmenu = idmenu;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getIdsupport() {
		return idsupport;
	}

	public void setIdsupport(int idsupport) {
		this.idsupport = idsupport;
	}

	public Set<content> getContents() {
		return contents;
	}

	public void setContents(Set<content> contents) {
		this.contents = contents;
	}

	public void addMenu(content ct) {
		if (this.contents == null) {
			this.contents = new HashSet<content>();
		}
		this.contents.add(ct);
	}
}
