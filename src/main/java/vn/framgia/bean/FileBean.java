package vn.framgia.bean;

import vn.framgia.model.FileS3;


public class FileBean {
	private Integer id;
	private String nameFile;
	private String description;
	private String status;
	private String link;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameFile() {
		return nameFile;
	}

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public FileBean setObFileBean(FileS3 file){
		this.setId(file.getId());
		this.setDescription(file.getDescription());
		this.setNameFile(file.getNameFile());
		this.setLink(file.getLink());
		this.setStatus(file.getStatus());
		return this;
	}
}
