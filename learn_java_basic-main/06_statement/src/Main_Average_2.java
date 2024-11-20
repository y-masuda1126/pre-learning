public class Main_Average_2 {
    public static void main(String[] args) {
        int[] scores = {650, 570, 700};
        double sum = 0;
        for (int i = 0; i < scores.length; i++) { //【1】
            sum += scores[i]; //【2】
        }
        double avg = sum / scores.length;
        System.out.println(avg);
    }
}