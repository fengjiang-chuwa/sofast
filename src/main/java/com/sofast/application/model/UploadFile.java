package com.sofast.application.model;

import javax.persistence.*;
import java.util.Date;

/*
 *
 * @author fjiang
 * @description
 * @date 8/9/16
 */
@Entity
@Table(name = "upload_file", schema = "so_fast", catalog = "")
public class UploadFile {
    
    private String id;
    private String filePath;
    private String fileRealName;
    private String fileDispName;
    private String uploadBy;
    private Date uploadDate;
    private String description;
    private String status;
    private String type;

    @Id
    @Column(name = "id", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "file_path", nullable = false, length = 200)
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "file_real_name", nullable = false, length = 150)
    public String getFileRealName() {
        return fileRealName;
    }

    public void setFileRealName(String fileRealName) {
        this.fileRealName = fileRealName;
    }

    @Basic
    @Column(name = "file_disp_name", nullable = false, length = 100)
    public String getFileDispName() {
        return fileDispName;
    }

    public void setFileDispName(String fileDispName) {
        this.fileDispName = fileDispName;
    }

    @Basic
    @Column(name = "upload_by", nullable = false, length = 36)
    public String getUploadBy() {
        return uploadBy;
    }

    public void setUploadBy(String uploadBy) {
        this.uploadBy = uploadBy;
    }

    @Basic
    @Column(name = "upload_date", nullable = false)
    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UploadFile that = (UploadFile) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) return false;
        if (fileRealName != null ? !fileRealName.equals(that.fileRealName) : that.fileRealName != null) return false;
        if (fileDispName != null ? !fileDispName.equals(that.fileDispName) : that.fileDispName != null) return false;
        if (uploadBy != null ? !uploadBy.equals(that.uploadBy) : that.uploadBy != null) return false;
        if (uploadDate != null ? !uploadDate.equals(that.uploadDate) : that.uploadDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return status != null ? !status.equals(that.status) : that.status != null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (fileRealName != null ? fileRealName.hashCode() : 0);
        result = 31 * result + (fileDispName != null ? fileDispName.hashCode() : 0);
        result = 31 * result + (uploadBy != null ? uploadBy.hashCode() : 0);
        result = 31 * result + (uploadDate != null ? uploadDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}