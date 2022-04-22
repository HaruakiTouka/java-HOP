import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class PanelTesting extends JPanel {

    private static final long serialVersionUID = 1L;


//    private static final int NUM1 = 3;
//    private static final int NUM2 = 100;

    public void main(String[] args) {
        new MultiLayout();//从主页进入
    }
    JRadioButton[][] tf;
    public int[][] weight;
    public static int[][] reslut;

    public PanelTesting(Training train, String[][] inputxun) {
        weight=train.gettingWeight();
        reslut= new int[inputxun.length][inputxun[0].length];
        System.out.print( "weight"+" 长度"+" "+inputxun[0].length+inputxun.length+weight.length+"changdu");
        System.out.println();
        for (int i = 0; i < inputxun.length; i++) {
            for (int j = 0; j <inputxun[0].length ; j++) {
                for (int k = 0; k < inputxun[0].length; k++) {

                    reslut[i][j]+=weight[j][k]*Integer.parseInt(inputxun[i][k]);
                }
                System.out.print( weight[i][j]+" ");
            }
            System.out.println();
        }

        for(int i=0;i<reslut.length;i++) {
            for (int j = 0; j < reslut.length; j++) {
                System.out.print(reslut[i][j] + " ");
            }
            System.out.println();
        }
    }

    //获取当前input
    public int[][] getreslut() {
        return this.reslut;
    }
}
