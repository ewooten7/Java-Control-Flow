public class AsciiChars {
    public static void printNumbers() 
    // Prints ASCII numbers, #48-57 (Chr: 0 to 9 on list)
    {
        for (int i = 48; i < 57; i++) {
            System.out.printf("%c ", i);
        }
        System.out.println();
    }

    public static void printLowerCase()
    // Prints ASCII lowercase alphabet, #97-122 (Chr: a to z on list)
    {
        for (int i = 97; i < 122; i++) {
            System.out.printf("%c ", i);
        }
        System.out.println();
    }

    public static void printUpperCase()
    // prints ASCII UPPERCASE alphabet, #65-90 (Chr: A to Z on list)
    {
        for (int i = 65; i < 90; i++) {
            System.out.printf("%c ", i);
        }
        System.out.println();
    }
}