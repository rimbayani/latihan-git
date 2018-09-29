package id.go.bssn.knowledgeManagement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "c_user")
public class User extends BaseEntity {
	
	@Getter	@Setter
	@Column(name = "nomor_user", length = 5)
	private Integer nomorUser;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "nama_user", length = 45, nullable = false)
	private String namaUser;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "nip_user", length = 25, unique = true, nullable = false)
	private String nipUser;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "pangkat_golongan_user", length = 30, nullable = false)
	private String pangkatGolonganUser;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "jabatan_user", length = 100, nullable = false)
	private String jabatanUser;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "unit_kerja_user", length = 100, nullable = false)
	private String unitKerjaUser;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "instansi_user", length = 100, nullable = false)
	private String instansiUser;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "email_user", length = 75, unique = true, nullable = false)
	private String emailUser;
	
	@Getter @Setter
    @Column(name = "is_active_user", nullable = false)
    private Boolean isActiveUser = Boolean.FALSE;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "username_user", length = 45, nullable = false)
	private String usernameUser;
	
	@Getter @Setter
	@Transient
	private String passwordUser;
	
	@Getter @Setter
	@Transient
	private String passwordFileUser;
	
	@Getter @Setter
	@Transient
	private String dongleUser;
	
	@Getter @Setter
	@NotNull @JsonIgnore
	@OneToOne(mappedBy = "idUsernamePassword", optional = true)
	@Cascade(CascadeType.ALL) 
	private UserPassword idUsernamePassword;
	
	@Getter @Setter
	@NotNull
	@ManyToOne 
	@JoinColumn(name = "id_username_role", nullable = false)
	private Role idUsernameRole;
	

	
}
