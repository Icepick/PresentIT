package ch.presentit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "template")
public class Template {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	private Boolean master;

	@OneToOne(fetch = FetchType.LAZY)
	private Color color;

	@OneToOne(fetch = FetchType.LAZY)
	private Image image;

	@OneToOne(fetch = FetchType.LAZY)
	private Video video;

	@OneToOne(fetch = FetchType.LAZY)
	private Sound sound;

	@OneToOne(fetch = FetchType.LAZY)
	private Font font;

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @return the font
	 */
	public Font getFont() {
		return font;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @return the master
	 */
	public Boolean getMaster() {
		return master;
	}

	/**
	 * @return the sound
	 */
	public Sound getSound() {
		return sound;
	}

	/**
	 * @return the video
	 */
	public Video getVideo() {
		return video;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @param font
	 *            the font to set
	 */
	public void setFont(Font font) {
		this.font = font;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * @param master
	 *            the master to set
	 */
	public void setMaster(Boolean master) {
		this.master = master;
	}

	/**
	 * @param sound
	 *            the sound to set
	 */
	public void setSound(Sound sound) {
		this.sound = sound;
	}

	/**
	 * @param video
	 *            the video to set
	 */
	public void setVideo(Video video) {
		this.video = video;
	}

}
