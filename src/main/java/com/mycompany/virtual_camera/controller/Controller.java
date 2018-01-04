package com.mycompany.virtual_camera.controller;

import com.mycompany.virtual_camera.controller.motion.MoveBackwardAction;
import com.mycompany.virtual_camera.controller.motion.MoveDownwardAction;
import com.mycompany.virtual_camera.controller.motion.MoveForwardAction;
import com.mycompany.virtual_camera.controller.motion.MoveLeftAction;
import com.mycompany.virtual_camera.controller.motion.MoveRightAction;
import com.mycompany.virtual_camera.controller.motion.MoveUpwardAction;
import com.mycompany.virtual_camera.controller.motion.StepJTextFieldDocumentListener;
import com.mycompany.virtual_camera.model.ViewportModel;
import com.mycompany.virtual_camera.view.View;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author Paweł Mac
 */
public class Controller {
    
    private final ViewportModel viewportModel;
    private final View view;
    
    public Controller(ViewportModel viewportModel, View view) {
        this.viewportModel = viewportModel;
        this.view = view;
        this.addMotionActions();
    }
    
    private void addMotionActions() {
        JTextField stepJTextField = view.getMotionControlJPanel().getStepJTextField();
        stepJTextField.setText(Double.toString(viewportModel.getStep()));
        stepJTextField.setToolTipText("step="+viewportModel.getStep());
        stepJTextField.getDocument().addDocumentListener(new StepJTextFieldDocumentListener(stepJTextField, viewportModel));
        
        
        // get buttons
        JButton moveForwardJButton  = view.getMotionControlJPanel().getMoveForwardJButton();
        JButton moveBackwardJButton = view.getMotionControlJPanel().getMoveBackwardJButton();
        JButton moveLeftJButton     = view.getMotionControlJPanel().getMoveLeftJButton();
        JButton moveRightJButton    = view.getMotionControlJPanel().getMoveRightJButton();
        JButton moveUpwardJButton   = view.getMotionControlJPanel().getMoveUpwardJButton();
        JButton moveDownwardJButton = view.getMotionControlJPanel().getMoveDownwardJButton();
        
        // create actions
        MoveForwardAction  moveForwardAction  = new MoveForwardAction(viewportModel);
        MoveBackwardAction moveBackwardAction = new MoveBackwardAction(viewportModel);
        MoveLeftAction     moveLeftAction     = new MoveLeftAction(viewportModel);
        MoveRightAction    moveRightAction    = new MoveRightAction(viewportModel);
        MoveUpwardAction   moveUpwardAction   = new MoveUpwardAction(viewportModel);
        MoveDownwardAction moveDownwardAction = new MoveDownwardAction(viewportModel);
        
        // add actions
        moveForwardJButton .addActionListener(moveForwardAction);
        moveBackwardJButton.addActionListener(moveBackwardAction);
        moveLeftJButton    .addActionListener(moveLeftAction);
        moveRightJButton   .addActionListener(moveRightAction);
        moveUpwardJButton  .addActionListener(moveUpwardAction);
        moveDownwardJButton.addActionListener(moveDownwardAction);
        
        // bind key with actions
        KeyStroke upKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
        moveForwardJButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(upKeyStroke, upKeyStroke.toString());
        moveForwardJButton.getActionMap().put(upKeyStroke.toString(), moveForwardAction);
        KeyStroke downKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
        moveBackwardJButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(downKeyStroke, downKeyStroke.toString());
        moveBackwardJButton.getActionMap().put(downKeyStroke.toString(), moveBackwardAction);
        KeyStroke leftKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
        moveLeftJButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(leftKeyStroke, leftKeyStroke.toString());
        moveLeftJButton.getActionMap().put(leftKeyStroke.toString(), moveLeftAction);
        KeyStroke rightKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
        moveRightJButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(rightKeyStroke, rightKeyStroke.toString());
        moveRightJButton.getActionMap().put(rightKeyStroke.toString(), moveRightAction);
        KeyStroke ctrlUpKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.CTRL_DOWN_MASK);
        moveUpwardJButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ctrlUpKeyStroke, ctrlUpKeyStroke.toString());
        moveUpwardJButton.getActionMap().put(ctrlUpKeyStroke.toString(), moveUpwardAction);
        KeyStroke ctrlDownKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.CTRL_DOWN_MASK);
        moveDownwardJButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ctrlDownKeyStroke, ctrlDownKeyStroke.toString());
        moveDownwardJButton.getActionMap().put(ctrlDownKeyStroke.toString(), moveDownwardAction);
    }
}
