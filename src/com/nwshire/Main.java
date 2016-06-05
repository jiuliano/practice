package com.nwshire;

import com.nwshire.leetcode.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        /*
        Set<Object> set = new HashSet<Object>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");
        set.add("f");
        set.add("g");

        System.out.println("Results: ");
        Set<Set<Object>> result = getAllSubsets(set);
        for ( Set<Object> subset : result ) {
            System.out.print("{ ");
            for ( Object object : subset ) {
                System.out.print(object + " ");
            }
            System.out.println("} ");
        }
        */
        long t1 = System.currentTimeMillis();
        testWordLadder2();
        System.out.println("TIME 2:  " + (System.currentTimeMillis() - t1));
        t1 = System.currentTimeMillis();
        testWordLadder3();
        System.out.println("TIME 3:  " + (System.currentTimeMillis() - t1));
        t1 = System.currentTimeMillis();
        testWordLadder();
        System.out.println("TIME X:  " + (System.currentTimeMillis() - t1));
    }

    private static void testWordLadder() {
        WordLadder wl = new WordLadder();
        String[] wlArr = new String[] {
                "si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"
        };
        Set<String> wordList = new HashSet<String>();
        List<List<String>> ladders;

        for ( int n=0; n<wlArr.length; n++ ) {
            wordList.add(wlArr[n]);
        }

        int length = wl.ladderLength("qa", "sq", wordList);

        String[] wlArr2 = new String[] {
                "kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"
        };

        wordList.clear();
        for ( int n=0; n<wlArr.length; n++ ) {
            wordList.add(wlArr[n]);
        }
        length = wl.ladderLength("cet", "ism", wordList);
        System.out.println("One length: " + length);
    }

    private static void testWordLadder2() {
        WordLadder2 wl2 = new WordLadder2();
        String[] wlArr = new String[] {
                "si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"
        };
        Set<String> wordList = new HashSet<String>();
        List<List<String>> ladders;

        for ( int n=0; n<wlArr.length; n++ ) {
            wordList.add(wlArr[n]);
        }

        ladders = wl2.findLadders("qa", "sq", wordList);
        System.out.println("Total found: " + ladders.size());
        for ( List<String> ladder : ladders ) {
            System.out.print("LADDER: ");
            String comma = "";
            for ( String word : ladder ) {
                System.out.print(comma + word);
                comma = ", ";
            }
            System.out.println();
        }

        String[] wlArr2 = new String[] {
                "kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"
        };

        wordList.clear();
        for ( int n=0; n<wlArr.length; n++ ) {
            wordList.add(wlArr[n]);
        }
        ladders = wl2.findLadders("cet", "ism", wordList);
        System.out.println("Total found: " + ladders.size());
    }

    private static void testWordLadder3() {
        WordLadder3 wl3 = new WordLadder3();
        String[] wlArr = new String[] {
                "si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"
        };
        Set<String> wordList = new HashSet<String>();
        List<List<String>> ladders;

        for ( int n=0; n<wlArr.length; n++ ) {
            wordList.add(wlArr[n]);
        }

        ladders = wl3.findLadders("qa", "sq", wordList);
        System.out.println("Total found: " + ladders.size());
        for ( List<String> ladder : ladders ) {
            System.out.print("LADDER: ");
            String comma = "";
            for ( String word : ladder ) {
                System.out.print(comma + word);
                comma = ", ";
            }
            System.out.println();
        }

        String[] wlArr2 = new String[] {
                "kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"
        };

        wordList.clear();
        for ( int n=0; n<wlArr.length; n++ ) {
            wordList.add(wlArr[n]);
        }
        ladders = wl3.findLadders("cet", "ism", wordList);
        System.out.println("Total found: " + ladders.size());

    }

    private static void testLongestPalindrome() {
        String value = "abb";
        LongestPalindrome lp = new LongestPalindrome();
        String result = lp.longestPalindrome(value);
        System.out.println("Found: " + result);
    }

    private static int lengthOfLongestSubstring(String s) {
        String longestSub = "";

        if ( s.length() <= 1 ) {
            longestSub = s;
        } else {
            int[] poses = new int[256];

            for ( int n=0; n<poses.length; n++ ) {
                poses[n] = -1;
            }

            char[] sArr = s.toCharArray();
            int start = 0;

            for ( int n=0; n<sArr.length; n++ ) {
                int idx = (int)sArr[n];
                if ( poses[idx] >= start ) {
                    if ( n - start > longestSub.length() ) {
                        longestSub = s.substring(start, n);
                    }
                    start = poses[idx] + 1;
                }

                poses[idx] = n;
            }
        }

        return longestSub.length();
    }

    private static void testWordBreak() {
        WordBreak2 wb = new WordBreak2();
        Set<String> wordDict = new HashSet<String>();

        wordDict.add("pea");
        wordDict.add("nut");
        wordDict.add("peanut");
        wordDict.add("butter");

        boolean result = wb.wordBreak("peanutbutter", wordDict);

        System.out.println("Result: " + result);

        wordDict.clear();
        String[] words = { "a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa" };
        for ( int n=0; n<words.length; n++ ) {
            wordDict.add(words[n]);
        }

        result = wb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                wordDict);

        System.out.println("Result: " + result);
    }

    private static void testRotate() {
        int matrix[][] = new int[][] {{ 1, 2, 3, 4, 5 }, { 4, 5, 6, 7, 8 }, { 7, 8, 9, 0, 1 }, { 6, 7, 8, 9, 6}, { 3, 4, 5, 6, 7 }};
        RotateMatrix rm = new RotateMatrix();
        dumpMatrix(matrix);
        rm.rotate(matrix);
        dumpMatrix(matrix);
    }

    private static void dumpMatrix(int[][] matrix) {
        for ( int y=0; y<matrix.length; y++ ) {
            for (int x = 0; x < matrix.length; x++) {
                System.out.print(matrix[y][x] + "  ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private static void testBinaryTreeCodec() {
        BinaryTreeCodec btc = new BinaryTreeCodec();
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(1);

        String serialized = btc.serialize(root);
        System.out.println("Serialized tree: " + serialized);
        TreeNode root2 = btc.deserialize(serialized);
        String serialized2 = btc.serialize(root);
        System.out.println("Serialized tree 2: " + serialized2);
    }

    private static void testLRUCache() {
        LRUCache<String,String> lruCache = new LRUCache<String,String>(5);

        lruCache.put("one", "value one");
        lruCache.put("two", "value two");
        lruCache.put("three", "value three");
        lruCache.put("four", "value four");
        lruCache.put("five", "value five");

        lruCache.get("one");
        lruCache.get("two");
        lruCache.put("six", "value six");

        for (Iterator<String> i = lruCache.keyIterator(); i.hasNext(); ) {
            String key = i.next();
            String value = lruCache.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }

    public static Set<Set<Object>> getAllSubsets(Set<Object> set) {
        Set<Set<Object>> result = new TreeSet<Set<Object>>();

        Set oneSet = new CompSet<Object>();
        result.add(oneSet);
        addSubsets(result, oneSet, set, 0, set.size());
        return result;
    }

    private static void addSubsets(Set<Set<Object>> result, Set<Object> oneSet, Set<Object> set, int start, int length) {
        if ( start <= length ) {
            for ( Object object : set ) {
                if ( !oneSet.contains(object) ) {
                    Set<Object> nextOneSet = new CompSet<Object>(oneSet);
                    nextOneSet.add(object);
                    result.add(nextOneSet);
                    addSubsets(result, nextOneSet, set, start+1, length);
                }
            }
        }
    }

    private static class CompSet<T> extends TreeSet<T> implements Comparable {
        public CompSet() {
            super();
        }

        public CompSet(Set<T> s) {
            super(s);
        }

        private String getSortKey() {
            String key = "";
            for ( T obj : this ) {
                key += obj.toString();
            }
            return key;
        }

        @Override
        public int compareTo(Object o) {
            int result = 1;

            if ( o instanceof CompSet ) {
                String xKey = ((CompSet)o).getSortKey();
                String key = getSortKey();
                if ( key.length() < xKey.length() ) {
                    result = -1;
                } else if ( key.length() > xKey.length() ) {
                    result = 1;
                } else {
                    result = key.compareTo(xKey);
                }
            }

            return result;
        }
    }
}
