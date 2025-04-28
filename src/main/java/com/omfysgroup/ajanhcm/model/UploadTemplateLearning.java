package com.omfysgroup.ajanhcm.model;


import javax.persistence.*;

import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "UPLOAD_TEMPLATE_LEARNING")
public class UploadTemplateLearning {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UploadTemplateLearning_seq")
	@SequenceGenerator(name = "UploadTemplateLearning_seq", sequenceName = "UPLOAD_TEMPLATE_LEARNING_SEQ", allocationSize = 1)

	     @Column(name = "DOC_ID")
	     private int docId;

	    @Column(name = "DOCUMENT_NAME", length = 255)
	    private String documentName;

	    @Column(name = "DOC_TITLE", length = 255)
	    private String docTitle;

	    @Lob
	    @Column(name = "DOCUMENT")
	    private byte[] document;

	    @Column(name = "CREATED_BY")
	    private int createdBy;

	    @Column(name = "CREATION_TIME")
	    private Date creationTime;

	    @Column(name = "LAST_UPDATED_BY")
	    private int lastUpdatedBy;

	    @Column(name = "LAST_UPDATE_TIME")
	    private Date lastUpdateTime;

		public int getDocId() {
			return docId;
		}

		public void setDocId(int docId) {
			this.docId = docId;
		}

		public String getDocumentName() {
			return documentName;
		}

		public void setDocumentName(String documentName) {
			this.documentName = documentName;
		}

		public String getDocTitle() {
			return docTitle;
		}

		public void setDocTitle(String docTitle) {
			this.docTitle = docTitle;
		}

		public byte[] getDocument() {
			return document;
		}

		public void setDocument(byte[] document) {
			this.document = document;
		}

		public int getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(int createdBy) {
			this.createdBy = createdBy;
		}

		public Date getCreationTime() {
			return creationTime;
		}

		public void setCreationTime(Date creationTime) {
			this.creationTime = creationTime;
		}

		public int getLastUpdatedBy() {
			return lastUpdatedBy;
		}

		public void setLastUpdatedBy(int lastUpdatedBy) {
			this.lastUpdatedBy = lastUpdatedBy;
		}

		public Date getLastUpdateTime() {
			return lastUpdateTime;
		}

		public void setLastUpdateTime(Date lastUpdateTime) {
			this.lastUpdateTime = lastUpdateTime;
		}

		@Override
		public String toString() {
			return "UploadTemplateLearning [docId=" + docId + ", documentName=" + documentName + ", docTitle="
					+ docTitle + ", document=" + Arrays.toString(document) + ", createdBy=" + createdBy
					+ ", creationTime=" + creationTime + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdateTime="
					+ lastUpdateTime + "]";
		}
	    
	
    
}

