package com.laura.api.payload;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignupRequest {
    @NotBlank
    @Size(max = 320)
    @Email
    private String email;
    
    private String firstname;
    
    private String lastname;
    
    @NotBlank
    @Size(min = 6, max = 64)
    private String password;

    private int gender;
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
      return gender;
    }

    public void setGender(int gender) {
      this.gender = gender;
    }

    @Override
    public String toString() {
      return "SignupRequest [email=" + email + ", firstname=" + firstname + ", gender=" + gender + ", lastname="
          + lastname + ", password=" + password + "]";
    }
}