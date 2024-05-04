package com.intern.chatproject.utils;

public class Constrants {

    public static final String API_PUBLIC = "/public/api";
    public static final String API_BASIC = "/basic/api";
    public static final String API_PRIVATE = "/private/api";

    public interface TOKEN{
        Short tokenAccept = 129;
        Short tokenInvalid = 130;
        Short tokenNotAccept = 131;
        Short tokenExpired = 132;
    }
    public interface TYPEACCOUNT{
        Short CUSTOMER = 0;
        Short EMPLOYEE = 1;
    }
    public interface STATUS{
        Short ACTIVE = 1;
        Short INACTIVE = 0;
        Short ONLINE = 1;
        Short OFFLINE = 0;
    }

    public interface MESSAGE_TYPE{
        Short CUSTOMER_SEND = 0;
        Short EMPLOYEE_SEND = 1;
    }
    public interface MESSAGE_STATUS{
        Short SENT = 0;
        Short SEEN = 1;
    }
    public interface SOURCE{
        Short NO_SOURCE = 0;
        Short EMAIL = 1;
        Short FACEBOOK = 2;
        Short GUEST = 3;
    }
    public interface MESSAGE_ERROR{
        String noPermission = "Your account can't use this API";
        String tokenExpired = "Your token has expired";
        String usernameOrPasswordIncorrect = "Username or password incorrect";
        String phoneNumberHasUsed = "Phonenumber has used";
        String emailHasUsed = "Email has used";
        String originNotAccept = "This origin not accept";
    }
    public static final Long validSession = 600000L;// 10 min
    public static final Long oneDayMilis = 86400000L;
    public static final Long basicTokenValid = 2592000000L;
}
