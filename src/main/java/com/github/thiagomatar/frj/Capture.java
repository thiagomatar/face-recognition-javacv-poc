package com.github.thiagomatar.frj;

import org.bytedeco.javacv.*;

import java.awt.event.KeyEvent;

public class Capture {

    public static void main(String[] args) throws FrameGrabber.Exception {
        KeyEvent key = null;
        OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();
        OpenCVFrameGrabber camera = new OpenCVFrameGrabber(2);
        camera.start();

        CanvasFrame cFrame = new CanvasFrame("Preview", CanvasFrame.getDefaultGamma() / camera.getGamma());
        Frame capturedFrame = null;
        while ((capturedFrame = camera.grab()) != null){
            if(cFrame.isVisible()){
                cFrame.showImage(capturedFrame);
            }
            cFrame.dispose();
        }

    }

}
