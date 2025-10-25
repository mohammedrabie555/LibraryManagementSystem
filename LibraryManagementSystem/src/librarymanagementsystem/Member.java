package librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberFirstName;
    private String memberLastName;
    private int memberAge;
    private String memberAddress;
    private String jobTitle;
    
    String memberID = "2024" + (memberSerial + 1);
    static int memberSerial = 0;
    
    List <Book> book = new ArrayList<>();
    
    public Member(String memberFirstName, String memberLastName, int memberAge, String memberAddress, String jobTitle) {
        this.memberFirstName = memberFirstName;
        this.memberLastName = memberLastName;
        this.memberAge = memberAge;
        this.memberAddress = memberAddress;
        this.jobTitle = jobTitle;
        memberSerial++;
    }
    
    public String getMemberFirstName() {
        return memberFirstName;
    }

    public void setMemberFirstName(String memberFirstName) {
        this.memberFirstName = memberFirstName;
    }

    public String getMemberLastName() {
        return memberLastName;
    }

    public void setMemberLastName(String memberLastName) {
        this.memberLastName = memberLastName;
    }

    public int getMemberAge() {
        return memberAge;
    }

    public void setMemberAge(int memberAge) {
        this.memberAge = memberAge;
    }


    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getMemberID() {
        return memberID;
    }
    
    public void display(){
        System.out.println(
                "Member name: "+ getMemberFirstName()+" "+getMemberLastName()+"\n"+
                "Member ID     : "+ getMemberID()+"\n"+
                "Age           : "+ getMemberAge()+"\n"+
                "Address       : "+ getMemberAddress()+"\n"+
                "Job title     : "+ getJobTitle()
        );
    }
}
