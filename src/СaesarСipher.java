public class СaesarСipher {

    public static void main(String[] args) {
        String message = "hello zzz aaa!";
        String codeMessage = getCodingIncodMessage(message, 14, 'a', 'z');
        System.out.println(message + " -> " + codeMessage);
        String deCodeMessage = getCodingIncodMessage(codeMessage, -14, 'a', 'z');
        System.out.println(codeMessage + " -> " + deCodeMessage);
        message = "мама мыла раму и я";
        codeMessage = getCodingIncodMessage(message, 14, 'а', 'я');
        System.out.println(message + " -> " + codeMessage);
        deCodeMessage = getCodingIncodMessage(codeMessage, -14, 'а', 'я');
        System.out.println(codeMessage + " -> " + deCodeMessage);
    }

    private static String getCodingIncodMessage(String message, int key, char firstCharAlfabet, char lastCharAlfabet) {
        StringBuilder strBox = new StringBuilder(message.length());
        char tmp;
        int countCharsAlfabet = (lastCharAlfabet - firstCharAlfabet) + 1;
        for (int i = 0; i < message.length(); i++) {
            tmp = message.charAt(i);
            if (Character.isLetter(message.charAt(i))) {
                tmp += key % countCharsAlfabet;
                if (tmp > lastCharAlfabet)
                    tmp = (char) (tmp % lastCharAlfabet + firstCharAlfabet - 1);
                else if (tmp < firstCharAlfabet)
                    tmp = (char) (tmp + countCharsAlfabet);
            }
            strBox.append(tmp);
        }
        return strBox.toString();
    }
}
