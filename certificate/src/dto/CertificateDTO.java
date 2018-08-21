package dto;

import java.sql.Date;

public class CertificateDTO {
	private int id;
	private String name;
	private int certiId;
	private String userName;
	private Date date;
	private boolean stats;


	public CertificateDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public CertificateDTO(int id, int certiId, Date date,boolean stats){
		this.id = id;
		this.certiId = certiId;
		this.date = date;
		this.stats = stats;
	}

	public CertificateDTO(String name,String userName, Date date, boolean stats){
		this.name = name;
		this.userName = userName;
		this.date = date;
		this.stats = stats;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isStats() {
		return stats;
	}

	public void setStats(boolean stats) {
		this.stats = stats;
	}

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
	public int getCertiId() {
		return certiId;
	}
	public void setCertiId(int certiId) {
		this.certiId = certiId;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
