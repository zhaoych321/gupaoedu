package config.user.domain;

import java.io.Serializable;

/**
 * c_user
 * @author 
 */
public class CUser implements Serializable {
    private int userId;

    private String name;

    private int exp;

    private String comment;

    private boolean hasReleasedGuild;

    private boolean hasReleasedLeague;

    private boolean hasReleasedPvp;

    private boolean hasReleasedArousal;

    private boolean hasReleasedPowerUp;

    private boolean hasReleasedInherit;

    private int pvpGradeId;

    private int pvpGradeIdUpdatedAt;

    private int pvpStandardGradeId;

    private int pvpStandardGradeIdUpdatedAt;

    private byte tutorialPhase;

    private String teamName;

    private byte languageCode;

    private int updatedAt;

    private int createdAt;

    private int totalPayAmount;

    private String biLogJson;

    private static final long serialVersionUID = 1L;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isHasReleasedGuild() {
        return hasReleasedGuild;
    }

    public void setHasReleasedGuild(boolean hasReleasedGuild) {
        this.hasReleasedGuild = hasReleasedGuild;
    }

    public boolean isHasReleasedLeague() {
        return hasReleasedLeague;
    }

    public void setHasReleasedLeague(boolean hasReleasedLeague) {
        this.hasReleasedLeague = hasReleasedLeague;
    }

    public boolean isHasReleasedPvp() {
        return hasReleasedPvp;
    }

    public void setHasReleasedPvp(boolean hasReleasedPvp) {
        this.hasReleasedPvp = hasReleasedPvp;
    }

    public boolean isHasReleasedArousal() {
        return hasReleasedArousal;
    }

    public void setHasReleasedArousal(boolean hasReleasedArousal) {
        this.hasReleasedArousal = hasReleasedArousal;
    }

    public boolean isHasReleasedPowerUp() {
        return hasReleasedPowerUp;
    }

    public void setHasReleasedPowerUp(boolean hasReleasedPowerUp) {
        this.hasReleasedPowerUp = hasReleasedPowerUp;
    }

    public boolean isHasReleasedInherit() {
        return hasReleasedInherit;
    }

    public void setHasReleasedInherit(boolean hasReleasedInherit) {
        this.hasReleasedInherit = hasReleasedInherit;
    }

    public int getPvpGradeId() {
        return pvpGradeId;
    }

    public void setPvpGradeId(int pvpGradeId) {
        this.pvpGradeId = pvpGradeId;
    }

    public int getPvpGradeIdUpdatedAt() {
        return pvpGradeIdUpdatedAt;
    }

    public void setPvpGradeIdUpdatedAt(int pvpGradeIdUpdatedAt) {
        this.pvpGradeIdUpdatedAt = pvpGradeIdUpdatedAt;
    }

    public int getPvpStandardGradeId() {
        return pvpStandardGradeId;
    }

    public void setPvpStandardGradeId(int pvpStandardGradeId) {
        this.pvpStandardGradeId = pvpStandardGradeId;
    }

    public int getPvpStandardGradeIdUpdatedAt() {
        return pvpStandardGradeIdUpdatedAt;
    }

    public void setPvpStandardGradeIdUpdatedAt(int pvpStandardGradeIdUpdatedAt) {
        this.pvpStandardGradeIdUpdatedAt = pvpStandardGradeIdUpdatedAt;
    }

    public byte getTutorialPhase() {
        return tutorialPhase;
    }

    public void setTutorialPhase(byte tutorialPhase) {
        this.tutorialPhase = tutorialPhase;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public byte getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(byte languageCode) {
        this.languageCode = languageCode;
    }

    public int getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(int updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public int getTotalPayAmount() {
        return totalPayAmount;
    }

    public void setTotalPayAmount(int totalPayAmount) {
        this.totalPayAmount = totalPayAmount;
    }

    public String getBiLogJson() {
        return biLogJson;
    }

    public void setBiLogJson(String biLogJson) {
        this.biLogJson = biLogJson;
    }
}