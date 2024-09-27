package main;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		//Toi là Nguyen Cong Minh
		//Trong vong 1 thang toi toi se co nguoi yeu
		//Phai chang do la mot chi gai nao do lon tuoi hon toi?
		
        JFrame window = new JFrame(); // Tạo JFrame để quản lý cửa sổ game
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Thoát khi nhấn nút đóng cửa sổ
        window.setResizable(false); // Không cho phép thay đổi kích thước cửa sổ
        window.setTitle("MyGame"); // Đặt tiêu đề cho cửa sổ
        
        GamePanel gamePanel = new GamePanel(); // Tạo đối tượng GamePanel
        window.add(gamePanel); // Thêm GamePanel vào JFrame
        window.pack();
        
        window.setLocationRelativeTo(null); // Đưa cửa sổ vào giữa màn hình
        window.setVisible(true);
    }
}
