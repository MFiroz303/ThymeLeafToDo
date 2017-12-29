package com.bridgeit.todo.validation;

import org.springframework.stereotype.Component;

import com.bridgeit.todo.model.User;

@Component
public class Validator {

	public String validateUserRegistration(User user) {

		String result = "false";
		String nameReg = "^[a-zA-Z\\s]*$";

		String emailReg = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		String phoneReg = "[0-9]{10}";

		String passwordReg = "[a-zA-Z]+[0-9]+";
		

		if (user.getFirstName() == null || user.getFirstName() == "") {
			return "First Name can't be empty ";

		} else if (user.getLastName() == null || user.getLastName() == "") {
			return "Last Name can't be empty ";

		} else if (user.getEmail() == null || user.getEmail() == "") {
			return "Email cant't be empty ";

		} else if (user.getContact() == null || user.getContact()=="") {
			return "phone Number can't be empty ";

		} else if (user.getPassword() == null || user.getPassword() == "") {
			return "password can't be empty ";
		}
			   else if(!user.getFirstName().matches(nameReg)){
		            result="First Name must contains only characters.";
		            return result;
		        }
		        
		        else if(!user.getLastName().matches(nameReg)){
		            result="Last Name must contains only characters.";
		            return result;
		        }
		        
		        else if(!user.getEmail().matches(emailReg)){
		            result="Email is not in Proper format.";
		            return result;
		        }
		        
		        else if(!user.getPassword().matches(passwordReg)){
		            result="Password must contain alphabates and numbers.";
		            return result;
		        }
		        
		        else if(!user.getContact().matches(phoneReg)){
		            result="contact must contain exectly 10 digits";
		            return result;
		        }

		else {
			return "true";
		}

	}
}
