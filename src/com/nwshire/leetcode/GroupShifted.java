package com.nwshire.leetcode;

import java.util.*;

/**
 * Created by james on 6/1/2016.
 */
public class GroupShifted {
    private static String[] strings = new String[] {"xzv","tvhmtraayghfabutim","scruzaydxrapcuv","xiznzqqjbetchvhndzz","qmbkbjpkxzmnwvo","tttwsszaetyzgsaprv","xdhbxxxomhagohdvdyv","khugdmdbbqjbeuxq","xzzqnowcyplkdxgkbbb","daxzqsdcfuymlyevyfnayb","nrlalrdjqqckogfqlhfhg","akpellndulbbbipbvatbu","pfqeu","dneng","rjnvgxk","eujibxcxetdjztn","aufkyfjuruaq","izeqjoftsfzjkujiubkrb","dwzuyrospzjzuckk","kcuxsetkmzkq","lvej","lzefktml","varaxwjxf","cwdqxivcxeyzhsvqccy","kzxlrqbabvtvkfajbjatzyix","husuheaiirzowtiadgtxwf","swtja","ddvxhgesuenqdgutm","uaduv","t","yvwfcproumulvnbva","ddjikfsnasyj","tqxiqlqkxbmwuytempvg","yihridsxajkiyehmdbru","pbxvdoleubrdd","smavxt","azlrmjwmlsglgwrdakgn","cf","ohkaajphvrorgyx","nll","jlnlqzviffdmegnxig","pqgkqrancnwaqrjovjlgqsfx","azwaipyqlmgoeslujdkwuh","jubooimlfis","sosnjvqikiivlighyktd","jhujjiiovhw","jgbj","qtrbilvqvy","vlmkkilhsqlknvqpus","omuucd","ligpithabxjqtuaf","mz","ognmihotoqgprvbt","nmgwkocmeezb","qmiajlowymr","xmlmolj","cwciqqpbmzzcgmnrvgucezor","ng","lqglykvsxhobqrppeqrlp","ywuytvrproahtgro","etcnjqg","bogjahrw","rrrkddajfq","nwcraujocpk","yo","nhasjwodqyququhhfkyv","tpalgbgirzrl","jjgcsekxxi","r","jgxxttnlhez","ha","jxklqfdizkgzusrzs","hnjctughrsdiyezcqsmij","tvpawacxepvq","lwv","rspgmumnbrzk","gqkdxbkylirxxqrhh","wsbvir","fjktj","rulvjpezzonnbr","kxntnopkkjgliltrlklfgc","h","uplapswlksu","cevzkpfcbviliulexyx","mvbwfqqbeisdsjdnn","giavjwaftarskv","trlhxmqayeiero","yfazdiayalzrnf","qmolgaezbwuodbdhsxclhzi","nskgjmut","gccpj","psmqmdceprjoiw","dhvqyqvnh","jcxq","quvi","pvqdzzwv","yzksz","vnicvmnfwwwmzhsdsm","gn","jcyfpawtcnuikudwuijpd","mmncorzbnoawyo","cwygpjjmrmslabafcmwdhpdo","nikwaflxpepnkz","qmylnzkhz","oc","jnyibizgmwjqjvhbg","ajhaejn","eulboowdyd","vyjfniqjoepdbzulvpgjic","oauvt","vpnmjbnkf","izk","sanouetznnk","truufmplrmsxgvrtl","yuabbnxybbpfgblou","yjyawflsvetbdpcgbjta","cmozvlftrhtxmjqkorxfrql","nbyvnbhjlofqdtilvplcdks","nxmyafxvrfhbuzpzixt","lxtoignhwtcbsi","cycu","rlzjrirwfhwdvolixa","itle","nmitv","cno","mnwjytgktowostuzvrcjxr","etus","othjqfpysicbdhfezxpvhjd","nzypfebzbsaakoky","uimwaktcywogwptihvrrh","pgc","njwftpurketzvjbzivanz","olnrizftjnjixeysi","k","fbwkolpka","vqcxxbcumypdbetrknavgm","ivfnyhqqnjdmdwqslhk","fusfadhqfruriiglvqzuns","r","sghqrdaelollqmczagojceys"};

    public static void main(String[] args) {
        GroupShifted gs = new GroupShifted();
        gs.groupStrings(strings);
    }

    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>> rmap = new HashMap<String,List<String>>();

        Arrays.sort(strings);
        for ( int n=0; n<strings.length; n++ ) {
            char[] sArr = strings[n].toCharArray();
            String key = getKey(sArr);

            List<String> list = rmap.get(key);
            if ( list == null ) {
                list = new ArrayList<String>();
                rmap.put(key, list);
            }

            list.add(strings[n]);
        }

        return new ArrayList<List<String>>(rmap.values());
    }

    String getKey(char[] sArr) {
        StringBuilder key = new StringBuilder(".");

        for ( int n=1; n<sArr.length; n++ ) {
            int interval = sArr[n] - sArr[n-1];
            if ( interval < 0 ) interval += 26;
            key.append(String.valueOf(interval)).append(".");
        }

        return key.toString();
    }
}
