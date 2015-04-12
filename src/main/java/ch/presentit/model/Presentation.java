/**
 * 
 */
package ch.presentit.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "presentation")
public class Presentation {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "title", length = 40)
	private String title;

	@Column(name = "description", length = 256)
	private String description;

	@Column(name = "token", length = 80)
	private String token;

	@Column(name = "access")
	private Boolean access;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Template template;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Slide> slides;

	@Column(name = "created", insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name = "modified", insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	@PrePersist
	void onCreate() {
		this.setCreated(new Date());
	}

	@PreUpdate
	void onUpdate() {
		this.setModified(new Date());
	}

	/**
	 * @return the access
	 */
	public Boolean getAccess() {
		return access;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the modified
	 */
	public Date getModified() {
		return modified;
	}

	/**
	 * @return the slides
	 */
	public List<Slide> getSlides() {
		return slides;
	}

	/**
	 * @return the template
	 */
	public Template getTemplate() {
		return template;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param access
	 *            the access to set
	 */
	public void setAccess(Boolean access) {
		this.access = access;
	}

	/**
	 * @param created
	 *            the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param modified
	 *            the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}

	/**
	 * @param slides
	 *            the slides to set
	 */
	public void setSlides(List<Slide> slides) {
		this.slides = slides;
	}

	/**
	 * @param template
	 *            the template to set
	 */
	public void setTemplate(Template template) {
		this.template = template;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return this.title + " :: " + this.created;
	}

}
