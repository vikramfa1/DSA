public class StringEqualCheck {

    public static int compare(String str1, String str2) {
        if(str1==null|| str2==null) return 0;

        int str1Len = str1.length()-1; int str2Len = str2.length()-1;

        while(str1Len>=0 && str2Len>=0) {
            int i1 = findIndexToCompare( str1, str1Len);
            int i2 = findIndexToCompare( str2, str2Len);

            if(i1<0 && i2<0) {
                return 1;
            }

            if(i1<0 || i2<0) {
                return 0;
            }

            if(str1.charAt(i1) != str2.charAt(i2)) {
                return 0;
            }

            str1Len = i1-1;
            str2Len = i2-1;
        }
        return 1;
    }

    private static int findIndexToCompare(String str, int index) {
        int backSpaceCount = 0;
        while(index>=0) {
            if(str.charAt(index)=='#') {
                backSpaceCount++;
            } else if(backSpaceCount>0) {
                backSpaceCount--;
            } else {
                return index;
            }

            index--;
        }
        return index;
    }

    public static void main(String args[]) {
        System.out.println(StringEqualCheck.compare("xy#z", "xzz#"));
        System.out.println(StringEqualCheck.compare("xy#z", "xyz#"));
        System.out.println(StringEqualCheck.compare("xp#", "xyz##"));
        System.out.println(StringEqualCheck.compare("xywrrmp", "xywrrmu#p"));
    }
}
