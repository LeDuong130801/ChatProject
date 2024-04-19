package com.intern.chatproject.utils;

public class Constrants {

    public static final String API_PUBLIC = "/public/api";
    public static final String API_BASIC = "/basic/api";
    public static final String API_PRIVATE = "/private/api";

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
        Short GMAIL = 3;
    }
    public static final Long validSession = 600000L;// 10 min
}
