/**
 * Class used to test the Profile class which stores information about a person
 * This information is then later used as a parameter in a BSTNode
 * @author James Brcck
 */

public class ProfileMain {
    public static void main(String[] args){
        //Creating a new profile with the required data
        Profile james = new Profile("James", "Swansea", "UK", "British", 23, 12, 1998, new String[]{"Guitar", "Reading", "Running"});

        //Testing the toString() to ensure that all the data is properly constructed
        System.out.println(james.toString());
        //Testing a couple individual get methods
        System.out.println(james.getMyName());
        System.out.println(james.getBirthDate());

        //Update a few attributes using a few set methods
        james.setMyTown("Great Torrington");
        james.setMyNationality("White British");
        james.setMyCountry("England");
        james.setMyInterests(new String[]{"Cooking", "Songwriting", "Gaming"});

        //Print out an updated toString() method to log the changes to the profile
        System.out.println(james.toString());
    }
}
