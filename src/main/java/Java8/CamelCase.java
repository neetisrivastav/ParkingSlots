package Java8;

class CamelCase {

    // Function to convert snake case
    // to camel case
    public static String snakeToCamel(String str)
    {
        str = str.substring(0,1).toUpperCase()+str.substring(1);
        StringBuilder builder = new StringBuilder();
        for (int i =0; i<builder.length();i++)
        {
            if(builder.charAt(i)=='_')
            {
                builder.deleteCharAt(i);
                builder.replace(i,i+1,String.valueOf(Character.toUpperCase(builder.charAt(i))));
            }
        }
        return builder.toString();
    }

        // Capitalize first letter of string
//        str = str.substring(0, 1).toUpperCase()
//                + str.substring(1);
//
//        // Convert to StringBuilder
//        StringBuilder builder
//                = new StringBuilder(str);
//
//        // Traverse the string character by
//        // character and remove underscore
//        // and capitalize next letter
//        for (int i = 0; i < builder.length(); i++) {
//
//            // Check char is underscore
//            if (builder.charAt(i) == '_') {
//
//                builder.deleteCharAt(i);
//                builder.replace(
//                        i, i + 1,
//                        String.valueOf(
//                                Character.toUpperCase(
//                                        builder.charAt(i))));
//            }
//        }
//
//        // Return in String type
//        return builder.toString();
//    }

    // Driver Code
    public static void
    main(String[] args)
    {

        // Given String
        String str = "geeks_for_geeks";

        // Function Call
        str = snakeToCamel(str);

        // Modified String
        System.out.println(str);
    }
}