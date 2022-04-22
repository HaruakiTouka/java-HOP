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

public class Modle extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
//    private static final int NUM1 = 3;
//    private static final int NUM2 = 100;

    public static void main(String[] args) {
        new MultiLayout();//从主页进入
    }

    public Modle(String heng,String zong,String xun) {
        GridBagConstraints gbc = new GridBagConstraints();

        //JFrame jf = new JFrame("测试窗口");
        this.setVisible(true);
        this.setSize(400, 280);
        this.setVisible(true);
        this.setLocation(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());


        //实例化PanelInput
        PanelInput jPanel= new PanelInput(heng,zong,"学习的样本");
        PanelInput jPanelxun= new PanelInput(xun,zong,"测试的样本");

        PanelInput jPanelshow=new PanelInput(xun,zong,"结果展示");


        //主菜单实例化
        JPanel mainpanel=new JPanel();
        JButton btinput = new JButton("开始训练");
        JLabel label1=new JLabel("训练次数");
        JTextField tf= new JTextField(5);

        GroupLayout layout = new GroupLayout(mainpanel);
        mainpanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        //创建GroupLayout的竖直连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        // 添加间隔
        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup().addComponent(label1).addComponent(tf).addComponent(btinput));
        hGroup.addGap(5);
        // 设置水平分组
        layout.setHorizontalGroup(hGroup);
        // 创建GroupLayout的横向连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(label1));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(tf));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(btinput));
        vGroup.addGap(10);
        // 设置垂直组
        layout.setVerticalGroup(vGroup);


        gbc.gridx = 0;//起始点列
        gbc.gridy = 0;//起始点行
        gbc.fill = GridBagConstraints.BOTH;//自动充满全部界面
        gbc.gridwidth = 1;//组件宽度
        gbc.weightx = 1;//分布宽度
        gbc.weighty = 1;//分布高度
        this.add(jPanel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        this.add(jPanelxun, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        this.add(mainpanel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        this.add(jPanelshow, gbc);

        btinput.addActionListener(e -> {
            String xunnuber =tf.getText().trim();

            String input[][]=jPanel.getInput(heng,zong);//tf.getText().trim();
            for(int i=0;i<input.length;i++) {
                System.out.print("第"+i+"行");
                for (int j = 0; j < input[0].length; j++) {
                    System.out.print(input[i][j] + " ");
                }
                System.out.println();
            }
            Training train= new Training(input);
            String inputxun[][]=jPanelxun.getInput(xun,zong);//tf.getText().trim();
            for(int i=0;i<inputxun.length;i++) {
                System.out.print("第"+i+"行训练");
                for (int j = 0; j < inputxun[0].length; j++) {
                    System.out.print(inputxun[i][j] + " ");
                }
                System.out.println();
            }
            System.out.print(input[0][0] + " ");
            PanelTesting test= new PanelTesting(train,inputxun);
            for(int i=0;i<test.getreslut().length;i++) {
                System.out.print("第"+i+"行结果");
                for (int j = 0; j < test.getreslut()[0].length; j++) {
                    System.out.print(test.getreslut()[i][j] + " ");
                }
                System.out.println();
            }
            jPanelshow.changeshow(test.getreslut());
        });
    }
}
