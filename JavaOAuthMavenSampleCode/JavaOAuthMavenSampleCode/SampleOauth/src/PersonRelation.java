import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "manager1Id",
        "jobTitle",
        "locationName",
        "locationCode"
})
public class PersonRelation implements Serializable {

    @JsonProperty("manager1Id")
    private Object manager1Id;
    @JsonProperty("jobTitle")
    private Object jobTitle;
    @JsonProperty("locationName")
    private Object locationName;
    @JsonProperty("locationCode")
    private Object locationCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3223501272614191356L;

    /**
     * No args constructor for use in serialization
     */
    public PersonRelation() {
    }

    /**
     * @param locationName
     * @param jobTitle
     * @param manager1Id
     * @param locationCode
     */
    public PersonRelation(Object manager1Id, Object jobTitle, Object locationName, Object locationCode) {
        super();
        this.manager1Id = manager1Id;
        this.jobTitle = jobTitle;
        this.locationName = locationName;
        this.locationCode = locationCode;
    }

    @JsonProperty("manager1Id")
    public Object getManager1Id() {
        return manager1Id;
    }

    @JsonProperty("manager1Id")
    public void setManager1Id(Object manager1Id) {
        this.manager1Id = manager1Id;
    }

    @JsonProperty("jobTitle")
    public Object getJobTitle() {
        return jobTitle;
    }

    @JsonProperty("jobTitle")
    public void setJobTitle(Object jobTitle) {
        this.jobTitle = jobTitle;
    }

    @JsonProperty("locationName")
    public Object getLocationName() {
        return locationName;
    }

    @JsonProperty("locationName")
    public void setLocationName(Object locationName) {
        this.locationName = locationName;
    }

    @JsonProperty("locationCode")
    public Object getLocationCode() {
        return locationCode;
    }

    @JsonProperty("locationCode")
    public void setLocationCode(Object locationCode) {
        this.locationCode = locationCode;
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
