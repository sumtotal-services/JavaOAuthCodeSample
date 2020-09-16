import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "domainId",
        "userSecurityRoleId",
        "isPrimary",
        "deleted",
        "code"
})
public class PersonDomain implements Serializable {

    @JsonProperty("domainId")
    private Integer domainId;
    @JsonProperty("userSecurityRoleId")
    private Integer userSecurityRoleId;
    @JsonProperty("isPrimary")
    private Boolean isPrimary;
    @JsonProperty("deleted")
    private Integer deleted;
    @JsonProperty("code")
    private String code;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5219984564551484638L;

    /**
     * No args constructor for use in serialization
     */
    public PersonDomain() {
    }

    /**
     * @param deleted
     * @param code
     * @param isPrimary
     * @param userSecurityRoleId
     * @param domainId
     */
    public PersonDomain(Integer domainId, Integer userSecurityRoleId, Boolean isPrimary, Integer deleted, String code) {
        super();
        this.domainId = domainId;
        this.userSecurityRoleId = userSecurityRoleId;
        this.isPrimary = isPrimary;
        this.deleted = deleted;
        this.code = code;
    }

    @JsonProperty("domainId")
    public Integer getDomainId() {
        return domainId;
    }

    @JsonProperty("domainId")
    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    @JsonProperty("userSecurityRoleId")
    public Integer getUserSecurityRoleId() {
        return userSecurityRoleId;
    }

    @JsonProperty("userSecurityRoleId")
    public void setUserSecurityRoleId(Integer userSecurityRoleId) {
        this.userSecurityRoleId = userSecurityRoleId;
    }

    @JsonProperty("isPrimary")
    public Boolean getIsPrimary() {
        return isPrimary;
    }

    @JsonProperty("isPrimary")
    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    @JsonProperty("deleted")
    public Integer getDeleted() {
        return deleted;
    }

    @JsonProperty("deleted")
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
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
