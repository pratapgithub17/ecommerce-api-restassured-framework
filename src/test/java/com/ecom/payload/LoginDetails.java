
package com.ecom.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class LoginDetails {

    @JsonProperty("userEmail")
    private String userEmail;
    @JsonProperty("userPassword")
    private String userPassword;

    @JsonProperty("userEmail")
    public String getUserEmail() {
        return userEmail;
    }

    @JsonProperty("userEmail")
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @JsonProperty("userPassword")
    public String getUserPassword() {
        return userPassword;
    }

    @JsonProperty("userPassword")
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
  

	

}