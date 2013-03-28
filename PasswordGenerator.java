import java.util.*;

public class PasswordGenerator
{
    private static Random noise = new Random(); 


    public PasswordGenerator()
    {
        super();
    }
    
    /**
     * Returns a random char between a - z inclusive (all in lowercase)
     */
    public static char randomLetter()
    {
        return (char) (PasswordGenerator.noise.nextInt(26) + 97);
        
    }
    /**
     * Returns a StringBuilder object of random letters, the number
     * of letters is decided by the int argument.
     */
    
    public static StringBuilder makePassword(int num)
    {
           StringBuilder pass = new StringBuilder();
           
           for (int i = 0; i < num; i++)
            {
                pass.append(PasswordGenerator.randomLetter());   
            }
            
            return pass;
    }
    /**
     * Prints a list of 10 passwords made up of 8 different characters
     * to the display.
     */
    public static void printPasswords()
    {
            for (int i = 0; i < 10; i++)
            {
                System.out.println(PasswordGenerator.makePassword(8).toString());     
            }
    }
    
    /**
     * Returns an instance of StringBuilder which is a password made up of 
     * random letters from a - z inclusive and a number between 2 - 9 
     * inclusive. 50% of the time the the number will be at the start
     * and 50% it will be at the end. The methods argument specifies
     * the total lenght of the password returned.
     */
    public static StringBuilder makeBetterPassword(int length)
    {
            StringBuilder pass = PasswordGenerator.makePassword(length -1);
            pass.append(PasswordGenerator.noise.nextInt(8) + 2);
            
            if (PasswordGenerator.noise.nextBoolean())
            {
                return pass.reverse();   
            }
            else
            {
                return pass;   
            }     
    }
    
    /**
     * This method takes an int argument and returns a StringBuilder object
     * of the same length. This will be a random sequence of characters
     * with a number between 2 - 9 inclusive at either the start or 
     * the end and any letter 'l' or letter 'o' removed and replaced 
     * with an underscore '_'
     */
    public static StringBuilder makeEvenBetterPassword(int length)
    {
        StringBuilder pass = PasswordGenerator.makeBetterPassword(length);
        for (int i = 0; i < pass.length(); i++)
        {
            if (pass.charAt(i) == 'l')
            {
                pass.setCharAt(i, '_');   
            }
            
                if (pass.charAt(i) == 'o')
                {
                    pass.setCharAt(i, '_');   
                }
        }
        return pass;
    }
}
