package com.sofast.application.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Relationship {
    private String id;
    private String relationshipTitle;
    private String name;
    private String phoneId;
    private String education;
    private String profession;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "relationship_title")
    public String getRelationshipTitle() {
        return relationshipTitle;
    }

    public void setRelationshipTitle(String relationshipTitle) {
        this.relationshipTitle = relationshipTitle;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone_id")
    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    @Basic
    @Column(name = "education")
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "profession")
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Relationship that = (Relationship) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (relationshipTitle != null ? !relationshipTitle.equals(that.relationshipTitle) : that.relationshipTitle != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phoneId != null ? !phoneId.equals(that.phoneId) : that.phoneId != null) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (profession != null ? !profession.equals(that.profession) : that.profession != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (relationshipTitle != null ? relationshipTitle.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phoneId != null ? phoneId.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        return result;
    }
}
