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
        aaa.numAdd(37);
        aaa.check(); // 얘는 수정했음 
//        난 얘만 수정해야징
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

    public void numAdd(int a
//    		,int b
//    		,int c
    		) {
        Set<Integer> fixedNumbers = new HashSet<>(Arrays.asList(a));


        while (lottoList.size() < 5) {
            List<Integer> lotto = newLottoNumber(new HashSet<>(fixedNumbers));
            if (!lotto.isEmpty()) {
                lottoList.add(lotto);
            }
        }
    }

    public List<Integer> newLottoNumber(Set<Integer> numbers) {
        
        while (numbers.size() < 6) {
            int num = numList.get(new Random().nextInt(numList.size()));
            numbers.add(num);
        }
        List<Integer> lotto = new ArrayList<>(numbers);
        lotto.sort(Integer::compareTo);
        
        if (!numCheck(lotto)) {
            return new ArrayList<>(); // 유효하지 않은 경우 빈 리스트를 반환합니다.
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
            System.out.println(lotto);
        }
        System.out.println("=====================================");
    }
}
