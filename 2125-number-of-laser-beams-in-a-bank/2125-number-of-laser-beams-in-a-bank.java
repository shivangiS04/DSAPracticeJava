  public static int numberOfBeams(String[] bank) {
    int result = 0 , prev = 0;
        for (int i = 0; i < bank.length ; i++) {
            int count = 0;
            for (char c:bank[i].toCharArray()) 
                count += c;
            if (count == 0) continue;
            result += prev *count;
            prev = count;
        }
        return result;
    }