package id.go.bssn.knowledgeManagement.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import id.go.bssn.knowledgeManagement.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "c_user_password")
public class UserPassword implements Serializable {
	
	@Getter @Setter
	@Id
    @OneToOne @MapsId
    @JoinColumn(name = "id_username_password")
    private User idUsernamePassword;
	
	@Getter @Setter
    @Column(name = "password_user",nullable = false, length = 255)
	private String passwordUser;
    
    @Getter @Setter
	@Column(name = "password_file_user", length = 32)
	private String passwordFileUser;
	
    @Getter @Setter
	@Column(name = "dongle_user", length = 32)
	private String dongleUser;
	
    public UserPassword() {
    }
    
	public UserPassword(User idUsernamePassword, String passwordUser, String passwordFileUser, String dongleUser) {
        this.idUsernamePassword = idUsernamePassword;
        this.passwordUser = passwordUser;
        this.passwordFileUser = passwordFileUser;
        this.dongleUser = dongleUser;	
    }

}
