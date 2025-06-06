import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String AT_SYMBOL = "@";
    private static final String AT_MASKED = "@...";
    private static final int ZERO = 0;
    private static final int INDEX_SHIFT = 1;
    private static final String BLANK = "";

    private static List<String> maskEmails(List<String> inputList) {

        if (inputList == null || inputList.isEmpty()) {
            return inputList;
        }

        List<String> result = new ArrayList<>();
        for (String item : inputList) {
            if (item == null || !item.contains(AT_SYMBOL)) {
                continue;
            }

            int lastAtIndex = item.lastIndexOf(AT_SYMBOL);
            String beforeLastAt = item.substring(ZERO, lastAtIndex).replaceAll(AT_SYMBOL, BLANK);
            String afterLastAt = item.substring(lastAtIndex + INDEX_SHIFT);

            // Nếu sau @ cuối cùng không còn gì -> giữ lại @
            // Nếu còn -> thay thành @...
            if (afterLastAt.isEmpty()) {
                result.add(beforeLastAt + AT_SYMBOL);
            } else {
                result.add(beforeLastAt + AT_MASKED);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> inputList = new ArrayList<>();
        inputList.add("Java@");
        inputList.add("@JavaCore");
        inputList.add("List");
        inputList.add("ArrayList");
        inputList.add("tran.the.dung@vsi-international.com");
        inputList.add("dungtt@gmail.com");
        inputList.add("d@ung@vsi-international.com");
        inputList.add("VietSoftw@re@vsi-international.com");
        inputList.add("@@@gmail.com");
        inputList.add("@@@");
        inputList.add(" ");

        List<String> maskedEmails = maskEmails(inputList);
        for (String masked : maskedEmails) {
            System.out.println(masked);
        }
    }
}
