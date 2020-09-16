import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "isMobileEnabled",
        "mobileUsername",
        "userPassword"
})
public class PersonMobileUser implements Serializable {

    @JsonProperty("isMobileEnabled")
    private Boolean isMobileEnabled;
    @JsonProperty("mobileUsername")
    private Object mobileUsername;
    @JsonProperty("userPassword")
    private Object userPassword;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7055744473187800260L;

    /**
     * No args constructor for use in serialization
     */
    public PersonMobileUser() {
    }

    /**
     * @param userPassword
     * @param mobileUsername
     * @param isMobileEnabled
     */
    public PersonMobileUser(Boolean isMobileEnabled, Object mobileUsername, Object userPassword) {
        super();
        this.isMobileEnabled = isMobileEnabled;
        this.mobileUsername = mobileUsername;
        this.userPassword = userPassword;
    }

    @JsonProperty("isMobileEnabled")
    public Boolean getIsMobileEnabled() {
        return isMobileEnabled;
    }

    @JsonProperty("isMobileEnabled")
    public void setIsMobileEnabled(Boolean isMobileEnabled) {
        this.isMobileEnabled = isMobileEnabled;
    }

    @JsonProperty("mobileUsername")
    public Object getMobileUsername() {
        return mobileUsername;
    }

    @JsonProperty("mobileUsername")
    public void setMobileUsername(Object mobileUsername) {
        this.mobileUsername = mobileUsername;
    }

    @JsonProperty("userPassword")
    public Object getUserPassword() {
        return userPassword;
    }

    @JsonProperty("userPassword")
    public void setUserPassword(Object userPassword) {
        this.userPassword = userPassword;
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
