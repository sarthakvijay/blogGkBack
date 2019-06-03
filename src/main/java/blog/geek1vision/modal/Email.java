package blog.geek1vision.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "emails")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Email implements Serializable {

	@Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    private Date updatedAt;
    
    @Id
    @NotBlank
    private String email;
    
    private boolean jee;
    
    private boolean medical;
    
    private boolean exams;

	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isJee() {
		return jee;
	}

	public void setJee(boolean jee) {
		this.jee = jee;
	}

	public boolean isMedical() {
		return medical;
	}

	public void setMedical(boolean medical) {
		this.medical = medical;
	}

	public boolean isExams() {
		return exams;
	}

	public void setExams(boolean exams) {
		this.exams = exams;
	}
    
    
    
}
