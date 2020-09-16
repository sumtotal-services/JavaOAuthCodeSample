import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "validationMessages",
        "response",
        "userId",
        "status"
})
public class UserResponseObject implements Serializable
{

    @JsonProperty("validationMessages")
    private List<ValidationMessages> validationMessages = null;
    @JsonProperty("response")
    private String response;
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("status")
    private Integer status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 2360397753596439184L;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserResponseObject() {
    }

    /**
     *
     * @param validationMessages
     * @param response
     * @param userId
     * @param status
     */
    public UserResponseObject(List<ValidationMessages> validationMessages, String response, String userId, Integer status) {
        super();
        this.validationMessages = validationMessages;
        this.response = response;
        this.userId = userId;
        this.status = status;
    }

    @JsonProperty("validationMessages")
    public List<ValidationMessages> getValidationMessages() {
        return validationMessages;
    }

    @JsonProperty("validationMessages")
    public void setValidationMessages(List<ValidationMessages> validationMessages) {
        this.validationMessages = validationMessages;
    }

    @JsonProperty("response")
    public String getResponse() {
        return response;
    }

    @JsonProperty("response")
    public void setResponse(String response) {
        this.response = response;
    }

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
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

