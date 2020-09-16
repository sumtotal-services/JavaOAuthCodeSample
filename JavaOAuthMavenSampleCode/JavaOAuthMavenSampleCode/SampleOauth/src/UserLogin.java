import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "username",
        "userPassword",
        "userEnabled",
        "currentDomainId",
        "userCulture",
        "userTypeId",
        "isLocked",
        "mustChangePassword",
        "passwordExpiryDate"
})
public class UserLogin implements Serializable {

    @JsonProperty("username")
    private String username;
    @JsonProperty("userPassword")
    private Object userPassword;
    @JsonProperty("userEnabled")
    private Boolean userEnabled;
    @JsonProperty("currentDomainId")
    private Integer currentDomainId;
    @JsonProperty("userCulture")
    private Object userCulture;
    @JsonProperty("userTypeId")
    private Integer userTypeId;
    @JsonProperty("isLocked")
    private Boolean isLocked;
    @JsonProperty("mustChangePassword")
    private Boolean mustChangePassword;
    @JsonProperty("passwordExpiryDate")
    private Object passwordExpiryDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3653266889392492513L;

    /**
     * No args constructor for use in serialization
     */
    public UserLogin() {
    }

    /**
     * @param userTypeId
     * @param userPassword
     * @param userEnabled
     * @param isLocked
     * @param passwordExpiryDate
     * @param userCulture
     * @param mustChangePassword
     * @param currentDomainId
     * @param username
     */
    public UserLogin(String username, Object userPassword, Boolean userEnabled, Integer currentDomainId, Object userCulture, Integer userTypeId, Boolean isLocked, Boolean mustChangePassword, Object passwordExpiryDate) {
        super();
        this.username = username;
        this.userPassword = userPassword;
        this.userEnabled = userEnabled;
        this.currentDomainId = currentDomainId;
        this.userCulture = userCulture;
        this.userTypeId = userTypeId;
        this.isLocked = isLocked;
        this.mustChangePassword = mustChangePassword;
        this.passwordExpiryDate = passwordExpiryDate;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("userPassword")
    public Object getUserPassword() {
        return userPassword;
    }

    @JsonProperty("userPassword")
    public void setUserPassword(Object userPassword) {
        this.userPassword = userPassword;
    }

    @JsonProperty("userEnabled")
    public Boolean getUserEnabled() {
        return userEnabled;
    }

    @JsonProperty("userEnabled")
    public void setUserEnabled(Boolean userEnabled) {
        this.userEnabled = userEnabled;
    }

    @JsonProperty("currentDomainId")
    public Integer getCurrentDomainId() {
        return currentDomainId;
    }

    @JsonProperty("currentDomainId")
    public void setCurrentDomainId(Integer currentDomainId) {
        this.currentDomainId = currentDomainId;
    }

    @JsonProperty("userCulture")
    public Object getUserCulture() {
        return userCulture;
    }

    @JsonProperty("userCulture")
    public void setUserCulture(Object userCulture) {
        this.userCulture = userCulture;
    }

    @JsonProperty("userTypeId")
    public Integer getUserTypeId() {
        return userTypeId;
    }

    @JsonProperty("userTypeId")
    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    @JsonProperty("isLocked")
    public Boolean getIsLocked() {
        return isLocked;
    }

    @JsonProperty("isLocked")
    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    @JsonProperty("mustChangePassword")
    public Boolean getMustChangePassword() {
        return mustChangePassword;
    }

    @JsonProperty("mustChangePassword")
    public void setMustChangePassword(Boolean mustChangePassword) {
        this.mustChangePassword = mustChangePassword;
    }

    @JsonProperty("passwordExpiryDate")
    public Object getPasswordExpiryDate() {
        return passwordExpiryDate;
    }

    @JsonProperty("passwordExpiryDate")
    public void setPasswordExpiryDate(Object passwordExpiryDate) {
        this.passwordExpiryDate = passwordExpiryDate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
