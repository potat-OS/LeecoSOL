import java.util.HashSet;
import java.util.Set;

class LongestDupSubstring {
    public String longestDupSubstring(String s) {
        Set<String> set = new HashSet<>();
        int len = s.length() - 1;
        if (len < 1) {
            return "";
        }
        for (int win = len; win >= 1; win--) {
            int i = 0, j = win;
            while (j <= s.length()) {
                String str = s.substring(i++, j++);
                if (set.contains(str)) {
                    return str;
                } else {
                    set.add(str);
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new LongestDupSubstring().longestDupSubstring(
                "rtbbfywifhhthadpjixdeodqfgjfykvjwagudthnwfjdqyfskgczdzdsomkxfeizyfnmkirnklfevunbwvevymyoxcnddzhrqnengvjrptpgkusjfpcivknmpcptgbkosyujjcpqugnizpfqfxzrpyxmtbvpxqfbrrupmppkxyltyumcxtyefxjqlmpfymxvrbjmxvqtgnorweoujekkbpdzvhzvchdslcbmavwmjnlypoexhqoxfrnglcyhetrhpemrryhoanasaoyfxeznfeqkgqkzxcuphvngwryfouyugtrhxjfkegzgypucmpanrgyourwglemiclqkcubxbjzhkqzqextijwbfyizgylkyjxeuulkurebpovcxklywnwflnvmufbaauloekgtnabkvfvlsghtgqrkvopcablizoqdcxomhhyxtuwdebmjihmchdxtklvdecwvgogwwepqowfuwluklfiibyqaikphnfpfzhralzuuhsptonslvmkfojfdsumnwwacfwqxkotcqewulorinpzmhduhriisuajcpwjeanvyvpyefglpmfcicsglxtwadtrtaxnozxvchwagdyyinhqmhofuknauhwkinwzmrmermnnzndaxmqkgzotjgkxqhfqvgnvzymvcmdqpfiixrkmjpdbelzojbjeublnwcdsckbpwbbwlloxhecimaysjzwbppgmzywbouicyjdcsaffcxxkmwoamjzicswfzhccdlzewmzotyzprhreseqgmafkzkjqzwukrunckowdfajqhyrhhfhjfuzhvwgkwrmmpgribxqchowwvlbppnkofdfdennafqzawkycytghxehrjwdbrgroqfyoxynkketzkmglrsbqaxgfbiwhtuhzlpszsgbybawnguqhyadwteiikbahnhqdpvmobcsozloyyopxsnjlbgisytssbjbbuucqyvobnflnxtd"));
    }
}
