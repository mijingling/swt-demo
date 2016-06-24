package com;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class MyWin {
	private static final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private static Text text;
	/**
	 * @wbp.nonvisual location=380,147
	 */
	private static final TrayItem trayItem = new TrayItem(Display.getDefault().getSystemTray(), SWT.NONE);

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

		Button btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setBounds(44, 74, 97, 17);
		btnRadioButton.setText("Radio Button");

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(61, 26, 80, 27);
		btnNewButton.setText("New Button");

		Button btnCheckButton = new Button(shell, SWT.CHECK);
		btnCheckButton.setBounds(61, 128, 98, 17);
		btnCheckButton.setText("Check Button");

		Spinner spinner = new Spinner(shell, SWT.BORDER);
		spinner.setBounds(94, 171, 47, 23);

		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(238, 74, 88, 25);

		Slider slider = new Slider(shell, SWT.NONE);
		slider.setBounds(177, 138, 170, 17);

		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(210, 157, 88, 24);

		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setBounds(304, 188, 64, 64);

		Section sctnNewSection = formToolkit.createSection(shell, Section.TWISTIE | Section.TITLE_BAR);
		sctnNewSection.setBounds(210, 26, 103, 23);
		formToolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("New Section");

		text = new Text(shell, SWT.BORDER);
		text.setBounds(94, 200, 73, 23);
		formToolkit.adapt(text, true, true);

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(210, 221, 61, 17);
		formToolkit.adapt(lblNewLabel, true, true);
		lblNewLabel.setText("New Label");

		Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setBounds(10, 151, 88, 25);
		formToolkit.adapt(combo_1);
		formToolkit.paintBordersFor(combo_1);

		DropTarget dropTarget = new DropTarget(shell, DND.DROP_MOVE);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
