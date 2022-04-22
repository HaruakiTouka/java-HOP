import javax.swing.*;



public class Training {

    public static void main(String[] args) {
        new MultiLayout();//从主页进入
    }
    public int[][] weight;
    
    
    public Training(String[][] input) {
        weight=new int[input[0].length][input[0].length];
        for (int i = 0; i < input[0].length; i++) {
            System.out.print("第"+i+"行权重");
            for (int j = 0; j < input[0].length; j++) {
                if (i==j){
                    weight[i][j]=0;
                }else{
                    for (int k = 0; k <input.length ; k++) {
                        weight[i][j]+=Integer.parseInt(input[k][i])*Integer.parseInt(input[k][j]);

                    }
                }
                System.out.print( weight[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[][] gettingWeight() {
        return this.weight;
    }
}
