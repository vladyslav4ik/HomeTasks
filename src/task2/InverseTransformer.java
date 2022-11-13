package task2;

public class InverseTransformer extends TextTransformer{
    private StringBuilder builder;

    public InverseTransformer() {
    }

    public String transform(String text) {
        //first variant
//        String result = "";
//        for (int i = text.length() - 1; i >= 0; i--) {
//            result += text.charAt(i);
//        }
//        return result;

        //second variant
        builder = new StringBuilder(text);
        return builder.reverse().toString();
    }
}
