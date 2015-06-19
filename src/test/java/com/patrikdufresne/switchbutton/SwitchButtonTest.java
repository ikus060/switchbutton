/*******************************************************************************
 * Copyright (c) 2015 Patrik Dufresne Service Logiciel inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Patrik Dufresne (info at gmail dot com) - general modification
 *******************************************************************************/
package com.patrikdufresne.switchbutton;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class SwitchButtonTest {

    private static SwitchButton createButton(Composite parent, String text) {

        // No text
        Composite comp = new Composite(parent, SWT.BORDER);
        comp.setLayout(new GridLayout(2, false));
        comp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        comp.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));

        Label label = new Label(comp, SWT.NONE);
        label.setText(text);
        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        label.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));

        final SwitchButton button = new SwitchButton(comp, SWT.NONE);
        button.setSelection(true);
        button.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
        return button;
    }

    public static void main(final String[] args) {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setText("SwitchButton Snippet");
        shell.setSize(600, 600);
        shell.setLayout(new GridLayout(1, false));

        // Default
        createButton(shell, "Default button");

        // With a border
        SwitchButton button2 = createButton(shell, "Button with custom text");
        button2.setTextOn("Very long text");
        button2.setTextOff("Off");

        // Disabled
        final SwitchButton button3 = createButton(shell, "Disabled button");
        button3.setEnabled(false);

        // Without glow effect
        final SwitchButton button4 = createButton(shell, "Without glow effect");
        button4.setFocusColor(null);

        // Round
        final SwitchButton button5 = createButton(shell, "Round");
        button5.setRound(10);

        // Square
        final SwitchButton button6 = createButton(shell, "Square");
        button6.setRound(0);

        // Full of color
        final SwitchButton button7 = createButton(shell, "With custom colours");
        button7.setButtonBackgroundColor(display.getSystemColor(SWT.COLOR_DARK_BLUE));

        button7.setSelectedBackgroundColor(display.getSystemColor(SWT.COLOR_BLACK));
        button7.setSelectedForegroundColor(display.getSystemColor(SWT.COLOR_WHITE));

        button7.setUnselectedBackgroundColor(display.getSystemColor(SWT.COLOR_RED));
        button7.setUnselectedForegroundColor(display.getSystemColor(SWT.COLOR_GRAY));

        // Listeners
        final SwitchButton button8 = createButton(shell, "Button with listeners");
        button8.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(final SelectionEvent e) {
                System.out.println("Before clicking, the selection was... " + button8.getSelection());
            }

            @Override
            public void widgetDefaultSelected(final SelectionEvent e) {
            }
        });

        // Listeners with doit=false !
        final SwitchButton button9 = createButton(shell, "Listeners with doit=false");
        button9.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(final SelectionEvent e) {
                System.out.println("I don't want this");
                e.doit = false;
            }

            @Override
            public void widgetDefaultSelected(final SelectionEvent e) {
            }
        });

        // Change font
        final SwitchButton button10 = createButton(shell, "With different font");
        final Font font = new Font(display, "Courier New", 18, SWT.BOLD | SWT.ITALIC);
        shell.addDisposeListener(new DisposeListener() {

            @Override
            public void widgetDisposed(final DisposeEvent e) {
                font.dispose();
            }
        });
        button10.setFont(font);

        // A button alone
        Label label = new Label(shell, SWT.NONE);
        label.setText("A button alone");
        final SwitchButton button11 = new SwitchButton(shell, SWT.NONE);
        button11.setSelection(true);
        button11.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

        // A buttons with a custom layout
        Label label2 = new Label(shell, SWT.NONE);
        label2.setText("With custom layout: GridData(SWT.FILL, SWT.FILL, true, true)");
        final SwitchButton button12 = new SwitchButton(shell, SWT.NONE);
        button12.setSelection(true);
        button12.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();

    }

}
