package blog.geek1vision.modal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "josaaRanks")
@EntityListeners(AuditingEntityListener.class)
public class Josaa implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
	private String Institute_Name;
	
	@NotBlank
	private String Branch_Name;
	
	@NotBlank
	private String Category;
	
	@NotBlank
	private String Seat_Pool;
	
	@NotBlank
	private String Alloted_Quote;
	
	private Long Closing;
	
	private Long Opening;
	
	public String getInstitute_Name() {
		return Institute_Name;
	}

	public void setInstitute_Name(String institute_Name) {
		Institute_Name = institute_Name;
	}

	public String getBranch_Name() {
		return Branch_Name;
	}

	public void setBranch_Name(String branch_Name) {
		Branch_Name = branch_Name;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getSeat_Pool() {
		return Seat_Pool;
	}

	public void setSeat_Pool(String seat_Pool) {
		Seat_Pool = seat_Pool;
	}

	public String getAlloted_Quote() {
		return Alloted_Quote;
	}

	public void setAlloted_Quote(String alloted_Quote) {
		Alloted_Quote = alloted_Quote;
	}

	public long getClosing() {
		return Closing;
	}

	public void setClosing(long closing) {
		Closing = closing;
	}

	public long getOpening() {
		return Opening;
	}

	public void setOpening(long opening) {
		Opening = opening;
	}

	private Long Round;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setClosing(Long closing) {
		Closing = closing;
	}

	public void setOpening(Long opening) {
		Opening = opening;
	}

	public void setRound(Long round) {
		Round = round;
	}

	public Josaa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getRound() {
		return Round;
	}

	public void setRound(long round) {
		Round = round;
	}
	
	

}
