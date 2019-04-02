/**
 * Stores a line of a Java program for later analysis
 */
class JavaLine
{
    private String java    = ""; // Java code on line
    private String comment = ""; // The single line comment
    private int    lenJava = 0;  // The line length of just the java code
    /**
     * Constructor
     * @param line of a java program
     */
    public JavaLine( String line )
    {
        Program aProgram = new Program();//calling the program class.

        boolean Iscomment = false; //set to false as a default - Checking if there's a comment on the line.

        for (int i=0; i < line.length();i++){
            if (!Iscomment){//while no comment has been found, add the line letter by letter to the java variable.
                    if (line.charAt(i) != '/' && line.charAt(i)+1 != '/' || line.charAt(i) == '.'){//This loops until double slashes are found.
                    java = java + line.charAt(i);
                } else {                   
                    Iscomment = true;//when a comment is found this is set to true.
                    comment = comment + line.charAt(i); //now the line is put into the comment variable instead.
                }
            } else if (Iscomment){//now that there is a comment found, the comment variable is filled up with the comment.
                comment = comment + line.charAt(i);
            }           
        }
        if (comment.length() == 2){//If the comment includes nothing, set the comment variable to nothing.
            comment = "";
        }
        
        returnLineWithCommentAt(aProgram.findMaxJavaLineLength());//Returns the final output.
    }

        /**
         * Return the length of the Java part of the stored line.<PRE>
         * JavaLine j = new JavaLine("int a; // Declaration");
         * int jp = j.getJavaLineLength();
         * Would set jp the be 6</PRE>
         * @return The length of the Java code in the line
         */
        public int getJavaLineLength()
        {
        int lenJava = java.trim().length();//Find the length of the java string.
        return lenJava;
    }
    

    /**
     * Returd' line with the // comment
     * starting at column pos<PRE>
     * JavaLine j = new JavaLine("int a; // Declaration");
     * String res = j.returnLineWithCommentAt(10);
     * Would set res to be the following string:
     * int a;   // Declaration</PRE>
     * @param pos Start // comment at pos
     * @return A new version of the line with any // comment
     * starting at column pos.
     */
    public String returnLineWithCommentAt(int chars )
    {   
        int sp = chars - java.length(); //Works out amount of spaces needed.
        
        String newline = java + spaces(sp) + comment; // Creates the new line.
        return newline;
    }

    /**
     * Return a string of 'number' spaces.
     * @param number of spaces required
     * @return A string of 'number' spaces
     */
    public static String spaces( int number )
    {
        String numspaces = ""; //Create an instance of a string with no spaces.
        for (int i = 0; i < number;i++){ //Loop while i is less than number (amount of spaces needed).
            numspaces = numspaces + " ";//Add a space to the string for each loop.
        }
        return numspaces;
    }
}
