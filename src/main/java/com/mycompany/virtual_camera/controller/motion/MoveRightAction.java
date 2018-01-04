package com.mycompany.virtual_camera.controller.motion;

import com.mycompany.virtual_camera.model.ViewportModel;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Paweł Mac
 */
public class MoveRightAction extends AbstractAction {
    
    private final ViewportModel viewportModel;
    
    public MoveRightAction(ViewportModel viewportModel) {
        this.viewportModel = viewportModel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.viewportModel.moveRight();
    }
}
