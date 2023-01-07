package hometask8;

public class Task8Test {
    public static void main(String[] args) {
        MyDictionary dictionary = new MyDictionary();
        dictionary.addNewWord("how", "як");
        dictionary.addNewWord("are", "бути");
        dictionary.addNewWord("you", "ви");
        dictionary.translate();
        dictionary.saveDictionary("src/hometask8/output/dictionary.txt");
    }
}
