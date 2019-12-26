/**
 * 
 */
package com.rqr.project.home.core.model;

import java.util.Date;

/**
 * @author ruben
 *
 */
public class Post {
	private int id;
	private String desc;
	private String urlImg;
	private Date fecha;
	private String titulo;
	
	public Post() {}
	
	public Post(int id, String desc, String urlImg, Date fecha, String titulo) {
		this.id = id;
		this.desc = desc;
		this.urlImg = urlImg;
		this.fecha = fecha;
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
