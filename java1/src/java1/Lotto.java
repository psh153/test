package java1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Lotto {
    public static void main(String[] args) {
        LottoNum2 aaa = new LottoNum2();    
        aaa.numAdd(26);
        aaa.check();         
//        신기하구만
    }
}

class LottoNum2 {
    private final List<Integer> numList;
    private final List<List<Integer>> lottoList;

    public LottoNum2() {
        numList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numList.add(i);
        }
        lottoList = new ArrayList<>();
    }

    public void numAdd(int a) {
        numList.add(a);
//        numList.add(b);
//        numList.add(c);

        while (lottoList.size() < 5) {
            List<Integer> lotto = newLottoNumber(new HashSet<>(Arrays.asList(a)));
            if (!lotto.isEmpty()) {
                lottoList.add(lotto);
            }
        }
    }

    public List<Integer> newLottoNumber(Set<Integer> numbers) {
        boolean result = true;
        while (numbers.size() < 6) {
            int num = numList.get(new Random().nextInt(numList.size()));
            numbers.add(num);
        }
        List<Integer> lotto = new ArrayList<>(numbers);
        lotto.sort(Integer::compareTo);
        result = numCheck(lotto);
        if (!result) {
            lotto.clear();
        }
        return lotto;
    }

    public boolean numCheck(List<Integer> lotto) {
        for (int num : lotto) {
            boolean c1 = lotto.contains(num + 1);
            boolean c2 = lotto.contains(num + 2);
            if (c1 && c2) {
                return false;
            }
        }
        return true;
    }

    public void check() {
        System.out.println("=====================================");
        for (List<Integer> lotto : lottoList) {
            System.out.println("로또 : " + lotto);
        }
        System.out.println("=====================================");
    }
}
