package client.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import util.ColorSet;
import util.CommonPanel;

public class ErrorMessagePanel extends CommonPanel {

  private JLabel errorMessageLabel;

  private JButton backButton;

  public ErrorMessagePanel(String text) {

    showErrorMessage(text);
    
    backButton = goBackButton("뒤로가기"); 
    backButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        if (text.equals("회원가입")) {
          JoinMembershipPanel memPanel = new JoinMembershipPanel();
          MainPanel.frame.change(memPanel);
        } else if (text.equals("로그인")) {
          LoginPanel loginPanel = new LoginPanel();
          MainPanel.frame.change(loginPanel);
        }
      }
    });
  }

  private void showErrorMessage(String text) {

    errorMessageLabel = new JLabel(text + "이 실패했습니다.");
    errorMessageLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
    errorMessageLabel.setBounds(80, 250, 500, 50);
    add(errorMessageLabel);

  }

  private JButton goBackButton(String text) {

    backButton = new JButton(text);
    backButton.setFont(new Font("맑은 고딕", Font.BOLD, 14));
    backButton.setForeground(Color.WHITE);
    backButton.setBackground(ColorSet.BackButtonColor);
    backButton.setBounds(100, 480, 180, 40);
    add(backButton);


   return backButton;
  };

}
