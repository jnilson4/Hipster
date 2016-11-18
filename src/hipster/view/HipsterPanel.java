package hipster.view;

import javax.swing.*;
import hipster.controller.HipsterController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HipsterPanel extends JPanel
{
	private HipsterController baseController;
	private JButton myButton;
	private JComboBox dropDown;
	private JLabel wordsLabel;
	private SpringLayout baseLayout;
	
	public HipsterPanel(HipsterController baseController)
	{
		
		super();
		this.baseController = baseController;
		myButton = new JButton("Click here!!");
		wordsLabel = new JLabel("such words!");
		baseLayout = new SpringLayout();
		dropDown = new JComboBox(baseController.getHipsters());
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.ORANGE);
		this.add(myButton);
		this.add(wordsLabel);
		this.add(dropDown);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, wordsLabel, 26, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, wordsLabel, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, myButton, -22, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, myButton, -165, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, dropDown, 40, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, dropDown, -64, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	{
		dropDown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				String selectedText = baseController.getHipsters()[dropDown.getSelectedIndex()].toString();
				wordsLabel.setText(selectedText);
			}
		});
		
		myButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.impactHipsters();
				//wordsLabel.setText(baseController.getHipsters()[dropDown.getSelectedIndex()].toString());
				repaint();
			}
		});
	}
}
