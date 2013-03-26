package com.ub.pis.app;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.json.JSONException;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.ub.pis.R;
import com.ub.pis.renderer.models.Model;
import com.ub.pis.renderer.scene.Scene;
import com.ub.pis.renderer.utils.ModelUtils;


public class MyGLSurfaceView extends GLSurfaceView{

	private final Renderer renderer;
    private Model m,m2;

    public MyGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);



        // Set the Renderer for drawing on the GLSurfaceView
        Scene scene = new Scene(new FixedCamera());
        
        InputStream fragmentShader = getResources().openRawResource(R.raw.fragmenshader);
        InputStream vertexShader = getResources().openRawResource(R.raw.vertexshader);
        InputStream model = getResources().openRawResource(R.raw.ground);
        InputStream texture = getResources().openRawResource(R.drawable.grasstex);
        InputStream model2 = getResources().openRawResource(R.raw.king);
        InputStream texture2 = getResources().openRawResource(R.drawable.kingtex);
        try {
        	ModelUtils mu;
        	mu = new ModelUtils(model, texture);
        	mu.setShaders(vertexShader, fragmentShader);
        	m2 = mu.loadModel();
        	fragmentShader.reset();
        	vertexShader.reset();
        	
        	mu = new ModelUtils(model2, texture2);
        	mu.setShaders(vertexShader, fragmentShader);
        	m = mu.loadModel();
        	//m.translate(0, 0, 1.5f);
        	m.rotateZ(180);
        	//m.yaw(90);
        	
			scene.add(m);
			scene.add(m2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        renderer = new com.ub.pis.renderer.renderer.Renderer(scene);
        
        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);
        
        setRenderer(renderer);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }

    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mPreviousX;
    private float mPreviousY;
    private float mAngle;
    
    private float xpos;
    private float ypos;
    private float dx;
    private float dy;

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:

                dx = x - mPreviousX;
                dy = y - mPreviousY;

                // reverse direction of rotation above the mid-line
                if (y > getHeight() / 2) {
                  dx = dx * -1 ;
                }

                // reverse direction of rotation to left of the mid-line
                if (x < getWidth() / 2) {
                  dy = dy * -1 ;
                }

                mAngle += (dx + dy) * TOUCH_SCALE_FACTOR;  // = 180.0f / 320
                //requestRender();
                xpos += dx * TOUCH_SCALE_FACTOR;
                ypos += dy * TOUCH_SCALE_FACTOR;
                
                queueEvent(new Runnable() {
                    // This method will be called on the rendering
                    // thread:
                    public void run() {
                    	//m.yaw(xpos);
                    	//m.pitch(-ypos);
                    	
                    	//m.rotateX(ypos);
                    	//m.yaw(xpos);
                    	
                    	m.translate(xpos/30.0f, ypos/30.0f, 0);
                    	//m.translate(-xpos/30.0f, 0, 0);
                    	//m.rotateZ(xpos);
                    	
                    	
                    	
                    	//m.translate(x, y, z)
                    }});
        }
        
        mPreviousX = x;
        mPreviousY = y;
        return true;
    }
    
    public Model getModel() {
    	return m;
    }
}

