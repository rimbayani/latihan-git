package id.go.bssn.knowledgeManagement.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "t_knowledge_management")
public class KnowledgeManagement extends BaseEntity {

	@Getter	@Setter
	@Column(name = "nomor_knowledge_management", length = 5)
	private int nomorKnowledgeManagement;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "nama_knowledge_management", length = 40, unique = true)
	private String namaKnowledgeManagement;

	@Getter	@Setter
	@Column(name = "deskripsi_knowledge_management", length = 100)
	private String deskripsiKnowledgeManagement;
	
	@Getter @Setter
	@ManyToMany
	@JoinTable(
			name = "c_km_kmdoc",
			joinColumns = @JoinColumn(name = "id_knowledge_management", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "id_knowledge_management_document", nullable = false)
			)
	private Set<KnowledgeManagementDocument> knowledgeManagementDocumentSet = new HashSet<>();
}
