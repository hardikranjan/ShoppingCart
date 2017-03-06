package com.ShoppingCart.Domain;

/**
 * Created by hardikranjan on 20/02/17.
 */
public class DomainUser
{
    private int userid;
    private String username,useraddress,useremail;

    public DomainUser()
    {
        this.userid=userid;
        this.username = username;
        this.useraddress = useraddress;
        this.useremail = useremail;
    }

    public int getUserid()
    {
        return userid;
    }
    public String getAddress()
    {
        return useraddress;
    }
    public String getName()
    {
        return username;
    }
    public String getEmail()
    {
        return useremail;
    }

    public void setUserid(int userid)
    {
        this.userid = userid;
    }
    public void setName(String username)
    {
        this.username = username;
    }
    public void setAddress(String useraddress)
    {
        this.useraddress = useraddress;
    }

    public void setEmail(String useremail)
    {
        this.useremail = useremail;
    }

    public String toString()
    {
        return "User{"+"UserId= " + userid + "\tUserName='" + username +
                "\tUserAddress= " + useraddress +  "\tUserEmail= " + useremail + '}';
    }
}
