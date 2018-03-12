package querytext;

/**
 * Created by mk on 2018/1/18.
 */
public class text {

    public static void main(String[] args) {

        Long start = System.currentTimeMillis();
        String str ="大概老了。我的头发已经苍白，不是很明白的事么？我的手颤抖着，不是很明白的事么？那么我的灵魂的手一定也颤抖着，头发也一定苍白了。。这以前，我的心也曾充满过血腥的歌声：血和铁，火焰和毒，恢复和报仇。而忽然这些都空虚了，但有时故意地填以没奈何的自欺的希望。希望，希望，用这希望的盾，抗拒那空虚中的暗夜的袭来，虽然盾后面也依然是空虚中的暗夜。然而就是如此，陆续地耗尽了我的青春。　我早先岂不知我的青春已经逝去？但以为身外的青春固在：星，月光，僵坠的蝴蝶，暗中的花，猫头鹰的不祥之言，杜鹃的啼血，笑的渺茫，爱的翔舞。……虽然是悲凉漂渺的青春罢，然而究竟是青春。然而现在何以如此寂寞？难道连身外的青春也都逝去，世上的青年也多衰老了么？我只得由我来肉薄这空虚中的暗夜了。我放下了希望之盾，我听到Petofi Sandor(1823-1849)的“希望”之歌";
        String key="大41概11老1了111";
        int index = str.indexOf(key,0);
        System.out.println("========存在为：======"+index);
        Long end = System.currentTimeMillis();
        System.out.println("========用时：======"+(end - start));
    }
}
