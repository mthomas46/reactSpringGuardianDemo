package com.example.reactSpringDemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Guardian {
    private @Id
    @GeneratedValue
    @JsonIgnore Long id;
    private String iconPath;
    private int crossSaveOverride;
    private boolean isPublic;
    private String membershipType;
    private String membershipId;
    private String displayName;

    private Guardian() {
    }

    public Guardian(String displayName, String membershipId) {
        this.displayName = displayName;
        this.membershipId = membershipId;
    }

    public Guardian(String iconPath, int crossSaveOverride, boolean isPublic, String membershipType, String membershipId, String displayName) {
        this.iconPath = iconPath;
        this.crossSaveOverride = crossSaveOverride;
        this.isPublic = isPublic;
        this.membershipType = membershipType;
        this.membershipId = membershipId;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public int getCrossSaveOverride() {
        return crossSaveOverride;
    }

    public void setCrossSaveOverride(int crossSaveOverride) {
        this.crossSaveOverride = crossSaveOverride;
    }

    public boolean isisPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
//    @Override
//    public String toString(){
//        return"this is a another string";
//    }
}

