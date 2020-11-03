import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents a Profile of a person on a social network
 * The class contains all of their data such as their name, hometown etc.
 * They have a friends list which is later populated by use of a file
 * @author James Brock
 */

public class Profile {
    private String myName;
    private String myTown;
    private String myCountry;
    private String myNationality;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private String[] myInterests;
    private ArrayList<Profile> friendsList = new ArrayList<>();

    /**
     * Creates a new profile
     * @param name The name of the profile, can contain first and last name or just either
     * @param town The town the person currently resides in
     * @param country The country the person currently resides in
     * @param nationality The nationality of the person
     * @param day Their day of birth as an integer
     * @param month Their month of birth as an integer
     * @param year Their year of birth as an integer
     * @param interests An array of their interests
     */

    public Profile(String name, String town, String country, String nationality, int day, int month, int year, String[] interests){
        this.myName = name;
        this.myTown = town;
        this.myCountry = country;
        this.myNationality = nationality;
        this.birthDay = day;
        this.birthMonth = month;
        this.birthYear = year;
        this.myInterests = interests;
    }

    /**
     * Method to convert the contents of the profile into a string
     * @return Returns a multiline string generated by the method
     */
    public String toString(){
        String result = "";
        result += "\nThe owner of the profile is called " + myName + "\n";
        result += "They live in " + myTown + " in " + myCountry + " and their nationality is " + myNationality + "\n";
        result += "Their date of birth is " + getBirthDate() + "\n";
        //Converts the array of their interests into a readable string
        result += "Their interests include: " + Arrays.toString(getMyInterests()) + "\n";
        result += "Their friends are: ";
        //Gets the name of each person in their friends list
        for(Profile p : friendsList){
            result += (p.getMyName() + ", ");
        }
        result += "their total number of friends is " + numOfFriends() + "\n";
        return result;
    }

    /**
     * Gets the name of profile
     * @return The name of the profile
     */

    public String getMyName() {
        return myName;
    }

    /**
     * Sets the town that the owner of the profile resides in
     * @param myTown Their current town as a string
     */

    public void setMyTown(String myTown) {
        this.myTown = myTown;
    }

    /**
     * Gets their current town of residence
     * @return Their current town as a string
     */

    public String getMyTown() {
        return myTown;
    }

    /**
     * Sets the current country of residence for the profile
     * @param myCountry The current country as a string
     */
    public void setMyCountry(String myCountry) {
        this.myCountry = myCountry;
    }

    /**
     * Gets the current country of residence on the profile
     * @return The current country of residence as a string
     */
    public String getMyCountry() {
        return myCountry;
    }

    /**
     * Sets the nationality of the person in their profile
     * @param myNationality The nationality of the person as a string
     */
    public void setMyNationality(String myNationality) {
        this.myNationality = myNationality;
    }

    /**
     * Gets the nationality of the person
     * @return The nationality of the person as a string
     */
    public String getMyNationality() {
        return myNationality;
    }

    /**
     * Sets the array of interests the person has in the profile
     * @param myInterests an array that contains their interests
     */
    public void setMyInterests(String[] myInterests) {
        this.myInterests = myInterests;
    }

    /**
     * Gets their interests
     * @return An array of strings of their interests
     */
    public String[] getMyInterests() {
        return myInterests;
    }

    /**
     * Gets the full birth date of the person all as a string by concatenating the three int dates
     * @return A string that is comprised of the ints of day, month and year
     */
    public String getBirthDate(){
        String returnDate = "";
        returnDate += birthDay + "/" + birthMonth + "/" + birthYear;
        return returnDate;
    }

    /**
     * Adds a friend to the user's friend list
     * @param p Another profile that is to be linked to the user's profile
     */
    public void addFriend(Profile p){
        friendsList.add(p);
    }

    /**
     * Gets a given friend from the person's friends list via index
     * @param i the index to be used when searching the friends list
     * @return The element at the given index within the array list
     */
    public Profile getFriend(int i){
        return friendsList.get(i);
    }

    /**
     * Gets the total number of friends on the person's profile
     * @return The length of the friendsList arrayList
     */
    public int numOfFriends(){
        return friendsList.size();
    }
}
