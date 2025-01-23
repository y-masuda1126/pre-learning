package pro.kensait.java.advanced.lsn_7_1_4.overload;

public class Main {
    public static void main(String[] args) {
        // Stringが引数の場合は、CharSequenceなのかComparableなのか判断できないため、
        // メソッドの前に<>で明示的に指定が必要
        MyUtil.<CharSequence>process("100");

        // Integerの場合は明示的に指定は不要
        MyUtil.process(100);
    }
}