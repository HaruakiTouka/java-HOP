import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

public class PanelInput extends JPanel {

    private static final long serialVersionUID = 1L;
//    private static final int NUM1 = 3;
//    private static final int NUM2 = 100;

    public static void main(String[] args) {
        new MultiLayout();//从主页进入
    }

    String[][] input ;
    JRadioButton[][] tf;
    JPanel jPanel;
    public PanelInput(String heng,String zong,String text) {
        //JFrame jf = new JFrame("测试窗口");
        this.setVisible(true);
        this.setSize(250, 220);
        this.setVisible(true);
        //this.setLocation(400, 200);

        //jPanel输入矩阵
        jPanel = new JPanel();
        //this.add(jPanel);

//        JPanel jPanelw = new JPanel();
        JLabel lb;
        lb = new JLabel(text);
//        jPanelw.add(lb);
//        this.add(jPanelw);
        this.add(jPanel);


        input=new String[Integer.parseInt(heng)][Integer.parseInt(zong)];

        tf = new JRadioButton[Integer.parseInt(heng)][Integer.parseInt(zong)];

        JLabel[] jLabels = new JLabel[Integer.parseInt(heng)];

//        jLabels[0] = new JLabel("第0个Label");  	// that's the key
//        jPanel.add(jLabels[0]);
//        jLabels[1] = new JLabel("第1个Label");  	// that's the key
//        jPanel.add(jLabels[1]);
//        jLabels[2] = new JLabel("第2个Label");  	// that's the key
//        jPanel.add(jLabels[2]);
// 添加进进面板
        for(int i = 0; i < Integer.parseInt(heng); i++) {
            jLabels[i]= new JLabel("第"+i+"个模式:");
            for (int j = 0; j < Integer.parseInt(zong); j++) {
                tf[i][j] = new JRadioButton();  	// that's the key
                jPanel.add(tf[i][j]);
                input[i][j] ="-1";
            }
        }

        GroupLayout layout = new GroupLayout(jPanel);
        jPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        //创建GroupLayout的竖直连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        // 添加间隔
        hGroup.addGap(5);
        for (int j = 0; j < Integer.parseInt(zong)+1; j++) {
            GroupLayout.ParallelGroup miglayout;
            miglayout= layout.createParallelGroup();
            for (int i = 0; i < Integer.parseInt(heng); i++) {
                if(j==0) {
                    if(i==0){
                        miglayout.addComponent(lb);
                    }
                    miglayout.addComponent(jLabels[i]);
                }
                else{
                    miglayout.addComponent(tf[i][j-1]);
                }
            }
            hGroup.addGroup(miglayout);
            hGroup.addGap(5);
        }
        // 设置水平分组
        layout.setHorizontalGroup(hGroup);

        // 创建GroupLayout的水平连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(lb));
        vGroup.addGap(10);
        for (int i = 0; i < Integer.parseInt(heng); i++) {
            GroupLayout.ParallelGroup miglayout;
            miglayout= layout.createParallelGroup();
            miglayout.addComponent(jLabels[i]);
            for (int j = 0; j < Integer.parseInt(zong); j++) {
                miglayout.addComponent(tf[i][j]);
            }
            vGroup.addGroup(miglayout);
            vGroup.addGap(5);
        }
//        for (int i = 0; i < Integer.valueOf(heng).intValue(); i++) {
//            vGroup.addGroup(layout.createParallelGroup().addComponent(jLabels[i]));
//            vGroup.addGap(10);
//        }
        // 设置垂直组
        layout.setVerticalGroup(vGroup);



    }

    //获取当前input
    public String[][] getInput(String heng,String zong) {
        for (int i = 0; i < Integer.parseInt(heng); i++) {
            for (int j = 0; j < Integer.parseInt(zong); j++) {
//                for(Component c:jPanel.getComponents()){
//                    if(c instanceof JRadioButton){
                        if(tf[i][j].isSelected()){
                            System.out.print("第"+i+"行"+j+"列选中");
                            System.out.println();
                            input[i][j] ="1";
                        }
                        else{
                            input[i][j] ="-1";
                        }
//                    }
//                }
            }
        }
        return this.input;
    }

    public void changeshow(int[][] getreslut) {
        for (int i = 0; i < getreslut.length; i++) {
            for (int j = 0; j < getreslut[0].length; j++) {
                if(getreslut[i][j]>=0){
                    System.out.print("第"+i+"行"+j+"列选中");
                    System.out.println();
//                    input[i][j] ="1";
                    tf[i][j].setSelected(true);
                }else{
                    tf[i][j].setSelected(false);
                }
            }
        }
    }
}
