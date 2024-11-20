public class Main_MethodChain {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            Person3 p = new Person3("Alice", 25);
            if (p.createGreetMessage("JAPANESE").startsWith("おはよう")) {
                System.out.println("「おはよう」で始まるメッセージが生成されました");
            }
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_2 *****");
            Person3 p = new Person3("Alice");
            p.withAge(25).withNationality("JAPAN");
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_3 *****");
            Person3 p = (new Person3("Alice")).withAge(25).withNationality("JAPAN");
            String pName = p.name;
            int pAge = p.age;
            String pNationality = p.nationality;
            System.out.println(pName);
            System.out.println(String.valueOf(pAge));
            System.out.println(pNationality);
            System.out.println("=> end");
        }
    }
}