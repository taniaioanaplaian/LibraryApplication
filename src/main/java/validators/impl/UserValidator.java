package validators.impl;

import model.entity.User;
import model.enumeration.Role;
import validators.api.Validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator implements Validator<User> {

    private Pattern usernamePattern;
    private Pattern passwordPattern;
    private Matcher usernameMatcher;
    private Matcher passwordMatcher;

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]+${3,15}$";
    //lower case upper case number special character minimum 4
    private  static  final String  PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!?@#$%]).{4,20})";

    public UserValidator(){

        usernamePattern = Pattern.compile(USERNAME_PATTERN);
        passwordPattern = Pattern.compile(PASSWORD_PATTERN);
    }


    public boolean validateUsername(final String username){

        usernameMatcher = usernamePattern.matcher(username);
        return usernameMatcher.matches();
    }

    public boolean validatePassword(final String password){
        passwordMatcher = passwordPattern.matcher(password);
        return passwordMatcher.matches();

    }

    public boolean validateRole(final Role role){
        return role.equals(Role.ADMINISTRATOR) || role.equals(Role.EMPLOYEE);
    }


    @Override
    public boolean isValid(User obj) {

        return validatePassword(obj.getPassword()) && validateRole(obj.getRole()) && validateUsername(obj.getUserName());
    }
}
