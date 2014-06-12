package ru.misosi.mecab;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the devices database table.
 * 
 */
@Entity
@Table(name="devices")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	private String os;

	public Device() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOs() {
		return this.os;
	}

	public void setOs(String os) {
		this.os = os;
	}

}