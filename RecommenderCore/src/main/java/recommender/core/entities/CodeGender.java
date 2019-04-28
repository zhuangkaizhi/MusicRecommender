
package recommender.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "code_gender")
@NamedQuery(name = "CodeGender.findAll", query = "SELECT c FROM CodeGender c")
public class CodeGender implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gender_id")
	private int genderId;

	@Column(name = "gender_name")
	private String genderName;
	
	/*
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "codeGender")
	private List<UserInfo> userInfos;
	*/
	
	public CodeGender()
	{
		;
	}

	public int getGenderId()
	{
		return this.genderId;
	}

	public void setGenderId(int genderId)
	{
		this.genderId = genderId;
	}

	public String getGenderName()
	{
		return this.genderName;
	}

	public void setGenderName(String genderName)
	{
		this.genderName = genderName;
	}

	

}
