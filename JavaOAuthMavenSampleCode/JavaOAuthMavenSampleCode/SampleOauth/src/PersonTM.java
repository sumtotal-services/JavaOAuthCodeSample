import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "maritalCode",
        "veteranCode"
})
public class PersonTM implements Serializable {

    @JsonProperty("maritalCode")
    private String maritalCode;
    @JsonProperty("veteranCode")
    private Object veteranCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8632053004054727539L;

    /**
     * No args constructor for use in serialization
     */
    public PersonTM() {
    }

    /**
     * @param maritalCode
     * @param veteranCode
     */
    public PersonTM(String maritalCode, Object veteranCode) {
        super();
        this.maritalCode = maritalCode;
        this.veteranCode = veteranCode;
    }

    @JsonProperty("maritalCode")
    public String getMaritalCode() {
        return maritalCode;
    }

    @JsonProperty("maritalCode")
    public void setMaritalCode(String maritalCode) {
        this.maritalCode = maritalCode;
    }

    @JsonProperty("veteranCode")
    public Object getVeteranCode() {
        return veteranCode;
    }

    @JsonProperty("veteranCode")
    public void setVeteranCode(Object veteranCode) {
        this.veteranCode = veteranCode;
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
