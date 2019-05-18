package recommender.core.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "play_log_user")
@NamedQuery(name = "PlayLogUser.findAll", query = "SELECT p FROM PlayLogUser p")
public class PlayLogUser implements Serializable
{
	private static final long serialVersionUID = -5217852361248241053L;

	@Id
	@Column(name = "user_id", nullable = false)
	private Integer userId;
	
	@Column(name = "play_time", nullable = false)
	private Date playTime;

}
