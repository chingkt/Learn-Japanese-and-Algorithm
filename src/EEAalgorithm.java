import java.util.ArrayList;

public class EEAalgorithm {

    public void eea(int a, int b){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        eea(0, a, b, list);
    }
    public void eea(int i, int a, int b, ArrayList<ArrayList<Integer>> list){
        list.add(i, new ArrayList<>());
        for (int j = 0; j < 4; j++) {
            list.get(i).add(-1);
        }

        if (i == 0) list.get(i).set(0,a);       //r
        else if (i == 1) list.get(i).set(0,b);
        else if (i >=2 && list.get(i-1).get(0) != 0) {
            int c = list.get(i-2).get(0) % list.get(i-1).get(0);
            list.get(i).set(0,c);
        }
        else if (i >=2 && list.get(i-1).get(0) == 0) list.get(i).set(0,0);
        if (list.get(i).get(0) == 0) return;
        if (i == 0) list.get(i).set(1,1);       //a
        else if (i == 1) list.get(i).set(1,0);
        else if (i >=2 && list.get(i-1).get(0) != 0) {
            int d = list.get(i - 2).get(0) / list.get(i - 1).get(0);
            list.get(i).set(3,d);
            int i_2 = list.get(i-2).get(1);
            int i_1 = list.get(i-1).get(1);

            int sum = i_2 - (i_1 * d);
            list.get(i).set(1, sum);
        }

        else list.get(i).set(2, 0);

        if (i == 0) list.get(i).set(2,0);       //b
        else if (i == 1) list.get(i).set(2,1);
        else if (i >=2 && list.get(i-1).get(0) != 0) {
            int d = list.get(i-2).get(0) / list.get(i-1).get(0);
            list.get(i).set(3,d);
            list.get(i).set(2, list.get(i - 2).get(2) -
                    list.get(i - 1).get(2) * d);
        }
        else list.get(i).set(3, 0);

        System.out.println(i + "  " + list.get(i));
        eea(i+1, a, b, list);
    }
}
