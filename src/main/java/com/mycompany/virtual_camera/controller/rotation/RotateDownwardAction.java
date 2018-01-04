package com.mycompany.virtual_camera.controller.rotation;

import com.mycompany.virtual_camera.model.ViewportModel;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Paweł Mac
 */
public class RotateDownwardAction extends AbstractAction {
    
    private final ViewportModel viewportModel;
    
    public RotateDownwardAction(ViewportModel viewportModel) {
        this.viewportModel = viewportModel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.viewportModel.rotateDownward();
    }
}
