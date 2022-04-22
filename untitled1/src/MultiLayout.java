import java.awt.BorderLayout;

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


public class MultiLayout extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;

    // 定义组件
//    JPanel jp1, jp2;
//    JButton jb1, jb2, jb3, jb4, jb5, jb6;

    public static void main(String[] args) {
        new MultiLayout();
    }
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JTextField tf;
    JTextField tf2;
    JTextField tf3;
    JButton bt1;



    public MultiLayout() {
        this.setVisible(true);
        this.setSize(280, 220);
        this.setVisible(true);
        this.setLocation(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel("参数设置界面");
        label2 = new JLabel("学习的模式数量");
        label3 = new JLabel("神经元数量");
        label4 = new JLabel("测试的模式数量");
        tf = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
//        rb1 = new JRadioButton("记住密码");
//        rb2 = new JRadioButton("自动登陆");
        bt1 = new JButton("模型创建");

        // 为指定的 Container 创建 GroupLayout
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);

        // 创建GroupLayout的竖直连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        // 添加间隔
        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup().addComponent(label2).addComponent(label3).addComponent(label4));
        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup().addComponent(label1).addComponent(tf2).addComponent(tf).addComponent(tf3).addComponent(bt1));
        hGroup.addGap(5);
        // 设置水平分组
        layout.setHorizontalGroup(hGroup);

        // 创建GroupLayout的横向连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(label1));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(label2).addComponent(tf));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(label3).addComponent(tf2));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(label4).addComponent(tf3));
        vGroup.addGap(5);
//        vGroup.addGroup(layout.createParallelGroup().addComponent(rb1));
//        vGroup.addGroup(layout.createParallelGroup().addComponent(rb2));
        vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(bt1));
        vGroup.addGap(10);
        // 设置垂直组
        layout.setVerticalGroup(vGroup);

        //添加点击事件监听器（你可以使用任何其他监听，看你想在什么情况下创建新的窗口了）
        //单击按钮执行的方法
        bt1.addActionListener(e -> {
            String heng =tf.getText().trim();
            String zong =tf2.getText().trim();
            String xun =tf3.getText().trim();
            closeThis();
//创建新的窗口
            Modle frame;
            frame = new Modle(heng,zong,xun);
//设置在屏幕的位置
            frame.setLocation(100,50);
// 窗体大小
            frame.setSize(400, 280);
// 显示窗体
            frame.setVisible(true);
        });
    }

    private void closeThis() {
        this.dispose();
    }
}

