package id.go.bssn.knowledgeManagement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "t_knowledge_management_document")
public class KnowledgeManagementDocument extends BaseEntity {
	@Getter	@Setter
	@Column(name = "nomor_knowledge_management_document", length = 5)
	private int nomorKnowledgeManagementDocument;
	
	@Getter @Setter
	@NotNull @NotEmpty
	@Column(name = "nama_knowledge_management_document", length = 40, unique = true)
	private String namaKnowledgeManagementDocument;
	
	@Getter	@Setter
	@Column(name = "jenis_knowledge_management_document", length = 50)
	private String jenisKnowledgeManagementDocument;

	@Getter	@Setter
	@Column(name = "deskripsi_knowledge_management_document", length = 100)
	private String deskripsiKnowledgeManagementDocument;
	
}
